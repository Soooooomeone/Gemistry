package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryBlocks;
import com.danako.gemistry.core.GemistryItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;


public class GemistryModelProvider extends ModelProvider {

    public GemistryModelProvider(PackOutput output) {
        super(output, Gemistry.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        registerBlockModels(blockModels);
        registerItemModels(itemModels);
    }

    private void registerBlockModels(BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(GemistryBlocks.RUBY_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.DEEPSLATE_RUBY_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.RUBY_BLOCK.get());

        blockModels.createTrivialCube(GemistryBlocks.SAPPHIRE_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.SAPPHIRE_BLOCK.get());

        blockModels.createTrivialCube(GemistryBlocks.AQUAMARINE_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.AQUAMARINE_BLOCK.get());

        blockModels.createTrivialCube(GemistryBlocks.AMBER_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.DEEPSLATE_AMBER_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.AMBER_BLOCK.get());
    }

    private void registerItemModels(ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(GemistryItems.RUBY.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.RUBY_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.RUBY_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.RUBY_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.SAPPHIRE_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.AQUAMARINE_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AMBER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AMBER_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.AMBER_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.AMBER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
    }

    private void registerSpearModel(ItemModelGenerators itemModels, Item spearItem) {
        ItemModel.Unbaked guiModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, ModelTemplates.FLAT_HANDHELD_ITEM));

        ItemModel.Unbaked inHandModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, "_in_hand", ModelTemplates.SPEAR_IN_HAND));

        itemModels.itemModelOutput.accept(spearItem, ItemModelUtils.select(new DisplayContext(), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.GUI, guiModel), ItemModelUtils.when(ItemDisplayContext.GROUND, guiModel), ItemModelUtils.when(ItemDisplayContext.FIXED, guiModel), ItemModelUtils.when(ItemDisplayContext.HEAD, guiModel), ItemModelUtils.when(ItemDisplayContext.NONE, guiModel)));
    }
}