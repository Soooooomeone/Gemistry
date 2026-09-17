package com.danako.gemistry.common.item.gem;

import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;

public class GemItem extends Item {

    private final GemProperties gemProperties;

    public GemItem(Properties properties, GemTier tier, @Nullable GemCatalyst catalyst) {
        super(properties);
        this.gemProperties = new GemProperties(tier, catalyst);
    }

    public GemProperties gemProperties() {
        return this.gemProperties;
    }
}
