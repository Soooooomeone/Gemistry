package com.danako.gemistry.common.item.tooltip;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public interface TooltipSection {

    boolean appliesTo(ItemStack stack);

    void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipFlag flag, List<Component> lines);
}
