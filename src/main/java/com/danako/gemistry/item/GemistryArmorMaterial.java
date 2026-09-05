package com.danako.gemistry.item;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;
import java.util.Map;

public final class GemistryArmorMaterial {

    public static final ResourceKey<EquipmentAsset> RUBY_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gemistry.MODID, "ruby"));
    public static final ArmorMaterial RUBY = new ArmorMaterial(35, makeDefense(3, 6, 8, 3, 19), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.0F, GemistryTags.REPAIRS_RUBY_ARMOR, RUBY_ARMOR_ASSET);

    public static final ResourceKey<EquipmentAsset> SAPPHIRE_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gemistry.MODID, "sapphire"));
    public static final ArmorMaterial SAPPHIRE = new ArmorMaterial(35, makeDefense(3, 6, 8, 3, 19), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.0F, GemistryTags.REPAIRS_SAPPHIRE_ARMOR, SAPPHIRE_ARMOR_ASSET);

    public static final ResourceKey<EquipmentAsset> AQUAMARINE_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gemistry.MODID, "aquamarine"));
    public static final ArmorMaterial AQUAMARINE = new ArmorMaterial(33, makeDefense(3, 6, 8, 3, 11), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, GemistryTags.REPAIRS_AQUAMARINE_ARMOR, AQUAMARINE_ARMOR_ASSET);

    public static final ResourceKey<EquipmentAsset> AMBER_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gemistry.MODID, "amber"));
    public static final ArmorMaterial AMBER = new ArmorMaterial(30, makeDefense(2, 6, 8, 3, 10), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.5F, 0.0F, GemistryTags.REPAIRS_AMBER_ARMOR, AMBER_ARMOR_ASSET);

    private GemistryArmorMaterial() {
    }

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helmet, int body) {
        Map<ArmorType, Integer> defense = new EnumMap<>(ArmorType.class);
        defense.put(ArmorType.BOOTS, boots);
        defense.put(ArmorType.LEGGINGS, legs);
        defense.put(ArmorType.CHESTPLATE, chest);
        defense.put(ArmorType.HELMET, helmet);
        defense.put(ArmorType.BODY, body);
        return defense;
    }
}