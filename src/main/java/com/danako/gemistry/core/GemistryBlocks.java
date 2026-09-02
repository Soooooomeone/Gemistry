package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class GemistryBlocks {
    private static final UniformInt RUBY_XP = UniformInt.of(3, 7);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Gemistry.MODID);
    public static final DeferredBlock<Block> RUBY_ORE = BLOCKS.registerBlock("ruby_ore", properties -> new DropExperienceBlock(RUBY_XP, properties));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = BLOCKS.registerBlock("deepslate_ruby_ore", properties -> new DropExperienceBlock(RUBY_XP, properties));
    public static final DeferredBlock<Block> RUBY_BLOCK = BLOCKS.registerBlock("ruby_block", properties -> new DropExperienceBlock(RUBY_XP, properties));

    private GemistryBlocks() {
    }
}