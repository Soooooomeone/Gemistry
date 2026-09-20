package com.danako.gemistry.common.item.adornment;

public record FrameProperties(FrameMaterial material, AdornmentType adornment) {

    public int potency() {
        return this.material.potency();
    }
}
