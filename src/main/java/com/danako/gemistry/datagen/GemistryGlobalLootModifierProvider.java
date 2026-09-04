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

    private static final float HORSE_ARMOR_CHANCE_END_CITY_TREASURE = 0.0080F;
    private static final float HORSE_ARMOR_CHANCE_NETHER_BRIDGE = 0.0290F;
    private static final float HORSE_ARMOR_CHANCE_VILLAGE_WEAPONSMITH = 0.0070F;
    private static final float HORSE_ARMOR_CHANCE_STRONGHOLD_CORRIDOR = 0.0075F;
    private static final float HORSE_ARMOR_CHANCE_DESERT_PYRAMID = 0.0150F;
    private static final float HORSE_ARMOR_CHANCE_JUNGLE_TEMPLE = 0.0080F;
    private static final float HORSE_ARMOR_CHANCE_ANCIENT_CITY = 0.0180F;
    private static final float NAUTILUS_ARMOR_CHANCE_BURIED_TREASURE = 0.0080F;
    private static final float NAUTILUS_ARMOR_CHANCE_UNDERWATER_RUIN_BIG = 0.0080F;
    private static final float NAUTILUS_ARMOR_CHANCE_UNDERWATER_RUIN_SMALL = 0.0080F;
    private static final float NAUTILUS_ARMOR_CHANCE_SHIPWRECK_SUPPLY = 0.0080F;
    private static final float NAUTILUS_ARMOR_CHANCE_SHIPWRECK_MAP = 0.0080F;
    private static final float NAUTILUS_ARMOR_CHANCE_SHIPWRECK_TREASURE = 0.0080F;
    private static final float AMBER_HORSE_ARMOR_MULTIPLIER = 1.5F;
    private static final float AMBER_NAUTILUS_ARMOR_CHANCE = 0.012F;

    public GemistryGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, "gemistry");
    }

    @Override
    protected void start() {
        addHorseArmor(BuiltInLootTables.END_CITY_TREASURE, "end_city_treasure", HORSE_ARMOR_CHANCE_END_CITY_TREASURE);
        addHorseArmor(BuiltInLootTables.NETHER_BRIDGE, "nether_bridge", HORSE_ARMOR_CHANCE_NETHER_BRIDGE);
        addHorseArmor(BuiltInLootTables.VILLAGE_WEAPONSMITH, "village_weaponsmith", HORSE_ARMOR_CHANCE_VILLAGE_WEAPONSMITH);
        addHorseArmor(BuiltInLootTables.STRONGHOLD_CORRIDOR, "stronghold_corridor", HORSE_ARMOR_CHANCE_STRONGHOLD_CORRIDOR);
        addHorseArmor(BuiltInLootTables.DESERT_PYRAMID, "desert_pyramid", HORSE_ARMOR_CHANCE_DESERT_PYRAMID);
        addHorseArmor(BuiltInLootTables.JUNGLE_TEMPLE, "jungle_temple", HORSE_ARMOR_CHANCE_JUNGLE_TEMPLE);
        addHorseArmor(BuiltInLootTables.ANCIENT_CITY, "ancient_city", HORSE_ARMOR_CHANCE_ANCIENT_CITY);

        addNautilusArmor(BuiltInLootTables.BURIED_TREASURE, "buried_treasure", NAUTILUS_ARMOR_CHANCE_BURIED_TREASURE);
        addNautilusArmor(BuiltInLootTables.UNDERWATER_RUIN_BIG, "underwater_ruin_big", NAUTILUS_ARMOR_CHANCE_UNDERWATER_RUIN_BIG);
        addNautilusArmor(BuiltInLootTables.UNDERWATER_RUIN_SMALL, "underwater_ruin_small", NAUTILUS_ARMOR_CHANCE_UNDERWATER_RUIN_SMALL);
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_SUPPLY, "shipwreck_supply", NAUTILUS_ARMOR_CHANCE_SHIPWRECK_SUPPLY);
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_MAP, "shipwreck_map", NAUTILUS_ARMOR_CHANCE_SHIPWRECK_MAP);
        addNautilusArmor(BuiltInLootTables.SHIPWRECK_TREASURE, "shipwreck_treasure", NAUTILUS_ARMOR_CHANCE_SHIPWRECK_TREASURE);
    }

    private void addHorseArmor(ResourceKey<LootTable> table, String tableName, float baseChance) {
        addRareItem(table, tableName, "horse_armor", "ruby", GemistryItems.RUBY_HORSE_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "horse_armor", "sapphire", GemistryItems.SAPPHIRE_HORSE_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "horse_armor", "aquamarine", GemistryItems.AQUAMARINE_HORSE_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "horse_armor", "amber", GemistryItems.AMBER_HORSE_ARMOR.get(), baseChance * AMBER_HORSE_ARMOR_MULTIPLIER);
    }

    private void addNautilusArmor(ResourceKey<LootTable> table, String tableName, float baseChance) {
        addRareItem(table, tableName, "nautilus_armor", "ruby", GemistryItems.RUBY_NAUTILUS_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "nautilus_armor", "sapphire", GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "nautilus_armor", "aquamarine", GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get(), baseChance);
        addRareItem(table, tableName, "nautilus_armor", "amber", GemistryItems.AMBER_NAUTILUS_ARMOR.get(), AMBER_NAUTILUS_ARMOR_CHANCE);
    }

    private void addRareItem(ResourceKey<LootTable> table, String tableName, String kind, String gem, Item item, float chance) {
        add(tableName + "_" + gem + "_" + kind, new AddItemLootModifier(new LootItemCondition[]{LootTableIdCondition.builder(table.identifier()).build(), LootItemRandomChanceCondition.randomChance(chance).build()}, IGlobalLootModifier.DEFAULT_PRIORITY, BuiltInRegistries.ITEM.wrapAsHolder(item)));
    }
}