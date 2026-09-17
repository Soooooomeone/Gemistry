package com.danako.gemistry.common.item.tooltip;

import com.danako.gemistry.Gemistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = Gemistry.MODID)
public final class GemistryTooltipHandler {

    private static final List<TooltipSection> SECTIONS = List.of(
            new GemTooltipSection()
    );

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        for (TooltipSection section : SECTIONS) {
            if (section.appliesTo(event.getItemStack())) {
                section.appendTooltip(event.getItemStack(), event.getContext(), event.getFlags(), event.getToolTip());
            }
        }
    }

    private GemistryTooltipHandler() {
    }
}
