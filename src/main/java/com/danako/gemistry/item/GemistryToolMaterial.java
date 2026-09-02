package com.danako.gemistry.item;

import com.danako.gemistry.core.GemistryTags;
import net.minecraft.world.item.ToolMaterial;

public final class GemistryToolMaterial {

    public static final ToolMaterial RUBY = new ToolMaterial(GemistryTags.INCORRECT_FOR_RUBY_TOOL,

            1900, 9.0F, 4.0F, 15, GemistryTags.RUBY_TOOL_MATERIALS);

    private GemistryToolMaterial() {
    }
}