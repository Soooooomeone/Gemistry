package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;


public class GemistryConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE = registerKey("sapphire_ore");

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Gemistry.MODID, name));
    }
}