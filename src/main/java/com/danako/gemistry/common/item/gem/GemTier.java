package com.danako.gemistry.common.item.gem;

import net.minecraft.network.chat.Component;

import java.util.Locale;

public enum GemTier {

    COMMON(0, 5, 0x55FF55), UNCOMMON(1, 10, 0x55FFFF), RARE(2, 15, 0x4A6BFF), EPIC(3, 20, 0xB43DF0), LEGENDARY(4, 25, 0xFFD700);

    public static final int MAX_TIER = LEGENDARY.tier;

    private final int tier;
    private final int potency;
    private final int color;
    private final String translationKey;

    GemTier(int tier, int potency, int color) {
        this.tier = tier;
        this.potency = potency;
        this.color = color;
        this.translationKey = "tooltip.gemistry.gem_tier." + this.name().toLowerCase(Locale.ROOT);
    }

    public static int maxPotency() {
        int max = 0;
        for (GemTier value : values()) {
            max = Math.max(max, value.potency);
        }
        return max;
    }

    public static GemTier byTier(int tier) {
        for (GemTier value : values()) {
            if (value.tier == tier) {
                return value;
            }
        }
        throw new IllegalArgumentException("No GemTier with tier " + tier);
    }

    public int tier() {
        return this.tier;
    }

    public int potency() {
        return this.potency;
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
}