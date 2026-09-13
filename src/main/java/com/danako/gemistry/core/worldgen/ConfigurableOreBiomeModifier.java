package com.danako.gemistry.core.worldgen;

import com.danako.gemistry.config.GemistryConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public record ConfigurableOreBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features,
                                           GenerationStep.Decoration step, String configKey) implements BiomeModifier {

    public static final MapCodec<ConfigurableOreBiomeModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(ConfigurableOreBiomeModifier::biomes), PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(ConfigurableOreBiomeModifier::features), GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(ConfigurableOreBiomeModifier::step), Codec.STRING.fieldOf("config_key").forGetter(ConfigurableOreBiomeModifier::configKey)).apply(instance, ConfigurableOreBiomeModifier::new));

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase != Phase.ADD) return;
        if (!biomes.contains(biome)) return;
        if (!GemistryConfig.isOreGenerationEnabled(configKey)) return;

        features.forEach(feature -> builder.getGenerationSettings().addFeature(step, feature));
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return GemistryBiomeModifierSerializers.CONFIGURABLE_ORE.get();
    }
}