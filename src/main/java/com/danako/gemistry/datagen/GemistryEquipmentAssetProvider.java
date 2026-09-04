package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.item.GemistryArmorMaterial;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Optional;
import java.util.function.BiConsumer;


public class GemistryEquipmentAssetProvider extends EquipmentAssetProvider {

    public GemistryEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        Identifier rubyTexture = Identifier.fromNamespaceAndPath(Gemistry.MODID, "ruby");

        output.accept(GemistryArmorMaterial.RUBY_ARMOR_ASSET, EquipmentClientInfo.builder()

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(rubyTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(rubyTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(rubyTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(rubyTexture, Optional.empty(), false)).build());

        Identifier sapphireTexture = Identifier.fromNamespaceAndPath(Gemistry.MODID, "sapphire");

        output.accept(GemistryArmorMaterial.SAPPHIRE_ARMOR_ASSET, EquipmentClientInfo.builder()

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(sapphireTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(sapphireTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(sapphireTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(sapphireTexture, Optional.empty(), false)).build());

        Identifier aquamarineTexture = Identifier.fromNamespaceAndPath(Gemistry.MODID, "aquamarine");

        output.accept(GemistryArmorMaterial.AQUAMARINE_ARMOR_ASSET, EquipmentClientInfo.builder()

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(aquamarineTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(aquamarineTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(aquamarineTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(aquamarineTexture, Optional.empty(), false)).build());
    }
}