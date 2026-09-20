package com.danako.gemistry.common.item.gem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Map;
import java.util.Optional;

public final class GemRegistry {

    private static final Map<Item, GemProperties> VANILLA_GEMS = Map.of(Items.EMERALD, new GemProperties(GemTier.COMMON, null), Items.DIAMOND, new GemProperties(GemTier.UNCOMMON, null));

    private GemRegistry() {
    }

    public static Optional<GemProperties> get(Item item) {
        if (item instanceof GemItem gemItem) {
            return Optional.of(gemItem.gemProperties());
        }
        return Optional.ofNullable(VANILLA_GEMS.get(item));
    }

    public static Optional<GemProperties> get(ItemStack stack) {
        return get(stack.getItem());
    }

    public static boolean isGem(ItemStack stack) {
        return get(stack).isPresent();
    }
}