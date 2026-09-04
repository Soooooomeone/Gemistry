package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class GemistryBlocks {
    private static final UniformInt RUBY_XP = UniformInt.of(3, 7);
    private static final UniformInt SAPPHIRE_XP = UniformInt.of(3, 7);
    private static final UniformInt AQUAMARINE_XP = UniformInt.of(3, 7);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Gemistry.MODID);

    public static final DeferredBlock<Block> RUBY_ORE = BLOCKS.registerBlock("ruby_ore", properties -> new DropExperienceBlock(RUBY_XP, properties), () -> Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = BLOCKS.registerBlock("deepslate_ruby_ore", properties -> new DropExperienceBlock(RUBY_XP, properties), () -> Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final DeferredBlock<Block> RUBY_BLOCK = BLOCKS.registerBlock("ruby_block", Block::new, () -> Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> SAPPHIRE_ORE = BLOCKS.registerBlock("sapphire_ore", properties -> new DropExperienceBlock(SAPPHIRE_XP, properties), () -> Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> DEEPSLATE_SAPPHIRE_ORE = BLOCKS.registerBlock("deepslate_sapphire_ore", properties -> new DropExperienceBlock(SAPPHIRE_XP, properties), () -> Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = BLOCKS.registerBlock("sapphire_block", Block::new, () -> Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> AQUAMARINE_ORE = BLOCKS.registerBlock("aquamarine_ore", properties -> new DropExperienceBlock(AQUAMARINE_XP, properties), () -> Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> DEEPSLATE_AQUAMARINE_ORE = BLOCKS.registerBlock("deepslate_aquamarine_ore", properties -> new DropExperienceBlock(AQUAMARINE_XP, properties), () -> Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));
    public static final DeferredBlock<Block> AQUAMARINE_BLOCK = BLOCKS.registerBlock("aquamarine_block", Block::new, () -> Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
    private GemistryBlocks() {
    }
}