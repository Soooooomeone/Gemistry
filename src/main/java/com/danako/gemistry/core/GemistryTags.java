package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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

    private GemistryTags() {
    }
}