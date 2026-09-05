package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.item.GemistryArmorMaterial;
import com.danako.gemistry.item.GemistryToolMaterial;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class GemistryItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gemistry.MODID);

    public static final DeferredItem<Item> RUBY = ITEMS.registerItem("ruby", properties -> new Item(properties.delayedHolderComponent(DataComponents.PROVIDES_TRIM_MATERIAL, GemistryTrimMaterials.RUBY)));
    public static final DeferredItem<BlockItem> RUBY_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.RUBY_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_RUBY_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.DEEPSLATE_RUBY_ORE);
    public static final DeferredItem<BlockItem> RUBY_BLOCK = ITEMS.registerSimpleBlockItem(GemistryBlocks.RUBY_BLOCK);
    public static final DeferredItem<Item> RUBY_SWORD = ITEMS.registerItem("ruby_sword", properties -> new Item(properties.sword(GemistryToolMaterial.RUBY, 3.0F, -2.4F)));
    public static final DeferredItem<Item> RUBY_PICKAXE = ITEMS.registerItem("ruby_pickaxe", properties -> new Item(properties.pickaxe(GemistryToolMaterial.RUBY, 1.0F, -2.8F)));
    public static final DeferredItem<Item> RUBY_AXE = ITEMS.registerItem("ruby_axe", properties -> new AxeItem(GemistryToolMaterial.RUBY, 5.0F, -3.0F, properties));
    public static final DeferredItem<Item> RUBY_SHOVEL = ITEMS.registerItem("ruby_shovel", properties -> new ShovelItem(GemistryToolMaterial.RUBY, 1.5F, -3.0F, properties));
    public static final DeferredItem<Item> RUBY_HOE = ITEMS.registerItem("ruby_hoe", properties -> new HoeItem(GemistryToolMaterial.RUBY, -4.0F, 0.0F, properties));
    public static final DeferredItem<Item> RUBY_SPEAR = ITEMS.registerItem("ruby_spear", properties -> new Item(properties.spear(GemistryToolMaterial.RUBY, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
    public static final DeferredItem<Item> RUBY_HELMET = ITEMS.registerItem("ruby_helmet", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.HELMET)));
    public static final DeferredItem<Item> RUBY_CHESTPLATE = ITEMS.registerItem("ruby_chestplate", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> RUBY_LEGGINGS = ITEMS.registerItem("ruby_leggings", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> RUBY_BOOTS = ITEMS.registerItem("ruby_boots", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.BOOTS)));
    public static final DeferredItem<Item> RUBY_HORSE_ARMOR = ITEMS.registerItem("ruby_horse_armor", properties -> new Item(properties.horseArmor(GemistryArmorMaterial.RUBY)));
    public static final DeferredItem<Item> RUBY_NAUTILUS_ARMOR = ITEMS.registerItem("ruby_nautilus_armor", properties -> new Item(properties.nautilusArmor(GemistryArmorMaterial.RUBY)));
    public static final DeferredItem<Item> SAPPHIRE = ITEMS.registerItem("sapphire", properties -> new Item(properties.delayedHolderComponent(DataComponents.PROVIDES_TRIM_MATERIAL, GemistryTrimMaterials.SAPPHIRE)));
    public static final DeferredItem<BlockItem> SAPPHIRE_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.SAPPHIRE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SAPPHIRE_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE);
    public static final DeferredItem<BlockItem> SAPPHIRE_BLOCK = ITEMS.registerSimpleBlockItem(GemistryBlocks.SAPPHIRE_BLOCK);
    public static final DeferredItem<Item> SAPPHIRE_SWORD = ITEMS.registerItem("sapphire_sword", properties -> new Item(properties.sword(GemistryToolMaterial.SAPPHIRE, 3.0F, -2.4F)));
    public static final DeferredItem<Item> SAPPHIRE_PICKAXE = ITEMS.registerItem("sapphire_pickaxe", properties -> new Item(properties.pickaxe(GemistryToolMaterial.SAPPHIRE, 1.0F, -2.8F)));
    public static final DeferredItem<Item> SAPPHIRE_AXE = ITEMS.registerItem("sapphire_axe", properties -> new AxeItem(GemistryToolMaterial.SAPPHIRE, 5.0F, -3.0F, properties));
    public static final DeferredItem<Item> SAPPHIRE_SHOVEL = ITEMS.registerItem("sapphire_shovel", properties -> new ShovelItem(GemistryToolMaterial.SAPPHIRE, 1.5F, -3.0F, properties));
    public static final DeferredItem<Item> SAPPHIRE_HOE = ITEMS.registerItem("sapphire_hoe", properties -> new HoeItem(GemistryToolMaterial.SAPPHIRE, -4.0F, 0.0F, properties));
    public static final DeferredItem<Item> SAPPHIRE_SPEAR = ITEMS.registerItem("sapphire_spear", properties -> new Item(properties.spear(GemistryToolMaterial.SAPPHIRE, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
    public static final DeferredItem<Item> SAPPHIRE_HELMET = ITEMS.registerItem("sapphire_helmet", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.SAPPHIRE, ArmorType.HELMET)));
    public static final DeferredItem<Item> SAPPHIRE_CHESTPLATE = ITEMS.registerItem("sapphire_chestplate", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.SAPPHIRE, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> SAPPHIRE_LEGGINGS = ITEMS.registerItem("sapphire_leggings", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.SAPPHIRE, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> SAPPHIRE_BOOTS = ITEMS.registerItem("sapphire_boots", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.SAPPHIRE, ArmorType.BOOTS)));
    public static final DeferredItem<Item> SAPPHIRE_HORSE_ARMOR = ITEMS.registerItem("sapphire_horse_armor", properties -> new Item(properties.horseArmor(GemistryArmorMaterial.SAPPHIRE)));
    public static final DeferredItem<Item> SAPPHIRE_NAUTILUS_ARMOR = ITEMS.registerItem("sapphire_nautilus_armor", properties -> new Item(properties.nautilusArmor(GemistryArmorMaterial.SAPPHIRE)));
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.registerItem("aquamarine", properties -> new Item(properties.delayedHolderComponent(DataComponents.PROVIDES_TRIM_MATERIAL, GemistryTrimMaterials.AQUAMARINE)));
    public static final DeferredItem<BlockItem> AQUAMARINE_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.AQUAMARINE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_AQUAMARINE_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE);
    public static final DeferredItem<BlockItem> AQUAMARINE_BLOCK = ITEMS.registerSimpleBlockItem(GemistryBlocks.AQUAMARINE_BLOCK);
    public static final DeferredItem<Item> AQUAMARINE_SWORD = ITEMS.registerItem("aquamarine_sword", properties -> new Item(properties.sword(GemistryToolMaterial.AQUAMARINE, 3.0F, -2.4F)));
    public static final DeferredItem<Item> AQUAMARINE_PICKAXE = ITEMS.registerItem("aquamarine_pickaxe", properties -> new Item(properties.pickaxe(GemistryToolMaterial.AQUAMARINE, 1.0F, -2.8F)));
    public static final DeferredItem<Item> AQUAMARINE_AXE = ITEMS.registerItem("aquamarine_axe", properties -> new AxeItem(GemistryToolMaterial.AQUAMARINE, 5.0F, -3.0F, properties));
    public static final DeferredItem<Item> AQUAMARINE_SHOVEL = ITEMS.registerItem("aquamarine_shovel", properties -> new ShovelItem(GemistryToolMaterial.AQUAMARINE, 1.5F, -3.0F, properties));
    public static final DeferredItem<Item> AQUAMARINE_HOE = ITEMS.registerItem("aquamarine_hoe", properties -> new HoeItem(GemistryToolMaterial.AQUAMARINE, -4.0F, 0.0F, properties));
    public static final DeferredItem<Item> AQUAMARINE_SPEAR = ITEMS.registerItem("aquamarine_spear", properties -> new Item(properties.spear(GemistryToolMaterial.AQUAMARINE, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
    public static final DeferredItem<Item> AQUAMARINE_HELMET = ITEMS.registerItem("aquamarine_helmet", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AQUAMARINE, ArmorType.HELMET)));
    public static final DeferredItem<Item> AQUAMARINE_CHESTPLATE = ITEMS.registerItem("aquamarine_chestplate", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AQUAMARINE, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> AQUAMARINE_LEGGINGS = ITEMS.registerItem("aquamarine_leggings", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AQUAMARINE, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> AQUAMARINE_BOOTS = ITEMS.registerItem("aquamarine_boots", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AQUAMARINE, ArmorType.BOOTS)));
    public static final DeferredItem<Item> AQUAMARINE_HORSE_ARMOR = ITEMS.registerItem("aquamarine_horse_armor", properties -> new Item(properties.horseArmor(GemistryArmorMaterial.AQUAMARINE)));
    public static final DeferredItem<Item> AQUAMARINE_NAUTILUS_ARMOR = ITEMS.registerItem("aquamarine_nautilus_armor", properties -> new Item(properties.nautilusArmor(GemistryArmorMaterial.AQUAMARINE)));
    public static final DeferredItem<Item> AMBER = ITEMS.registerItem("amber", properties -> new Item(properties.delayedHolderComponent(DataComponents.PROVIDES_TRIM_MATERIAL, GemistryTrimMaterials.AMBER)));
    public static final DeferredItem<BlockItem> AMBER_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.AMBER_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_AMBER_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.DEEPSLATE_AMBER_ORE);
    public static final DeferredItem<BlockItem> AMBER_BLOCK = ITEMS.registerSimpleBlockItem(GemistryBlocks.AMBER_BLOCK);
    public static final DeferredItem<Item> AMBER_SWORD = ITEMS.registerItem("amber_sword", properties -> new Item(properties.sword(GemistryToolMaterial.AMBER, 3.0F, -2.4F)));
    public static final DeferredItem<Item> AMBER_PICKAXE = ITEMS.registerItem("amber_pickaxe", properties -> new Item(properties.pickaxe(GemistryToolMaterial.AMBER, 1.0F, -2.8F)));
    public static final DeferredItem<Item> AMBER_AXE = ITEMS.registerItem("amber_axe", properties -> new AxeItem(GemistryToolMaterial.AMBER, 5.0F, -3.0F, properties));
    public static final DeferredItem<Item> AMBER_SHOVEL = ITEMS.registerItem("amber_shovel", properties -> new ShovelItem(GemistryToolMaterial.AMBER, 1.5F, -3.0F, properties));
    public static final DeferredItem<Item> AMBER_HOE = ITEMS.registerItem("amber_hoe", properties -> new HoeItem(GemistryToolMaterial.AMBER, -4.0F, 0.0F, properties));
    public static final DeferredItem<Item> AMBER_SPEAR = ITEMS.registerItem("amber_spear", properties -> new Item(properties.spear(GemistryToolMaterial.AMBER, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
    public static final DeferredItem<Item> AMBER_HELMET = ITEMS.registerItem("amber_helmet", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AMBER, ArmorType.HELMET)));
    public static final DeferredItem<Item> AMBER_CHESTPLATE = ITEMS.registerItem("amber_chestplate", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AMBER, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> AMBER_LEGGINGS = ITEMS.registerItem("amber_leggings", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AMBER, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> AMBER_BOOTS = ITEMS.registerItem("amber_boots", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.AMBER, ArmorType.BOOTS)));
    public static final DeferredItem<Item> AMBER_HORSE_ARMOR = ITEMS.registerItem("amber_horse_armor", properties -> new Item(properties.horseArmor(GemistryArmorMaterial.AMBER)));
    public static final DeferredItem<Item> AMBER_NAUTILUS_ARMOR = ITEMS.registerItem("amber_nautilus_armor", properties -> new Item(properties.nautilusArmor(GemistryArmorMaterial.AMBER)));

    private GemistryItems() {
    }
}