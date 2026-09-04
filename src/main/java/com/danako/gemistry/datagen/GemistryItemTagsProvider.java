package com.danako.gemistry.datagen;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.GemistryItems;
import com.danako.gemistry.core.GemistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class GemistryItemTagsProvider extends ItemTagsProvider {

    public GemistryItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, Gemistry.MODID);
    }

    private static TagKey<Item> commonTag(String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaToolTypeTags();
        addVanillaArmorSlotTags();
        addVanillaMiscTags();
        addEnchantableTags();
        addNeoForgeConventionTags();
        addCustomTags();
    }

    private void addVanillaToolTypeTags() {
        tag(ItemTags.SWORDS).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AMBER_SWORD.get());

        tag(ItemTags.AXES).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AMBER_AXE.get());

        tag(ItemTags.PICKAXES).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AMBER_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AMBER_SHOVEL.get());

        tag(ItemTags.HOES).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AMBER_HOE.get());

        tag(ItemTags.SPEARS).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AMBER_PICKAXE.get());
    }

    private void addVanillaArmorSlotTags() {
        tag(ItemTags.HEAD_ARMOR).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AMBER_HELMET.get());

        tag(ItemTags.CHEST_ARMOR).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AMBER_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AMBER_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AMBER_BOOTS.get());
    }

    private void addVanillaMiscTags() {
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(GemistryItems.RUBY.get()).add(GemistryItems.SAPPHIRE.get()).add(GemistryItems.AQUAMARINE.get()).add(GemistryItems.AMBER.get());

        tag(ItemTags.TRIM_MATERIALS).add(GemistryItems.RUBY.get()).add(GemistryItems.SAPPHIRE.get()).add(GemistryItems.AQUAMARINE.get()).add(GemistryItems.AMBER.get());
    }

    private void addEnchantableTags() {
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(ItemTags.MINING_ENCHANTABLE).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AMBER_PICKAXE.get()).add(GemistryItems.AMBER_AXE.get()).add(GemistryItems.AMBER_SHOVEL.get()).add(GemistryItems.AMBER_HOE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AMBER_PICKAXE.get()).add(GemistryItems.AMBER_AXE.get()).add(GemistryItems.AMBER_SHOVEL.get()).add(GemistryItems.AMBER_HOE.get());

        tag(ItemTags.SWEEPING_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AMBER_SWORD.get());

        tag(ItemTags.LUNGE_ENCHANTABLE).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_AXE.get());

        tag(ItemTags.WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.SAPPHIRE_HORSE_ARMOR.get()).add(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AQUAMARINE_HORSE_ARMOR.get()).add(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get()).add(GemistryItems.AMBER_HELMET.get()).add(GemistryItems.AMBER_CHESTPLATE.get()).add(GemistryItems.AMBER_LEGGINGS.get()).add(GemistryItems.AMBER_BOOTS.get()).add(GemistryItems.AMBER_HORSE_ARMOR.get()).add(GemistryItems.AMBER_NAUTILUS_ARMOR.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AMBER_HELMET.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AMBER_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AMBER_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AMBER_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.SAPPHIRE_HORSE_ARMOR.get()).add(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AQUAMARINE_HORSE_ARMOR.get()).add(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_SPEAR.get()).add(GemistryItems.AMBER_PICKAXE.get()).add(GemistryItems.AMBER_AXE.get()).add(GemistryItems.AMBER_SHOVEL.get()).add(GemistryItems.AMBER_HOE.get()).add(GemistryItems.AMBER_HELMET.get()).add(GemistryItems.AMBER_CHESTPLATE.get()).add(GemistryItems.AMBER_LEGGINGS.get()).add(GemistryItems.AMBER_BOOTS.get()).add(GemistryItems.AMBER_HORSE_ARMOR.get()).add(GemistryItems.AMBER_NAUTILUS_ARMOR.get());

        tag(ItemTags.VANISHING_ENCHANTABLE).addTag(ItemTags.DURABILITY_ENCHANTABLE);
    }

    private void addNeoForgeConventionTags() {
        tag(commonTag("gems/ruby")).add(GemistryItems.RUBY.get());
        tag(commonTag("storage_blocks/ruby")).add(GemistryItems.RUBY_BLOCK.get());

        tag(commonTag("gems/sapphire")).add(GemistryItems.SAPPHIRE.get());
        tag(commonTag("storage_blocks/sapphire")).add(GemistryItems.SAPPHIRE_BLOCK.get());

        tag(commonTag("gems/aquamarine")).add(GemistryItems.AQUAMARINE.get());
        tag(commonTag("storage_blocks/aquamarine")).add(GemistryItems.AQUAMARINE_BLOCK.get());

        tag(commonTag("gems/amber")).add(GemistryItems.AMBER.get());
        tag(commonTag("storage_blocks/amber")).add(GemistryItems.AMBER_BLOCK.get());

        tag(commonTag("tools/mining_tool")).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AMBER_PICKAXE.get());

        tag(commonTag("tools/melee_weapon")).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_AXE.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(commonTag("tools/pickaxe")).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AMBER_PICKAXE.get());

        tag(commonTag("tools/axe")).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AMBER_AXE.get());

        tag(commonTag("tools/shovel")).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AMBER_SHOVEL.get());

        tag(commonTag("tools/hoe")).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AMBER_HOE.get());

        tag(commonTag("tools/sword")).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AMBER_SWORD.get());

        tag(commonTag("tools/spear")).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AMBER_SPEAR.get());

        tag(Tags.Items.TOOLS).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.SAPPHIRE_SWORD.get()).add(GemistryItems.SAPPHIRE_SPEAR.get()).add(GemistryItems.SAPPHIRE_PICKAXE.get()).add(GemistryItems.SAPPHIRE_AXE.get()).add(GemistryItems.SAPPHIRE_SHOVEL.get()).add(GemistryItems.SAPPHIRE_HOE.get()).add(GemistryItems.AQUAMARINE_SWORD.get()).add(GemistryItems.AQUAMARINE_SPEAR.get()).add(GemistryItems.AQUAMARINE_PICKAXE.get()).add(GemistryItems.AQUAMARINE_AXE.get()).add(GemistryItems.AQUAMARINE_SHOVEL.get()).add(GemistryItems.AQUAMARINE_HOE.get()).add(GemistryItems.AMBER_SWORD.get()).add(GemistryItems.AMBER_SPEAR.get()).add(GemistryItems.AMBER_PICKAXE.get()).add(GemistryItems.AMBER_AXE.get()).add(GemistryItems.AMBER_SHOVEL.get()).add(GemistryItems.AMBER_HOE.get());

        tag(Tags.Items.ARMORS).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AMBER_HELMET.get()).add(GemistryItems.AMBER_CHESTPLATE.get()).add(GemistryItems.AMBER_LEGGINGS.get()).add(GemistryItems.AMBER_BOOTS.get());

        tag(Tags.Items.ARMORS_HUMANOID).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.SAPPHIRE_HELMET.get()).add(GemistryItems.SAPPHIRE_CHESTPLATE.get()).add(GemistryItems.SAPPHIRE_LEGGINGS.get()).add(GemistryItems.SAPPHIRE_BOOTS.get()).add(GemistryItems.AQUAMARINE_HELMET.get()).add(GemistryItems.AQUAMARINE_CHESTPLATE.get()).add(GemistryItems.AQUAMARINE_LEGGINGS.get()).add(GemistryItems.AQUAMARINE_BOOTS.get()).add(GemistryItems.AMBER_HELMET.get()).add(GemistryItems.AMBER_CHESTPLATE.get()).add(GemistryItems.AMBER_LEGGINGS.get()).add(GemistryItems.AMBER_BOOTS.get());

        tag(Tags.Items.ARMORS_HORSE).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.SAPPHIRE_HORSE_ARMOR.get()).add(GemistryItems.AQUAMARINE_HORSE_ARMOR.get()).add(GemistryItems.AMBER_HORSE_ARMOR.get());

        tag(Tags.Items.ARMORS_NAUTILUS).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get()).add(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get()).add(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get()).add(GemistryItems.AMBER_NAUTILUS_ARMOR.get());
    }

    private void addCustomTags() {
        tag(GemistryTags.REPAIRS_RUBY_ARMOR).add(GemistryItems.RUBY.get());
        tag(GemistryTags.RUBY_TOOL_MATERIALS).add(GemistryItems.RUBY.get());

        tag(GemistryTags.REPAIRS_SAPPHIRE_ARMOR).add(GemistryItems.SAPPHIRE.get());
        tag(GemistryTags.SAPPHIRE_TOOL_MATERIALS).add(GemistryItems.SAPPHIRE.get());

        tag(GemistryTags.REPAIRS_AQUAMARINE_ARMOR).add(GemistryItems.AQUAMARINE.get());
        tag(GemistryTags.AQUAMARINE_TOOL_MATERIALS).add(GemistryItems.AQUAMARINE.get());

        tag(GemistryTags.REPAIRS_AMBER_ARMOR).add(GemistryItems.AMBER.get());
        tag(GemistryTags.AMBER_TOOL_MATERIALS).add(GemistryItems.AMBER.get());
    }
}