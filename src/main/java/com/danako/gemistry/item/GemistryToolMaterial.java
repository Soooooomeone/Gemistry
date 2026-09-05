package com.danako.gemistry.item;

import com.danako.gemistry.core.GemistryTags;
import net.minecraft.world.item.ToolMaterial;

public final class GemistryToolMaterial {

    public static final ToolMaterial RUBY = new ToolMaterial(GemistryTags.INCORRECT_FOR_RUBY_TOOL,

            1900, 9.0F, 4.0F, 15, GemistryTags.RUBY_TOOL_MATERIALS);

    public static final ToolMaterial SAPPHIRE = new ToolMaterial(GemistryTags.INCORRECT_FOR_SAPPHIRE_TOOL,

            1900, 9.0F, 4.0F, 15, GemistryTags.SAPPHIRE_TOOL_MATERIALS);

    public static final ToolMaterial AQUAMARINE = new ToolMaterial(GemistryTags.INCORRECT_FOR_AQUAMARINE_TOOL,

            1561, 8.0F, 3.0F, 10, GemistryTags.AQUAMARINE_TOOL_MATERIALS);

    public static final ToolMaterial AMBER = new ToolMaterial(GemistryTags.INCORRECT_FOR_AMBER_TOOL,

            1400, 7.5F, 2.5F, 9, GemistryTags.AMBER_TOOL_MATERIALS);

    private GemistryToolMaterial() {
    }
}