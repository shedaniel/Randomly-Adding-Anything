package io.github.vampirestudios.raa.materials;

import io.github.vampirestudios.raa.api.enums.EffectTarget;
import net.minecraft.util.Identifier;

public class MaterialEffect {
    private Identifier identifier;
    private int amplifier;
    private int duration;
    private EffectTarget target;

    public MaterialEffect(Identifier identifier, int amplifier, int duration, EffectTarget target) {
        this.identifier = identifier;
        this.amplifier = amplifier;
        this.duration = duration;
        this.target = target;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public int getDuration() {
        return duration;
    }

    public EffectTarget getTarget() {
        return target;
    }
}
