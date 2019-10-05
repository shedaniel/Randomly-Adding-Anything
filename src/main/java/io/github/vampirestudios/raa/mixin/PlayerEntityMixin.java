package io.github.vampirestudios.raa.mixin;

import io.github.vampirestudios.raa.items.RAASwordItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin extends Entity {

    public PlayerEntityMixin(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Shadow public abstract ItemStack getActiveItem();

    @Inject(method = "damage", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;limbDistance:F", opcode = Opcodes.PUTFIELD, ordinal = 0))
    public void customEffects(DamageSource damageSource_1, float float_1, CallbackInfoReturnable<Boolean> cir) {
        Item item = this.getActiveItem().getItem();
        if (item instanceof RAASwordItem) {
            RAASwordItem swordItem = (RAASwordItem) item;
            if (swordItem.material.hasEffect()) {
                swordItem.material.getMaterialEffect().getTarget().apply((LivingEntity) damageSource_1.getSource(), (LivingEntity) ((Entity) this), swordItem.material);
            }
        }
    }

}
