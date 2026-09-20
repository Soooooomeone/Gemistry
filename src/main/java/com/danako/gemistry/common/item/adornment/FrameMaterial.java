package com.danako.gemistry.common.item.adornment;

import net.minecraft.network.chat.Component;

import java.util.Locale;

public enum FrameMaterial {

    COPPER(5, 0xE0734A), IRON(15, 0xD8D8D8), GOLD(30, 0xFFD700), NETHERITE(50, 0xA08A8A);

    private final int potency;
    private final int color;
    private final String serializedName;
    private final String translationKey;

    FrameMaterial(int potency, int color) {
        this.potency = potency;
        this.color = color;
        this.serializedName = this.name().toLowerCase(Locale.ROOT);
        this.translationKey = "tooltip.gemistry.frame_material." + this.serializedName;
    }

    public static int maxPotency() {
        int max = 0;
        for (FrameMaterial material : values()) {
            max = Math.max(max, material.potency);
        }
        return max;
    }

    public static FrameMaterial byName(String name) {
        for (FrameMaterial value : values()) {
            if (value.serializedName.equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No FrameMaterial named " + name);
    }

    public int potency() {
        return this.potency;
    }

    public int color() {
        return this.color;
    }

    public String serializedName() {
        return this.serializedName;
    }

    public Component displayName() {
        return Component.translatable(this.translationKey);
    }
}
