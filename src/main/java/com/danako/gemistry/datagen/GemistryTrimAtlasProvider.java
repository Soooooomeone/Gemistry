package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.data.SpriteSourceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GemistryTrimAtlasProvider extends SpriteSourceProvider {

    private static final Identifier ARMOR_TRIMS_ATLAS = Identifier.withDefaultNamespace("armor_trims");
    private static final Identifier ITEMS_ATLAS = Identifier.withDefaultNamespace("items");

    private static final Identifier PALETTE_KEY = Identifier.withDefaultNamespace("trims/color_palettes/trim_palette");

    private static final List<String> VANILLA_PATTERN_NAMES = List.of(
            "sentry", "dune", "coast", "wild", "ward", "eye", "vex", "tide",
            "snout", "rib", "spire", "wayfinder", "shaper", "silence",
            "raiser", "host", "flow", "bolt"
    );

    private static final List<String> HUMANOID_LAYER_PREFIXES = List.of(
            "humanoid", "humanoid_leggings"
    );

    public GemistryTrimAtlasProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Gemistry.MODID);

        Map<String, Identifier> permutations = Map.ofEntries(
                Map.entry("ruby", palette("ruby")),
                Map.entry("ruby_darker", palette("ruby_darker")),
                Map.entry("sapphire", palette("sapphire")),
                Map.entry("sapphire_darker", palette("sapphire_darker")),
                Map.entry("aquamarine", palette("aquamarine")),
                Map.entry("aquamarine_darker", palette("aquamarine_darker")),
                Map.entry("amber", palette("amber")),
                Map.entry("amber_darker", palette("amber_darker"))
        );

        List<Identifier> entityTextures = new ArrayList<>();
        for (String layerPrefix : HUMANOID_LAYER_PREFIXES) {
            for (String pattern : VANILLA_PATTERN_NAMES) {
                entityTextures.add(Identifier.withDefaultNamespace("trims/entity/" + layerPrefix + "/" + pattern));
            }
        }

        List<Identifier> itemTextures = List.of(
                Identifier.withDefaultNamespace("trims/items/helmet_trim"),
                Identifier.withDefaultNamespace("trims/items/chestplate_trim"),
                Identifier.withDefaultNamespace("trims/items/leggings_trim"),
                Identifier.withDefaultNamespace("trims/items/boots_trim")
        );

        atlas(ARMOR_TRIMS_ATLAS).addSource(new PalettedPermutations(entityTextures, PALETTE_KEY, permutations));
        atlas(ITEMS_ATLAS).addSource(new PalettedPermutations(itemTextures, PALETTE_KEY, permutations));
    }

    @Override
    protected void gather() {
    }

    private static Identifier palette(String name) {
        return Identifier.fromNamespaceAndPath(Gemistry.MODID, "trims/color_palettes/" + name);
    }
}