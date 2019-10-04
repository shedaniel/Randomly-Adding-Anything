package io.github.vampirestudios.raa.api.enums;

import io.github.vampirestudios.raa.materials.Material;
import io.github.vampirestudios.raa.materials.MaterialEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;
import java.util.function.Supplier;

public enum EffectTarget {
    USER((owner, target, material) -> {
        MaterialEffect materialEffect = material.getMaterialEffect();
        StatusEffect statusEffect = Registry.STATUS_EFFECT.get(materialEffect.getIdentifier());
        owner.addStatusEffect(new StatusEffectInstance(statusEffect, materialEffect.getDuration(), materialEffect.getAmplifier(),
                false, false, true));
    }),
    TARGET((owner, target, material) -> {
        MaterialEffect materialEffect = material.getMaterialEffect();
        StatusEffect statusEffect = Registry.STATUS_EFFECT.get(materialEffect.getIdentifier());
        target.addStatusEffect(new StatusEffectInstance(statusEffect, materialEffect.getDuration(), materialEffect.getAmplifier(),
                false, false, true));
    }),
    BOTH((owner, target, material) -> {
        MaterialEffect materialEffect = material.getMaterialEffect();
        StatusEffect statusEffect = Registry.STATUS_EFFECT.get(materialEffect.getIdentifier());
        owner.addStatusEffect(new StatusEffectInstance(statusEffect, materialEffect.getDuration(), materialEffect.getAmplifier(),
                false, false, true));
        target.addStatusEffect(new StatusEffectInstance(statusEffect, materialEffect.getDuration(), materialEffect.getAmplifier(),
                false, false, true));
    });

    EffectTargetFunction effectTargetFunction;

    EffectTarget(EffectTargetFunction effectTargetFunction) {
        this.effectTargetFunction = effectTargetFunction;
    }

    public void apply(LivingEntity owner, LivingEntity target, Material material) {
        this.effectTargetFunction.apply(owner, target, material);
    }

    private interface EffectTargetFunction {
        void apply(LivingEntity owner, LivingEntity target, Material material);
    }
}
