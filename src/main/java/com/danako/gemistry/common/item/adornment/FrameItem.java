package com.danako.gemistry.common.item.adornment;

import net.minecraft.world.item.Item;

public class FrameItem extends Item {

    private final FrameProperties frameProperties;

    public FrameItem(Properties properties, FrameMaterial material, AdornmentType adornment) {
        super(properties);
        this.frameProperties = new FrameProperties(material, adornment);
    }

    public FrameProperties frameProperties() {
        return this.frameProperties;
    }

    public FrameMaterial material() {
        return this.frameProperties.material();
    }

    public AdornmentType adornment() {
        return this.frameProperties.adornment();
    }
}
