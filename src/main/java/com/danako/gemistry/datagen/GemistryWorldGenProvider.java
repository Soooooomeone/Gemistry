package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class GemistryWorldGenProvider {

    private static final String MODID = "gemistry";

    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_SMALL = configuredKey("ruby_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_MEDIUM = configuredKey("ruby_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_LARGE = configuredKey("ruby_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_BURIED = configuredKey("ruby_ore_buried");

    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_SMALL = configuredKey("sapphire_ore_small");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_MEDIUM = configuredKey("sapphire_ore_medium");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_LARGE = configuredKey("sapphire_ore_large");
    private static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_BURIED = configuredKey("sapphire_ore_buried");

    private static final ResourceKey<PlacedFeature> RUBY_ORE_SMALL_PLACED = placedKey("ruby_ore_small");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_MEDIUM_PLACED = placedKey("ruby_ore_medium");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_LARGE_PLACED = placedKey("ruby_ore_large");
    private static final ResourceKey<PlacedFeature> RUBY_ORE_BURIED_PLACED = placedKey("ruby_ore_buried");

    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_SMALL_PLACED = placedKey("sapphire_ore_small");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_MEDIUM_PLACED = placedKey("sapphire_ore_medium");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_LARGE_PLACED = placedKey("sapphire_ore_large");
    private static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_BURIED_PLACED = placedKey("sapphire_ore_buried");

    private static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = biomeModifierKey("add_ruby_ore");
    private static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = biomeModifierKey("add_sapphire_ore");

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, GemistryWorldGenProvider::registerConfiguredFeatures).add(Registries.PLACED_FEATURE, GemistryWorldGenProvider::registerPlacedFeatures).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GemistryWorldGenProvider::registerBiomeModifiers);

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

        context.register(RUBY_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 4, 0.5F)));
        context.register(RUBY_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 8, 0.5F)));
        context.register(RUBY_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 12, 0.7F)));
        context.register(RUBY_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(rubyTargets, 8, 1.0F)));

        context.register(SAPPHIRE_ORE_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 4, 0.5F)));
        context.register(SAPPHIRE_ORE_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 8, 0.5F)));
        context.register(SAPPHIRE_ORE_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 12, 0.7F)));
        context.register(SAPPHIRE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sapphireTargets, 8, 1.0F)));
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

        context.register(RUBY_ORE_SMALL_PLACED, new PlacedFeature(rubySmall, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(RUBY_ORE_MEDIUM_PLACED, new PlacedFeature(rubyMedium, rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))));
        context.register(RUBY_ORE_LARGE_PLACED, new PlacedFeature(rubyLarge, rareOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(RUBY_ORE_BURIED_PLACED, new PlacedFeature(rubyBuried, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

        context.register(SAPPHIRE_ORE_SMALL_PLACED, new PlacedFeature(sapphireSmall, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(SAPPHIRE_ORE_MEDIUM_PLACED, new PlacedFeature(sapphireMedium, rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))));
        context.register(SAPPHIRE_ORE_LARGE_PLACED, new PlacedFeature(sapphireLarge, rareOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
        context.register(SAPPHIRE_ORE_BURIED_PLACED, new PlacedFeature(sapphireBuried, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    }

    private static void registerBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(RUBY_ORE_SMALL_PLACED), placedFeatures.getOrThrow(RUBY_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(RUBY_ORE_LARGE_PLACED), placedFeatures.getOrThrow(RUBY_ORE_BURIED_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SAPPHIRE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(SAPPHIRE_ORE_SMALL_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_MEDIUM_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_LARGE_PLACED), placedFeatures.getOrThrow(SAPPHIRE_ORE_BURIED_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}