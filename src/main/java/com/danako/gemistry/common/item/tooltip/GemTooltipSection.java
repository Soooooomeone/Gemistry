package com.danako.gemistry.common.item.tooltip;

import com.danako.gemistry.common.item.gem.GemCatalyst;
import com.danako.gemistry.common.item.gem.GemProperties;
import com.danako.gemistry.common.item.gem.GemRegistry;
import com.danako.gemistry.common.item.gem.GemTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.Optional;

public final class GemTooltipSection implements TooltipSection {

    private static final Style LABEL_STYLE = Style.EMPTY.withColor(ChatFormatting.GRAY);
    private static final Style NONE_STYLE = Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true);
    private static final Style ADVANCED_STYLE = Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true);

    private static final String FILLED_STAR = "\u2605"; // ★
    private static final String HOLLOW_STAR = "\u2606"; // ☆
    private static final int HOLLOW_COLOR = 0x545454;
    private static final String CATALYST_BULLET = "\u25CF "; // ●

    @Override
    public boolean appliesTo(ItemStack stack) {
        return GemRegistry.isGem(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipFlag flag, List<Component> lines) {
        Optional<GemProperties> properties = GemRegistry.get(stack);
        if (properties.isEmpty()) {
            return;
        }

        GemProperties gem = properties.get();
        lines.add(CommonComponents.EMPTY);
        lines.add(tierLine(gem.tier()));
        lines.add(catalystLine(gem.catalyst()));

        if (flag.isAdvanced()) {
            lines.add(advancedLine(gem));
        }
    }

    private static Component tierLine(GemTier tier) {
        MutableComponent line = Component.translatable("tooltip.gemistry.gem_tier").withStyle(LABEL_STYLE);
        line.append(Component.literal(" "));

        Style tierStyle = Style.EMPTY.withColor(tier.color());
        line.append(tier.displayName().copy().withStyle(tierStyle));
        line.append(Component.literal(" "));

        for (int star = 0; star < GemTier.MAX_TIER + 1; star++) {
            boolean filled = star < tier.stars();
            Style starStyle = Style.EMPTY.withColor(filled ? tier.color() : HOLLOW_COLOR);
            line.append(Component.literal(filled ? FILLED_STAR : HOLLOW_STAR).withStyle(starStyle));
        }
        return line;
    }

    private static Component catalystLine(GemCatalyst catalyst) {
        MutableComponent line = Component.translatable("tooltip.gemistry.gem_catalyst").withStyle(LABEL_STYLE);
        line.append(Component.literal(" "));
        if (catalyst == null) {
            line.append(Component.translatable("tooltip.gemistry.gem_catalyst.none").withStyle(NONE_STYLE));
        } else {
            MutableComponent value = Component.literal(CATALYST_BULLET).append(catalyst.displayName());
            line.append(value.withStyle(Style.EMPTY.withColor(catalyst.color())));
        }
        return line;
    }

    private static Component advancedLine(GemProperties gem) {
        String catalystId = gem.hasCatalyst() ? gem.catalyst().theme().name() : "none";
        return Component.literal("Tier " + gem.tier().tier() + "/" + GemTier.MAX_TIER + " (" + gem.tier().stars() + "\u2605) \u2022 Catalyst: " + catalystId)
                .withStyle(ADVANCED_STYLE);
    }
}