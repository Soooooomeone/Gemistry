package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.item.GemistryArmorMaterial;
import com.danako.gemistry.item.GemistryToolMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class GemistryItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gemistry.MODID);
    public static final DeferredItem<Item> RUBY = ITEMS.registerItem("ruby", Item::new);
    public static final DeferredItem<BlockItem> RUBY_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.RUBY_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_RUBY_ORE = ITEMS.registerSimpleBlockItem(GemistryBlocks.DEEPSLATE_RUBY_ORE);
    public static final DeferredItem<BlockItem> RUBY_BLOCK = ITEMS.registerSimpleBlockItem(GemistryBlocks.RUBY_BLOCK);
    public static final DeferredItem<Item> RUBY_SWORD = ITEMS.registerItem("ruby_sword", properties -> new Item(properties.sword(GemistryToolMaterial.RUBY, 3.0F, -2.4F)));
    public static final DeferredItem<Item> RUBY_PICKAXE = ITEMS.registerItem("ruby_pickaxe", properties -> new Item(properties.pickaxe(GemistryToolMaterial.RUBY, 1.0F, -2.8F)));
    public static final DeferredItem<Item> RUBY_AXE = ITEMS.registerItem("ruby_axe", properties -> new AxeItem(GemistryToolMaterial.RUBY, 5.0F, -3.0F, properties));
    public static final DeferredItem<Item> RUBY_SHOVEL = ITEMS.registerItem("ruby_shovel", properties -> new ShovelItem(GemistryToolMaterial.RUBY, 1.5F, -3.0F, properties));
    public static final DeferredItem<Item> RUBY_HOE = ITEMS.registerItem("ruby_hoe", properties -> new HoeItem(GemistryToolMaterial.RUBY, -4.0F, 0.0F, properties));
    public static final DeferredItem<Item> RUBY_SPEAR = ITEMS.registerItem("ruby_spear", properties -> new Item(properties.spear(GemistryToolMaterial.RUBY, 1.15F,
            1.2F,
            0.4F,
            2.5F,
            9.0F,
            5.5F,
            5.1F,
            8.75F,
            4.6F
    )));
    public static final DeferredItem<Item> RUBY_HELMET = ITEMS.registerItem("ruby_helmet", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.HELMET)));
    public static final DeferredItem<Item> RUBY_CHESTPLATE = ITEMS.registerItem("ruby_chestplate", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> RUBY_LEGGINGS = ITEMS.registerItem("ruby_leggings", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> RUBY_BOOTS = ITEMS.registerItem("ruby_boots", properties -> new Item(properties.humanoidArmor(GemistryArmorMaterial.RUBY, ArmorType.BOOTS)));
    public static final DeferredItem<Item> RUBY_HORSE_ARMOR = ITEMS.registerItem("ruby_horse_armor", properties -> new Item(properties.horseArmor(GemistryArmorMaterial.RUBY)));
    public static final DeferredItem<Item> RUBY_NAUTILUS_ARMOR = ITEMS.registerItem("ruby_nautilus_armor", properties -> new Item(properties.nautilusArmor(GemistryArmorMaterial.RUBY)));
    private GemistryItems() {
    }
}