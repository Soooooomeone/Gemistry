package com.danako.gemistry.worldgen;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class GemistryBiomeModifierSerializers {
    private static final String MODID = "gemistry";

    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);

    public static final Supplier<MapCodec<ConfigurableOreBiomeModifier>> CONFIGURABLE_ORE = BIOME_MODIFIER_SERIALIZERS.register("configurable_ore", () -> ConfigurableOreBiomeModifier.CODEC);

    public static void register(IEventBus modEventBus) {
        BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}