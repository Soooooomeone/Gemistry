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
    }
}