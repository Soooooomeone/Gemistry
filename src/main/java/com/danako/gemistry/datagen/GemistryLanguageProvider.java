package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryBlocks;
import com.danako.gemistry.core.GemistryItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class GemistryLanguageProvider extends LanguageProvider {

    public GemistryLanguageProvider(PackOutput output) {
        super(output, Gemistry.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + Gemistry.MODID + ".gemistry", "Gemistry");
        addBlock(GemistryBlocks.RUBY_ORE, "Ruby Ore");
        addBlock(GemistryBlocks.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore");
        addBlock(GemistryBlocks.RUBY_BLOCK, "Block of Ruby");
        addItem(GemistryItems.RUBY, "Ruby");
        addItem(GemistryItems.RUBY_SWORD, "Ruby Sword");
        addItem(GemistryItems.RUBY_PICKAXE, "Ruby Pickaxe");
        addItem(GemistryItems.RUBY_AXE, "Ruby Axe");
        addItem(GemistryItems.RUBY_SHOVEL, "Ruby Shovel");
        addItem(GemistryItems.RUBY_HOE, "Ruby Hoe");
        addItem(GemistryItems.RUBY_SPEAR, "Ruby Spear");
        addItem(GemistryItems.RUBY_HELMET, "Ruby Helmet");
        addItem(GemistryItems.RUBY_CHESTPLATE, "Ruby Chestplate");
        addItem(GemistryItems.RUBY_LEGGINGS, "Ruby Leggings");
        addItem(GemistryItems.RUBY_BOOTS, "Ruby Boots");
        addItem(GemistryItems.RUBY_HORSE_ARMOR, "Ruby Horse Armor");
        addItem(GemistryItems.RUBY_NAUTILUS_ARMOR, "Ruby Nautilus Armor");
        addBlock(GemistryBlocks.SAPPHIRE_ORE, "Sapphire Ore");
        addBlock(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE, "Deepslate Sapphire Ore");
        addBlock(GemistryBlocks.SAPPHIRE_BLOCK, "Block of Sapphire");
        addItem(GemistryItems.SAPPHIRE, "Sapphire");
        addItem(GemistryItems.SAPPHIRE_SWORD, "Sapphire Sword");
        addItem(GemistryItems.SAPPHIRE_PICKAXE, "Sapphire Pickaxe");
        addItem(GemistryItems.SAPPHIRE_AXE, "Sapphire Axe");
        addItem(GemistryItems.SAPPHIRE_SHOVEL, "Sapphire Shovel");
        addItem(GemistryItems.SAPPHIRE_HOE, "Sapphire Hoe");
        addItem(GemistryItems.SAPPHIRE_SPEAR, "Sapphire Spear");
        addItem(GemistryItems.SAPPHIRE_HELMET, "Sapphire Helmet");
        addItem(GemistryItems.SAPPHIRE_CHESTPLATE, "Sapphire Chestplate");
        addItem(GemistryItems.SAPPHIRE_LEGGINGS, "Sapphire Leggings");
        addItem(GemistryItems.SAPPHIRE_BOOTS, "Sapphire Boots");
        addItem(GemistryItems.SAPPHIRE_HORSE_ARMOR, "Sapphire Horse Armor");
        addItem(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR, "Sapphire Nautilus Armor");
        addBlock(GemistryBlocks.AQUAMARINE_ORE, "Aquamarine Ore");
        addBlock(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE, "Deepslate Aquamarine Ore");
        addBlock(GemistryBlocks.AQUAMARINE_BLOCK, "Block of Aquamarine");
        addItem(GemistryItems.AQUAMARINE, "Aquamarine");
        addItem(GemistryItems.AQUAMARINE_SWORD, "Aquamarine Sword");
        addItem(GemistryItems.AQUAMARINE_PICKAXE, "Aquamarine Pickaxe");
        addItem(GemistryItems.AQUAMARINE_AXE, "Aquamarine Axe");
        addItem(GemistryItems.AQUAMARINE_SHOVEL, "Aquamarine Shovel");
        addItem(GemistryItems.AQUAMARINE_HOE, "Aquamarine Hoe");
        addItem(GemistryItems.AQUAMARINE_SPEAR, "Aquamarine Spear");
        addItem(GemistryItems.AQUAMARINE_HELMET, "Aquamarine Helmet");
        addItem(GemistryItems.AQUAMARINE_CHESTPLATE, "Aquamarine Chestplate");
        addItem(GemistryItems.AQUAMARINE_LEGGINGS, "Aquamarine Leggings");
        addItem(GemistryItems.AQUAMARINE_BOOTS, "Aquamarine Boots");
        addItem(GemistryItems.AQUAMARINE_HORSE_ARMOR, "Aquamarine Horse Armor");
        addItem(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR, "Aquamarine Nautilus Armor");
        addBlock(GemistryBlocks.AMBER_ORE, "Amber Ore");
        addBlock(GemistryBlocks.DEEPSLATE_AMBER_ORE, "Deepslate Amber Ore");
        addBlock(GemistryBlocks.AMBER_BLOCK, "Block of Amber");
        addItem(GemistryItems.AMBER, "Amber");
        addItem(GemistryItems.AMBER_SWORD, "Amber Sword");
        addItem(GemistryItems.AMBER_PICKAXE, "Amber Pickaxe");
        addItem(GemistryItems.AMBER_AXE, "Amber Axe");
        addItem(GemistryItems.AMBER_SHOVEL, "Amber Shovel");
        addItem(GemistryItems.AMBER_HOE, "Amber Hoe");
        addItem(GemistryItems.AMBER_SPEAR, "Amber Spear");
        addItem(GemistryItems.AMBER_HELMET, "Amber Helmet");
        addItem(GemistryItems.AMBER_CHESTPLATE, "Amber Chestplate");
        addItem(GemistryItems.AMBER_LEGGINGS, "Amber Leggings");
        addItem(GemistryItems.AMBER_BOOTS, "Amber Boots");
        addItem(GemistryItems.AMBER_HORSE_ARMOR, "Amber Horse Armor");
        addItem(GemistryItems.AMBER_NAUTILUS_ARMOR, "Amber Nautilus Armor");
    }
}