package com.danako.gemistry.common.item;

import com.danako.gemistry.common.item.adornment.FrameMaterial;
import com.danako.gemistry.common.item.gem.GemTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;

public final class Potency {

    public static final int MIN = 0;

    public static final int MAX = FrameMaterial.maxPotency() + GemTier.maxPotency();

    private static final int LOW_COLOR = 0x9BA1A6;
    private static final int MID_COLOR = 0x62D89A;
    private static final int HIGH_COLOR = 0x4AB8FF;
    private static final int PEAK_COLOR = 0xFFD700;

    private Potency() {
    }

    public static int combine(int framePotency, int gemPotency) {
        return Mth.clamp(framePotency + gemPotency, MIN, MAX);
    }

    public static int combine(FrameMaterial material, GemTier tier) {
        return combine(material.potency(), tier.potency());
    }

    public static String format(int potency) {
        return "+" + potency + "%";
    }

    public static int color(int potency) {
        if (potency >= MAX) {
            return PEAK_COLOR;
        }
        float ratio = MAX <= 0 ? 0.0F : (float) potency / (float) MAX;
        if (ratio < 0.25F) {
            return LOW_COLOR;
        }
        if (ratio < 0.55F) {
            return MID_COLOR;
        }
        return HIGH_COLOR;
    }

    public static Component line(int potency) {
        MutableComponent line = Component.translatable("tooltip.gemistry.potency").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));
        line.append(Component.literal(" "));
        line.append(Component.literal(format(potency)).withStyle(Style.EMPTY.withColor(color(potency))));
        return line;
    }

    public static Component hint() {
        return Component.translatable("tooltip.gemistry.potency.hint", Component.literal(format(MAX))).withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true));
    }
}
