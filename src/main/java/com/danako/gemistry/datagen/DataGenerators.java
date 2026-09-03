package com.danako.gemistry.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(DataGenerators::gatherClientData);
    }

    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(GemistryModelProvider::new);
        event.createProvider(GemistryEquipmentAssetProvider::new);
        event.createProvider(GemistryLanguageProvider::new);
        event.createDatapackRegistryObjects(GemistryWorldGenProvider.BUILDER);
        event.createBlockAndItemTags(GemistryBlockTagsProvider::new, GemistryItemTagsProvider::new);
        event.createProvider(GemistryLootTableProvider::new);
        event.createProvider(GemistryGlobalLootModifierProvider::new);
        event.createProvider(GemistryRecipeProvider.Runner::new);
    }
}