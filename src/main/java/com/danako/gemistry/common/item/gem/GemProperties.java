package com.danako.gemistry.common.item.gem;

import org.jspecify.annotations.Nullable;

public record GemProperties(GemTier tier, @Nullable GemCatalyst catalyst) {

    public boolean hasCatalyst() {
        return this.catalyst != null;
    }
}
