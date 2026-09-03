package com.danako.gemistry.loot;

import com.danako.gemistry.Gemistry;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public final class GemistryLootModifierSerializers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Gemistry.MODID);

    public static final Supplier<MapCodec<AddItemLootModifier>> ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", () -> AddItemLootModifier.CODEC);

    public static void register(IEventBus modEventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }

    private GemistryLootModifierSerializers() {
    }
}