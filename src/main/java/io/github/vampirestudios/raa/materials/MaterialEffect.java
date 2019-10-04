package io.github.vampirestudios.raa.materials;

import net.minecraft.util.Identifier;

public class MaterialEffect {
    private Identifier identifier;
    private int amplifier;
    private int duration;

    public Identifier getIdentifier() {
        return identifier;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public int getDuration() {
        return duration;
    }
}
