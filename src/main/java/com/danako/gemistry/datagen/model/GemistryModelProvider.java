package com.danako.gemistry.datagen.model;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.common.block.GemistryBlocks;
import com.danako.gemistry.common.item.GemistryItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;

import java.util.Optional;


public class GemistryModelProvider extends ModelProvider {

    private static final ModelTemplate ATTUNEMENT_TABLE_TEMPLATE = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Gemistry.MODID, "block/template_attunement_table")),
            Optional.empty(),
            TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM, TextureSlot.PARTICLE
    );

    private Identifier attunementTableModel;

    public GemistryModelProvider(PackOutput output) {
        super(output, Gemistry.MODID);
    }

    private void generateTrimmableItemWithGems(ItemModelGenerators itemModels, Item armor, Identifier slotTrimPrefix) {
        itemModels.createFlatItemModel(armor, ModelTemplates.FLAT_ITEM);
        itemModels.generateDynamicTrimmableItem(armor, slotTrimPrefix);
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

        blockModels.createTrivialCube(GemistryBlocks.ONYX_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.DEEPSLATE_ONYX_ORE.get());
        blockModels.createTrivialCube(GemistryBlocks.ONYX_BLOCK.get());

        registerAttunementTable(blockModels);
    }

    private void registerAttunementTable(BlockModelGenerators blockModels) {
        Block block = GemistryBlocks.ATTUNEMENT_TABLE.get();

        TextureMapping mapping = new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom"))
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_bottom"));

        Identifier modelLocation = ATTUNEMENT_TABLE_TEMPLATE.create(block, mapping, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(modelLocation)));

        this.attunementTableModel = modelLocation;
    }

    private void registerItemModels(ItemModelGenerators itemModels) {
        itemModels.itemModelOutput.accept(GemistryItems.ATTUNEMENT_TABLE.get(), ItemModelUtils.plainModel(attunementTableModel));

        itemModels.generateFlatItem(GemistryItems.RUBY.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.RUBY_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.RUBY_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.RUBY_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.RUBY_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.SAPPHIRE_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.AQUAMARINE_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AMBER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.AMBER_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.AMBER_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.AMBER_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.AMBER_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.ONYX.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(GemistryItems.ONYX_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.ONYX_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.ONYX_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.ONYX_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(GemistryItems.ONYX_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, GemistryItems.ONYX_SPEAR.get());

        itemModels.generateFlatItem(GemistryItems.ONYX_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(GemistryItems.ONYX_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        generateTrimmableItemWithGems(itemModels, GemistryItems.RUBY_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        generateTrimmableItemWithGems(itemModels, GemistryItems.RUBY_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        generateTrimmableItemWithGems(itemModels, GemistryItems.RUBY_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.RUBY_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.SAPPHIRE_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        generateTrimmableItemWithGems(itemModels, GemistryItems.SAPPHIRE_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        generateTrimmableItemWithGems(itemModels, GemistryItems.SAPPHIRE_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.SAPPHIRE_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AQUAMARINE_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AQUAMARINE_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AQUAMARINE_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AQUAMARINE_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AMBER_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AMBER_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AMBER_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.AMBER_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.ONYX_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        generateTrimmableItemWithGems(itemModels, GemistryItems.ONYX_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        generateTrimmableItemWithGems(itemModels, GemistryItems.ONYX_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        generateTrimmableItemWithGems(itemModels, GemistryItems.ONYX_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);
    }

    private void registerSpearModel(ItemModelGenerators itemModels, Item spearItem) {
        ItemModel.Unbaked guiModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, ModelTemplates.FLAT_HANDHELD_ITEM));

        ItemModel.Unbaked inHandModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, "_in_hand", ModelTemplates.SPEAR_IN_HAND));

        itemModels.itemModelOutput.accept(spearItem, ItemModelUtils.select(new DisplayContext(), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.GUI, guiModel), ItemModelUtils.when(ItemDisplayContext.GROUND, guiModel), ItemModelUtils.when(ItemDisplayContext.FIXED, guiModel), ItemModelUtils.when(ItemDisplayContext.HEAD, guiModel), ItemModelUtils.when(ItemDisplayContext.NONE, guiModel)));
    }
}