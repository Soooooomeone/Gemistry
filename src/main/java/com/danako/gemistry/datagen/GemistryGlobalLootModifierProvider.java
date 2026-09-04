package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryItems;
import com.danako.gemistry.loot.AddItemLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class GemistryGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public GemistryGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, "gemistry");
    }

    @Override
    protected void start() {
        addHorseArmor(BuiltInLootTables.END_CITY_TREASURE, "end_city_treasure", 0.008F);
        addHorseArmor(BuiltInLootTables.NETHER_BRIDGE, "nether_bridge", 0.029F);
        addHorseArmor(BuiltInLootTables.VILLAGE_WEAPONSMITH, "village_weaponsmith", 0.007F);
        addHorseArmor(BuiltInLootTables.STRONGHOLD_CORRIDOR, "stronghold_corridor", 0.0075F);
        addHorseArmor(BuiltInLootTables.DESERT_PYRAMID, "desert_pyramid", 0.015F);
        addHorseArmor(BuiltInLootTables.JUNGLE_TEMPLE, "jungle_temple", 0.008F);
        addHorseArmor(BuiltInLootTables.ANCIENT_CITY, "ancient_city", 0.018F);
        addNautilusArmor(BuiltInLootTables.BURIED_TREASURE, "buried_treasure");
        addNautilusArmor(BuiltInLootTables.UNDERWATER_RUIN_BIG, "underwater_ruin_big");
        addNautilusArmor(BuiltInLootTables.UNDERWATER_RUIN_SMALL, "underwater_ruin_small");
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_SUPPLY, "shipwreck_supply");
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_MAP, "shipwreck_map");
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_TREASURE, "shipwreck_treasure");
    }

    private void addHorseArmor(ResourceKey<LootTable> table, String tableName, float chance) {
        addRareItem(table, tableName, "horse_armor", "ruby", GemistryItems.RUBY_HORSE_ARMOR.get(), chance);
        addRareItem(table, tableName, "horse_armor", "sapphire", GemistryItems.SAPPHIRE_HORSE_ARMOR.get(), chance);
        addRareItem(table, tableName, "horse_armor", "aquamarine", GemistryItems.AQUAMARINE_HORSE_ARMOR.get(), chance);
    }

    private void addNautilusArmor(ResourceKey<LootTable> table, String tableName) {
        addRareItem(table, tableName, "nautilus_armor", "ruby", GemistryItems.RUBY_NAUTILUS_ARMOR.get(), 0.008F);
        addRareItem(table, tableName, "nautilus_armor", "sapphire", GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get(), 0.008F);
        addRareItem(table, tableName, "nautilus_armor", "aquamarine", GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get(), 0.008F);
    }

    private void addRareItem(ResourceKey<LootTable> table, String tableName, String kind, String gem, Item item, float chance) {
        add(tableName + "_" + gem + "_" + kind, new AddItemLootModifier(new LootItemCondition[]{LootTableIdCondition.builder(table.identifier()).build(), LootItemRandomChanceCondition.randomChance(chance).build()}, IGlobalLootModifier.DEFAULT_PRIORITY, BuiltInRegistries.ITEM.wrapAsHolder(item)));
    }
}