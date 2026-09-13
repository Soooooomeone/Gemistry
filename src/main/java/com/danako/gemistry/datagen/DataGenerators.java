package com.danako.gemistry.datagen;

import com.danako.gemistry.core.enchantment.GemistryEnchantments;
import com.danako.gemistry.core.trim_material.GemistryTrimMaterials;
import com.danako.gemistry.core.loot.GemistryGlobalLootModifierProvider;
import com.danako.gemistry.core.loot.GemistryLootTableProvider;
import com.danako.gemistry.core.tag.GemistryBlockTagsProvider;
import com.danako.gemistry.core.tag.GemistryEnchantmentTagsProvider;
import com.danako.gemistry.core.tag.GemistryItemTagsProvider;
import com.danako.gemistry.core.worldgen.GemistryWorldGenProvider;
import com.danako.gemistry.datagen.model.GemistryAtlasProvider;
import com.danako.gemistry.datagen.model.GemistryEquipmentAssetProvider;
import com.danako.gemistry.datagen.model.GemistryModelProvider;
import net.minecraft.core.registries.Registries;
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
        event.createProvider(GemistryAtlasProvider::new);
        event.createDatapackRegistryObjects(GemistryWorldGenProvider.BUILDER.add(Registries.TRIM_MATERIAL, GemistryTrimMaterials::bootstrap).add(Registries.ENCHANTMENT, GemistryEnchantments::bootstrap));
        event.createBlockAndItemTags(GemistryBlockTagsProvider::new, GemistryItemTagsProvider::new);
        event.createProvider(output -> new GemistryEnchantmentTagsProvider(output, event.getLookupProvider()));
        event.createProvider(GemistryLootTableProvider::new);
        event.createProvider(GemistryGlobalLootModifierProvider::new);
        event.createProvider(GemistryRecipeProvider.Runner::new);

    }
}