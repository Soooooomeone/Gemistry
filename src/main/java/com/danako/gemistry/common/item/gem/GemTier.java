package com.danako.gemistry.common.item.gem;

import net.minecraft.network.chat.Component;

import java.util.Locale;

public enum GemTier {

    COMMON(0, 0x55FF55),
    UNCOMMON(1, 0x55FFFF),
    RARE(2, 0x4A6BFF),
    EPIC(3, 0xB43DF0),
    LEGENDARY(4, 0xFFD700);

    public static final int MAX_TIER = LEGENDARY.tier;

    private final int tier;
    private final int color;
    private final String translationKey;

    GemTier(int tier, int color) {
        this.tier = tier;
        this.color = color;
        this.translationKey = "tooltip.gemistry.gem_tier." + this.name().toLowerCase(Locale.ROOT);
    }

    public int tier() {
        return this.tier;
    }

    public int stars() {
        return this.tier + 1;
    }

    public int color() {
        return this.color;
    }

    public Component displayName() {
        return Component.translatable(this.translationKey);
    }

    public static GemTier byTier(int tier) {
        for (GemTier value : values()) {
            if (value.tier == tier) {
                return value;
            }
        }
        throw new IllegalArgumentException("No GemTier with tier " + tier);
    }
}