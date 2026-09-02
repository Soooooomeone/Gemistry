package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
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

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, GemistryWorldGenProvider::registerConfiguredFeatures).add(Registries.PLACED_FEATURE, GemistryWorldGenProvider::registerPlacedFeatures).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GemistryWorldGenProvider::registerBiomeModifiers);

    private static void registerConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(GemistryConfiguredFeatures.RUBY_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), GemistryBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), GemistryBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())), 8)));
    }

    private static void registerPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> placement = List.of(CountPlacement.of(7), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(24)), BiomeFilter.biome());

        context.register(GemistryPlacedFeatures.RUBY_ORE_PLACED, new PlacedFeature(configuredFeatures.getOrThrow(GemistryConfiguredFeatures.RUBY_ORE), placement));
    }

    private static void registerBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(GemistryBiomeModifiers.ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(GemistryPlacedFeatures.RUBY_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}