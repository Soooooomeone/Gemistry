package com.danako.gemistry.tag;

import com.danako.gemistry.Gemistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public final class GemistryTags {

    public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Gemistry.MODID, "incorrect_for_ruby_tool"));
    public static final TagKey<Item> RUBY_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "ruby_tool_materials"));
    public static final TagKey<Item> REPAIRS_RUBY_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "repairs_ruby_armor"));
    public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Gemistry.MODID, "incorrect_for_sapphire_tool"));
    public static final TagKey<Item> SAPPHIRE_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "sapphire_tool_materials"));
    public static final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "repairs_sapphire_armor"));
    public static final TagKey<Block> INCORRECT_FOR_AQUAMARINE_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Gemistry.MODID, "incorrect_for_aquamarine_tool"));
    public static final TagKey<Item> AQUAMARINE_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "aquamarine_tool_materials"));
    public static final TagKey<Item> REPAIRS_AQUAMARINE_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "repairs_aquamarine_armor"));
    public static final TagKey<Block> INCORRECT_FOR_AMBER_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Gemistry.MODID, "incorrect_for_amber_tool"));
    public static final TagKey<Item> AMBER_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "amber_tool_materials"));
    public static final TagKey<Item> REPAIRS_AMBER_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "repairs_amber_armor"));
    public static final TagKey<Block> INCORRECT_FOR_ONYX_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Gemistry.MODID, "incorrect_for_onyx_tool"));
    public static final TagKey<Item> ONYX_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "onyx_tool_materials"));
    public static final TagKey<Item> REPAIRS_ONYX_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "repairs_onyx_armor"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS_RUBY = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts/ruby"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS_SAPPHIRE = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts/sapphire"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS_AQUAMARINE = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts/aquamarine"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS_AMBER = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts/amber"));
    public static final TagKey<Item> ATTUNEMENT_CATALYSTS_ONYX = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement_catalysts/onyx"));
    public static final TagKey<Enchantment> ATTUNEMENT_PYRIC = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/pyric"));
    public static final TagKey<Enchantment> ATTUNEMENT_BOREAL = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/boreal"));
    public static final TagKey<Enchantment> ATTUNEMENT_MIASMIC = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/miasmic"));
    public static final TagKey<Enchantment> ATTUNEMENT_ABYSSAL = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/abyssal"));
    public static final TagKey<Enchantment> ATTUNEMENT_UMBRAL = TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/umbral"));

    private GemistryTags() {
    }
}