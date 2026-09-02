package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


public class GemistryPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED = registerKey("ruby_ore_placed");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Gemistry.MODID, name));
    }
}