package com.danako.gemistry.common.item.gem;

import com.danako.gemistry.core.enchantment.GemistryAttunementTheme;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;

import java.util.Locale;

public enum GemCatalyst {

    PYRIC(GemistryAttunementTheme.PYRIC, 0xFF0000),
    BOREAL(GemistryAttunementTheme.BOREAL, 0x2E9BF0),
    ABYSSAL(GemistryAttunementTheme.ABYSSAL, 0x0099A8),
    MIASMIC(GemistryAttunementTheme.MIASMIC, 0xFF8C00),
    UMBRAL(GemistryAttunementTheme.UMBRAL, 0x123B3D);

    private final GemistryAttunementTheme theme;
    private final int color;
    private final String translationKey;

    GemCatalyst(GemistryAttunementTheme theme, int color) {
        this.theme = theme;
        this.color = color;
        this.translationKey = "tooltip.gemistry.gem_catalyst." + this.name().toLowerCase(Locale.ROOT);
    }

    public GemistryAttunementTheme theme() {
        return this.theme;
    }

    public int color() {
        return this.color;
    }

    public Component displayName() {
        return Component.translatable(this.translationKey);
    }

    @Nullable
    public static GemCatalyst fromTheme(GemistryAttunementTheme theme) {
        for (GemCatalyst catalyst : values()) {
            if (catalyst.theme == theme) {
                return catalyst;
            }
        }
        return null;
    }
}