package com.danako.gemistry.common.block.entity;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GemistryBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Gemistry.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AttunementTableBlockEntity>> ATTUNEMENT_TABLE = BLOCK_ENTITY_TYPES.register("attunement_table", () -> new BlockEntityType<>(AttunementTableBlockEntity::new, GemistryBlocks.ATTUNEMENT_TABLE.get()));

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }
}