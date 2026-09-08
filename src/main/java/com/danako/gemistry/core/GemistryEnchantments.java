package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public final class GemistryEnchantments {

    public static final ResourceKey<Enchantment> FROST_PROTECTION = key("frost_protection");
    public static final ResourceKey<Enchantment> FROST_ASPECT = key("frost_aspect");
    public static final ResourceKey<Enchantment> ILLAGERS_BANE = key("illagers_bane");
    public static final ResourceKey<Enchantment> VENOM_ASPECT = key("venom_aspect");
    public static final ResourceKey<Enchantment> PURIFICATION = key("purification");
    public static final ResourceKey<Enchantment> LEECHING = key("leeching");
    public static final ResourceKey<Enchantment> VITALITY = key("vitality");
    public static final ResourceKey<Enchantment> INSIGHT = key("insight");
    public static final ResourceKey<Enchantment> PROSPERITY = key("prosperity");
    public static final ResourceKey<Enchantment> SWINES_BANE = key("swines_bane");
    public static final ResourceKey<Enchantment> REFINING_TOUCH = key("refining_touch");
    public static final ResourceKey<Enchantment> SOULBOUND = key("soulbound");
    public static final ResourceKey<Enchantment> EXCAVATION = key("excavation");

    private GemistryEnchantments() {
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        register(context, FROST_PROTECTION, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 5, 4,
                                Enchantment.dynamicCost(10, 8), Enchantment.dynamicCost(18, 8), 2,
                                EquipmentSlotGroup.ARMOR))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE)));

        register(context, FROST_ASPECT, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.FIRE_ASPECT_ENCHANTABLE), 2, 2,
                                Enchantment.dynamicCost(10, 20), Enchantment.dynamicCost(60, 20), 4,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(HolderSet.direct(
                        enchantments.getOrThrow(Enchantments.FIRE_ASPECT),
                        enchantments.getOrThrow(VENOM_ASPECT))));

        register(context, ILLAGERS_BANE, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE), 5, 5,
                                Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE)));

        register(context, VENOM_ASPECT, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.FIRE_ASPECT_ENCHANTABLE), 2, 2,
                                Enchantment.dynamicCost(10, 20), Enchantment.dynamicCost(60, 20), 4,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(HolderSet.direct(
                        enchantments.getOrThrow(Enchantments.FIRE_ASPECT),
                        enchantments.getOrThrow(FROST_ASPECT))));

        register(context, PURIFICATION, Enchantment.enchantment(
                Enchantment.definition(items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 2, 4,
                        Enchantment.dynamicCost(10, 10), Enchantment.dynamicCost(40, 10), 4,
                        EquipmentSlotGroup.ARMOR)));

        register(context, LEECHING, Enchantment.enchantment(
                Enchantment.definition(items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE), 2, 3,
                        Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4,
                        EquipmentSlotGroup.MAINHAND)));

        register(context, VITALITY, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                items.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE), 1, 3,
                                Enchantment.dynamicCost(10, 20), Enchantment.dynamicCost(60, 20), 8,
                                EquipmentSlotGroup.ANY))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.THORNS))));

        register(context, INSIGHT, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE), 2, 3,
                                Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.MENDING))));

        register(context, PROSPERITY, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.MINING_ENCHANTABLE), 2, 3,
                                Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.MENDING))));

        register(context, SWINES_BANE, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE), 5, 5,
                                Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE)));

        register(context, REFINING_TOUCH, Enchantment.enchantment(
                        Enchantment.definition(items.getOrThrow(ItemTags.MINING_ENCHANTABLE), 1, 1,
                                Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4,
                                EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(HolderSet.direct(
                        enchantments.getOrThrow(Enchantments.FORTUNE),
                        enchantments.getOrThrow(Enchantments.SILK_TOUCH),
                        enchantments.getOrThrow(PROSPERITY))));

        register(context, SOULBOUND, Enchantment.enchantment(
                Enchantment.definition(items.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE), 1, 1,
                        Enchantment.dynamicCost(25, 25), Enchantment.dynamicCost(75, 25), 4,
                        EquipmentSlotGroup.ANY)));

        register(context, EXCAVATION, Enchantment.enchantment(
                Enchantment.definition(items.getOrThrow(ItemTags.PICKAXES), 5, 3,
                        Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4,
                        EquipmentSlotGroup.MAINHAND)));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    private static ResourceKey<Enchantment> key(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, id));
    }
}