package com.danako.gemistry.common.item.adornment;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public final class FrameRegistry {

    private FrameRegistry() {
    }

    public static Optional<FrameProperties> get(Item item) {
        if (item instanceof FrameItem frameItem) {
            return Optional.of(frameItem.frameProperties());
        }
        return Optional.empty();
    }

    public static Optional<FrameProperties> get(ItemStack stack) {
        return get(stack.getItem());
    }

    public static boolean isFrame(ItemStack stack) {
        return stack.getItem() instanceof FrameItem;
    }
}
