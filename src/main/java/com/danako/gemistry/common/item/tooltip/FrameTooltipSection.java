package com.danako.gemistry.common.item.tooltip;

import com.danako.gemistry.common.item.Potency;
import com.danako.gemistry.common.item.adornment.FrameProperties;
import com.danako.gemistry.common.item.adornment.FrameRegistry;
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

public final class FrameTooltipSection implements TooltipSection {

    private static final Style LABEL_STYLE = Style.EMPTY.withColor(ChatFormatting.GRAY);
    private static final Style NONE_STYLE = Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true);
    private static final Style ADVANCED_STYLE = Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true);

    private static final Style ADORNMENT_STYLE = Style.EMPTY.withColor(0xE8E3D3);

    private static Component adornmentLine(FrameProperties frame) {
        MutableComponent line = Component.translatable("tooltip.gemistry.adornment").withStyle(LABEL_STYLE);
        line.append(Component.literal(" "));
        line.append(frame.adornment().displayName().copy().withStyle(ADORNMENT_STYLE));
        return line;
    }

    private static Component materialLine(FrameProperties frame) {
        MutableComponent line = Component.translatable("tooltip.gemistry.frame_material").withStyle(LABEL_STYLE);
        line.append(Component.literal(" "));
        line.append(frame.material().displayName().copy().withStyle(Style.EMPTY.withColor(frame.material().color())));
        return line;
    }

    private static Component gemLine() {
        MutableComponent line = Component.translatable("tooltip.gemistry.frame_gem").withStyle(LABEL_STYLE);
        line.append(Component.literal(" "));
        line.append(Component.translatable("tooltip.gemistry.frame_gem.empty").withStyle(NONE_STYLE));
        return line;
    }

    private static Component advancedLine(FrameProperties frame) {
        String text = "Frame: " + frame.material().serializedName() + " \u2022 Adornment: " + frame.adornment().serializedName() + " \u2022 Potency: " + Potency.format(frame.potency()) + "/" + Potency.format(Potency.MAX);
        return Component.literal(text).withStyle(ADVANCED_STYLE);
    }

    @Override
    public boolean appliesTo(ItemStack stack) {
        return FrameRegistry.isFrame(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipFlag flag, List<Component> lines) {
        Optional<FrameProperties> properties = FrameRegistry.get(stack);
        if (properties.isEmpty()) {
            return;
        }

        FrameProperties frame = properties.get();
        lines.add(CommonComponents.EMPTY);
        lines.add(adornmentLine(frame));
        lines.add(materialLine(frame));
        lines.add(Potency.line(frame.potency()));
        lines.add(gemLine());
        lines.add(CommonComponents.EMPTY);
        lines.add(Potency.hint());

        if (flag.isAdvanced()) {
            lines.add(advancedLine(frame));
        }
    }
}
