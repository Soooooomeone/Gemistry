package com.danako.gemistry.worldgen;

import com.danako.gemistry.common.block.GemistryBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class GemistryWorldGenProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, GemistryWorldGenProvider::registerConfiguredFeatures).add(Registries.PLACED_FEATURE, GemistryWorldGenProvider::registerPlacedFeatures).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GemistryWorldGenProvider::registerBiomeModifiers);
    private static final String MODID = "gemistry";
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_SMALL = configuredKey("ruby_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_MEDIUM = configuredKey("ruby_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_LARGE = configuredKey("ruby_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_BURIED = configuredKey("ruby_ore_buried");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_SMALL = configuredKey("sapphire_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_MEDIUM = configuredKey("sapphire_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_LARGE = configuredKey("sapphire_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_BURIED = configuredKey("sapphire_ore_buried");
    private static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_SMALL = configuredKey("aquamarine_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_MEDIUM = configuredKey("aquamarine_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_LARGE = configuredKey("aquamarine_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_BURIED = configuredKey("aquamarine_ore_buried");
    private static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_ORE = configuredKey("amber_ore");
    private static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_TINY = configuredKey("onyx_ore_tiny");
    private static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_SMALL = configuredKey("onyx_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_MEDIUM = configuredKey("onyx_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_LARGE = configuredKey("onyx_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_CLUSTER = configuredKey("onyx_ore_cluster");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_SMALL_PLACED = placedKey("ruby_ore_small");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_MEDIUM_PLACED = placedKey("ruby_ore_medium");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_LARGE_PLACED = placedKey("ruby_ore_large");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_BURIED_PLACED = placedKey("ruby_ore_buried");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_SMALL_PLACED = placedKey("sapphire_ore_small");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_MEDIUM_PLACED = placedKey("sapphire_ore_medium");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_LARGE_PLACED = placedKey("sapphire_ore_large");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_BURIED_PLACED = placedKey("sapphire_ore_buried");
    private static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_SMALL_PLACED = placedKey("aquamarine_ore_small");
    private static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_MEDIUM_PLACED = placedKey("aquamarine_ore_medium");
    private static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_LARGE_PLACED = placedKey("aquamarine_ore_large");
    private static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_BURIED_PLACED = placedKey("aquamarine_ore_buried");
    private static final ResourceKey<PlacedFeature> AMBER_ORE_PLACED = placedKey("amber_ore");
    private static final ResourceKey<PlacedFeature> AMBER_ORE_LOWER_PLACED = placedKey("amber_ore_lower");
    private static final ResourceKey<PlacedFeature> ONYX_ORE_TINY_PLACED = placedKey("onyx_ore_tiny");
    private static final ResourceKey<PlacedFeature> ONYX_ORE_SMALL_PLACED = placedKey("onyx_ore_small");
    private static final ResourceKey<PlacedFeature> ONYX_ORE_MEDIUM_PLACED = placedKey("onyx_ore_medium");
    private static final ResourceKey<PlacedFeature> ONYX_ORE_LARGE_PLACED = placedKey("onyx_ore_large");
    private static final ResourceKey<PlacedFeature> ONYX_ORE_CLUSTER_PLACED = placedKey("onyx_ore_cluster");
    private static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = biomeModifierKey("add_ruby_ore");
    private static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = biomeModifierKey("add_sapphire_ore");
    private static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_ORE = biomeModifierKey("add_aquamarine_ore");
    private static final ResourceKey<BiomeModifier> ADD_AMBER_ORE = biomeModifierKey("add_amber_ore");
    private static final ResourceKey<BiomeModifier> ADD_ONYX_ORE = biomeModifierKey("add_onyx_ore");

    private static ResourceKey<ConfiguredFeature<?, ?>> configuredKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<PlacedFeature> placedKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<BiomeModifier> biomeModifierKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static void registerConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        List<OreConfiguration.TargetBlockState> rubyTargets = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> sapphireTargets = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> aquamarineTargets = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.AQUAMARINE_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> amberTargets = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.AMBER_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_AMBER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> onyxTargets = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.ONYX_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_ONYX_ORE.get().defaultBlockState()));
        context.register(RUBY_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 4, 0.5F)));
        context.register(RUBY_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 8, 0.5F)));
        context.register(RUBY_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 12, 0.7F)));
        context.register(RUBY_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 8, 1.0F)));
        context.register(SAPPHIRE_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 4, 0.5F)));
        context.register(SAPPHIRE_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 8, 0.5F)));
        context.register(SAPPHIRE_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 12, 0.7F)));
        context.register(SAPPHIRE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 8, 1.0F)));
        context.register(AQUAMARINE_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(aquamarineTargets, 4, 0.5F)));
        context.register(AQUAMARINE_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(aquamarineTargets, 8, 0.5F)));
        context.register(AQUAMARINE_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(aquamarineTargets, 12, 0.7F)));
        context.register(AQUAMARINE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(aquamarineTargets, 8, 1.0F)));
        context.register(AMBER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(amberTargets, 8)));
        context.register(ONYX_ORE_TINY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(onyxTargets, 2, 0.0F)));
        context.register(ONYX_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(onyxTargets, 4, 0.0F)));
        context.register(ONYX_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(onyxTargets, 6, 0.0F)));
        context.register(ONYX_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(onyxTargets, 9, 0.0F)));
        context.register(ONYX_ORE_CLUSTER, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(onyxTargets, 12, 0.0F)));
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightRange) {
        return List.of(RarityFilter.onAverageOnceEvery(rarity), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static void registerPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> rubySmall = configuredFeatures.getOrThrow(RUBY_ORE_SMALL);
        Holder<ConfiguredFeature<?, ?>> rubyMedium = configuredFeatures.getOrThrow(RUBY_ORE_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> rubyLarge = configuredFeatures.getOrThrow(RUBY_ORE_LARGE);
        Holder<ConfiguredFeature<?, ?>> rubyBuried = configuredFeatures.getOrThrow(RUBY_ORE_BURIED);
        Holder<ConfiguredFeature<?, ?>> sapphireSmall = configuredFeatures.getOrThrow(SAPPHIRE_ORE_SMALL);
        Holder<ConfiguredFeature<?, ?>> sapphireMedium = configuredFeatures.getOrThrow(SAPPHIRE_ORE_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> sapphireLarge = configuredFeatures.getOrThrow(SAPPHIRE_ORE_LARGE);
        Holder<ConfiguredFeature<?, ?>> sapphireBuried = configuredFeatures.getOrThrow(SAPPHIRE_ORE_BURIED);
        Holder<ConfiguredFeature<?, ?>> aquamarineSmall = configuredFeatures.getOrThrow(AQUAMARINE_ORE_SMALL);
        Holder<ConfiguredFeature<?, ?>> aquamarineMedium = configuredFeatures.getOrThrow(AQUAMARINE_ORE_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> aquamarineLarge = configuredFeatures.getOrThrow(AQUAMARINE_ORE_LARGE);
        Holder<ConfiguredFeature<?, ?>> aquamarineBuried = configuredFeatures.getOrThrow(AQUAMARINE_ORE_BURIED);
        Holder<ConfiguredFeature<?, ?>> amberOre = configuredFeatures.getOrThrow(AMBER_ORE);
        Holder<ConfiguredFeature<?, ?>> onyxTiny = configuredFeatures.getOrThrow(ONYX_ORE_TINY);
        Holder<ConfiguredFeature<?, ?>> onyxSmall = configuredFeatures.getOrThrow(ONYX_ORE_SMALL);
        Holder<ConfiguredFeature<?, ?>> onyxMedium = configuredFeatures.getOrThrow(ONYX_ORE_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> onyxLarge = configuredFeatures.getOrThrow(ONYX_ORE_LARGE);
        Holder<ConfiguredFeature<?, ?>> onyxCluster = configuredFeatures.getOrThrow(ONYX_ORE_CLUSTER);
        context.register(RUBY_ORE_SMALL_PLACED, new PlacedFeature(rubySmall, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(RUBY_ORE_MEDIUM_PLACED, new PlacedFeature(rubyMedium, rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))));
        context.register(RUBY_ORE_LARGE_PLACED, new PlacedFeature(rubyLarge, rareOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(RUBY_ORE_BURIED_PLACED, new PlacedFeature(rubyBuried, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(SAPPHIRE_ORE_SMALL_PLACED, new PlacedFeature(sapphireSmall, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(SAPPHIRE_ORE_MEDIUM_PLACED, new PlacedFeature(sapphireMedium, rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))));
        context.register(SAPPHIRE_ORE_LARGE_PLACED, new PlacedFeature(sapphireLarge, rareOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(SAPPHIRE_ORE_BURIED_PLACED, new PlacedFeature(sapphireBuried, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(AQUAMARINE_ORE_SMALL_PLACED, new PlacedFeature(aquamarineSmall, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(AQUAMARINE_ORE_MEDIUM_PLACED, new PlacedFeature(aquamarineMedium, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))));
        context.register(AQUAMARINE_ORE_LARGE_PLACED, new PlacedFeature(aquamarineLarge, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(AQUAMARINE_ORE_BURIED_PLACED, new PlacedFeature(aquamarineBuried, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(AMBER_ORE_PLACED, new PlacedFeature(amberOre, commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(63)))));
        context.register(AMBER_ORE_LOWER_PLACED, new PlacedFeature(amberOre, commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
        PlacementModifier onyxHeightRange = HeightRangePlacement.uniform(VerticalAnchor.absolute(-58), VerticalAnchor.absolute(-8));
        context.register(ONYX_ORE_TINY_PLACED, new PlacedFeature(onyxTiny, commonOrePlacement(4, onyxHeightRange)));
        context.register(ONYX_ORE_SMALL_PLACED, new PlacedFeature(onyxSmall, commonOrePlacement(2, onyxHeightRange)));
        context.register(ONYX_ORE_MEDIUM_PLACED, new PlacedFeature(onyxMedium, rareOrePlacement(3, onyxHeightRange)));
        context.register(ONYX_ORE_LARGE_PLACED, new PlacedFeature(onyxLarge, rareOrePlacement(6, onyxHeightRange)));
        context.register(ONYX_ORE_CLUSTER_PLACED, new PlacedFeature(onyxCluster, rareOrePlacement(12, onyxHeightRange)));
    }

    private static void registerBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        context.register(ADD_RUBY_ORE, new ConfigurableOreBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(RUBY_ORE_SMALL_PLACED), placedFeatures.getOrThrow(RUBY_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(RUBY_ORE_LARGE_PLACED), placedFeatures.getOrThrow(RUBY_ORE_BURIED_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES, "ruby"));
        context.register(ADD_SAPPHIRE_ORE, new ConfigurableOreBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(SAPPHIRE_ORE_SMALL_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_LARGE_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_BURIED_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES, "sapphire"));
        context.register(ADD_AQUAMARINE_ORE, new ConfigurableOreBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OCEAN), HolderSet.direct(placedFeatures.getOrThrow(AQUAMARINE_ORE_SMALL_PLACED), placedFeatures.getOrThrow(AQUAMARINE_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(AQUAMARINE_ORE_LARGE_PLACED), placedFeatures.getOrThrow(AQUAMARINE_ORE_BURIED_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES, "aquamarine"));
        context.register(ADD_AMBER_ORE, new ConfigurableOreBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP)), HolderSet.direct(placedFeatures.getOrThrow(AMBER_ORE_PLACED), placedFeatures.getOrThrow(AMBER_ORE_LOWER_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES, "amber"));
        context.register(ADD_ONYX_ORE, new ConfigurableOreBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.DEEP_DARK)), HolderSet.direct(placedFeatures.getOrThrow(ONYX_ORE_TINY_PLACED), placedFeatures.getOrThrow(ONYX_ORE_SMALL_PLACED), placedFeatures.getOrThrow(ONYX_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(ONYX_ORE_LARGE_PLACED), placedFeatures.getOrThrow(ONYX_ORE_CLUSTER_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES, "onyx"));
    }
}