package io.github.vampirestudios.raa.mixin;

import io.github.vampirestudios.raa.items.RAASwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract ItemStack getActiveItem();

    @Shadow private LivingEntity attacking;

    @Overwrite
    public void attackLivingEntity(LivingEntity livingEntity) {
        if (this.getActiveItem().getItem() instanceof RAASwordItem) {
            if (((RAASwordItem)this.getActiveItem().getItem()).material.hasEffect()) {
                ((RAASwordItem)this.getActiveItem().getItem()).material.getMaterialEffect().getTarget().apply(this.attacking, livingEntity, ((RAASwordItem)this.getActiveItem().getItem()).material);
            }
        }
    }

}
