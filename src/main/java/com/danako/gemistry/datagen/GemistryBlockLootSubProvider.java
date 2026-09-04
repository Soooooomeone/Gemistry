package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryBlocks;
import com.danako.gemistry.core.GemistryItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class GemistryBlockLootSubProvider extends BlockLootSubProvider {

    public GemistryBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected void generate() {

        add(GemistryBlocks.RUBY_ORE.get(), block -> createOreDrop(block, GemistryItems.RUBY.get()));
        add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get(), block -> createOreDrop(block, GemistryItems.RUBY.get()));
        dropSelf(GemistryBlocks.RUBY_BLOCK.get());

        add(GemistryBlocks.SAPPHIRE_ORE.get(), block -> createOreDrop(block, GemistryItems.SAPPHIRE.get()));
        add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block -> createOreDrop(block, GemistryItems.SAPPHIRE.get()));
        dropSelf(GemistryBlocks.SAPPHIRE_BLOCK.get());

        add(GemistryBlocks.AQUAMARINE_ORE.get(), block -> createOreDrop(block, GemistryItems.AQUAMARINE.get()));
        add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), block -> createOreDrop(block, GemistryItems.AQUAMARINE.get()));
        dropSelf(GemistryBlocks.AQUAMARINE_BLOCK.get());

        add(GemistryBlocks.AMBER_ORE.get(), block -> createOreDrop(block, GemistryItems.AMBER.get()));
        add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get(), block -> createOreDrop(block, GemistryItems.AMBER.get()));
        dropSelf(GemistryBlocks.AMBER_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GemistryBlocks.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get()).toList();
    }
}