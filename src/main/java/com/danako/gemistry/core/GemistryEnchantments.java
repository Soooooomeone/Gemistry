package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public class GemistryEnchantments {

    public static final ResourceKey<Enchantment> VENOMOUS_ASPECT = key("venomous_aspect");
    public static final ResourceKey<Enchantment> FROST_ASPECT = key("frost_aspect");
    public static final ResourceKey<Enchantment> FROST_PROTECTION = key("frost_protection");
    public static final ResourceKey<Enchantment> PURIFICATION = key("purification");
    public static final ResourceKey<Enchantment> VITALITY = key("vitality");
    public static final ResourceKey<Enchantment> SOULBOUND = key("soulbound");
    public static final ResourceKey<Enchantment> LEECHING = key("leeching");
    public static final ResourceKey<Enchantment> VIGILANTE = key("vigilante");
    public static final ResourceKey<Enchantment> INSIGHT = key("insight");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        register(context, VENOMOUS_ASPECT, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.FIRE_ASPECT_ENCHANTABLE),
                        2, 2,
                        Enchantment.dynamicCost(10, 20),
                        Enchantment.dynamicCost(60, 20),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}
                )
        ));

        register(context, FROST_ASPECT, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.FIRE_ASPECT_ENCHANTABLE),
                        2, 2,
                        Enchantment.dynamicCost(10, 20),
                        Enchantment.dynamicCost(60, 20),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}
                )
        ));

        register(context, FROST_PROTECTION, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        5, 4,
                        Enchantment.dynamicCost(10, 8),
                        Enchantment.dynamicCost(18, 8),
                        2,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.ARMOR}
                )
        ));

        register(context, PURIFICATION, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.ARMOR}
                )
        ));

        register(context, VITALITY, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(20, 9),
                        Enchantment.dynamicCost(70, 9),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.ARMOR}
                )
        ));

        register(context, SOULBOUND, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE),
                        1, 1,
                        Enchantment.constantCost(25),
                        Enchantment.constantCost(50),
                        8,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.ANY}
                )
        ));

        register(context, LEECHING, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}
                )
        ));

        register(context, VIGILANTE, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        5, 5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}
                )
        ));

        register(context, INSIGHT, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}
                )
        ));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    private static ResourceKey<Enchantment> key(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, id));
    }
}