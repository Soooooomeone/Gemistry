package com.danako.gemistry.core.enchantment;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.tag.GemistryTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;


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
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT); // add this

        register(context, VENOMOUS_ASPECT, Enchantment.enchantment(
                        Enchantment.definition(
                                items.getOrThrow(GemistryTags.GEMISTRY_ASPECT_ENCHANTABLE),
                                2, 2,
                                Enchantment.dynamicCost(10, 20),
                                Enchantment.dynamicCost(60, 20),
                                4,
                                EquipmentSlotGroup.MAINHAND)
                ).exclusiveWith(enchantments.getOrThrow(GemistryTags.EXCLUSIVE_SET_ASPECT))
                .withEffect(
                        EnchantmentEffectComponents.POST_ATTACK,
                        EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM,
                        new GemistryEntityEffects.ApplyMobEffectScaled(
                                MobEffects.POISON,
                                LevelBasedValue.perLevel(60.0F, 40.0F),
                                LevelBasedValue.constant(0.0F)
                        )
                ));

        register(context, FROST_ASPECT, Enchantment.enchantment(
                        Enchantment.definition(
                                items.getOrThrow(GemistryTags.GEMISTRY_ASPECT_ENCHANTABLE),
                                2, 2,
                                Enchantment.dynamicCost(10, 20),
                                Enchantment.dynamicCost(60, 20),
                                4,
                                EquipmentSlotGroup.MAINHAND)
                ).exclusiveWith(enchantments.getOrThrow(GemistryTags.EXCLUSIVE_SET_ASPECT))
                .withEffect(
                        EnchantmentEffectComponents.POST_ATTACK,
                        EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM,
                        new GemistryEntityEffects.IncreaseFreezeTicks(
                                LevelBasedValue.perLevel(80.0F, 60.0F)
                        )
                ));

        register(context, FROST_PROTECTION, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        5, 4,
                        Enchantment.dynamicCost(10, 8),
                        Enchantment.dynamicCost(18, 8),
                        2,
                        EquipmentSlotGroup.ARMOR)
        ));

        register(context, PURIFICATION, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        EquipmentSlotGroup.ARMOR)
        ));

        register(context, VITALITY, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(20, 9),
                        Enchantment.dynamicCost(70, 9),
                        4,
                        EquipmentSlotGroup.ARMOR)
        ));

        register(context, SOULBOUND, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE),
                        1, 1,
                        Enchantment.constantCost(25),
                        Enchantment.constantCost(50),
                        8,
                        EquipmentSlotGroup.ANY)
        ));

        register(context, LEECHING, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        EquipmentSlotGroup.MAINHAND)
        ));

        register(context, VIGILANTE, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                        5, 5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.MAINHAND)
        ));

        register(context, INSIGHT, Enchantment.enchantment(
                Enchantment.definition(
                        items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        2, 3,
                        Enchantment.dynamicCost(15, 9),
                        Enchantment.dynamicCost(65, 9),
                        4,
                        EquipmentSlotGroup.MAINHAND)
        ));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    private static ResourceKey<Enchantment> key(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, id));
    }
}