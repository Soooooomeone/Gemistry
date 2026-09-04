package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryBlocks;
import com.danako.gemistry.core.GemistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class GemistryBlockTagsProvider extends BlockTagsProvider {

    public GemistryBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Gemistry.MODID);
    }

    private static TagKey<Block> commonTag(String path) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", path));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addHarvestLevelTags();
        addNeoForgeConventionTags();
        addToolTierTags();
        addVanillaTags();
    }

    private void addHarvestLevelTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get()).add(GemistryBlocks.RUBY_BLOCK.get()).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(GemistryBlocks.SAPPHIRE_BLOCK.get()).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get()).add(GemistryBlocks.AQUAMARINE_BLOCK.get()).add(GemistryBlocks.AMBER_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get()).add(GemistryBlocks.AMBER_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get()).add(GemistryBlocks.RUBY_BLOCK.get()).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(GemistryBlocks.SAPPHIRE_BLOCK.get()).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get()).add(GemistryBlocks.AQUAMARINE_BLOCK.get()).add(GemistryBlocks.AMBER_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get()).add(GemistryBlocks.AMBER_BLOCK.get());
    }

    private void addNeoForgeConventionTags() {
        tag(commonTag("ores/ruby")).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get());
        tag(commonTag("storage_blocks/ruby")).add(GemistryBlocks.RUBY_BLOCK.get());

        tag(commonTag("ores/sapphire")).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(commonTag("storage_blocks/sapphire")).add(GemistryBlocks.SAPPHIRE_BLOCK.get());

        tag(commonTag("ores/aquamarine")).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
        tag(commonTag("storage_blocks/aquamarine")).add(GemistryBlocks.AQUAMARINE_BLOCK.get());

        tag(commonTag("ores/amber")).add(GemistryBlocks.AMBER_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get());
        tag(commonTag("storage_blocks/amber")).add(GemistryBlocks.AMBER_BLOCK.get());

        tag(Tags.Blocks.ORES).addTag(commonTag("ores/ruby")).addTag(commonTag("ores/sapphire")).addTag(commonTag("ores/aquamarine")).addTag(commonTag("ores/amber"));

        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.AMBER_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get());

        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(commonTag("storage_blocks/ruby")).addTag(commonTag("storage_blocks/sapphire")).addTag(commonTag("storage_blocks/aquamarine")).addTag(commonTag("storage_blocks/amber"));

        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get()).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get()).add(GemistryBlocks.AMBER_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get());
    }

    private void addToolTierTags() {
        tag(GemistryTags.INCORRECT_FOR_RUBY_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(GemistryTags.INCORRECT_FOR_SAPPHIRE_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(GemistryTags.INCORRECT_FOR_AQUAMARINE_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(GemistryTags.INCORRECT_FOR_AMBER_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
    }

    private void addVanillaTags() {
        tag(BlockTags.BEACON_BASE_BLOCKS).add(GemistryBlocks.RUBY_BLOCK.get()).add(GemistryBlocks.SAPPHIRE_BLOCK.get()).add(GemistryBlocks.AQUAMARINE_BLOCK.get()).add(GemistryBlocks.AMBER_BLOCK.get());

        tag(BlockTags.SNAPS_GOAT_HORN).add(GemistryBlocks.RUBY_ORE.get()).add(GemistryBlocks.DEEPSLATE_RUBY_ORE.get()).add(GemistryBlocks.SAPPHIRE_ORE.get()).add(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(GemistryBlocks.AQUAMARINE_ORE.get()).add(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get()).add(GemistryBlocks.AMBER_ORE.get()).add(GemistryBlocks.DEEPSLATE_AMBER_ORE.get());
    }
}