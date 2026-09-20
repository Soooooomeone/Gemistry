package com.danako.gemistry.common.item.adornment;

import net.minecraft.network.chat.Component;

import java.util.Locale;

public enum AdornmentType {

    RING, BRACELET, BELT;

    private final String serializedName;
    private final String translationKey;

    AdornmentType() {
        this.serializedName = this.name().toLowerCase(Locale.ROOT);
        this.translationKey = "tooltip.gemistry.adornment." + this.serializedName;
    }

    public static AdornmentType byName(String name) {
        for (AdornmentType value : values()) {
            if (value.serializedName.equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No AdornmentType named " + name);
    }

    public String serializedName() {
        return this.serializedName;
    }

    public Component displayName() {
        return Component.translatable(this.translationKey);
    }
}
