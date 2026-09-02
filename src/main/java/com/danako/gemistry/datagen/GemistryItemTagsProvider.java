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

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addEnchantableTags();
        addNeoForgeConventionTags();
        addCustomTags();
        addVanillaTags();
    }

    private void addEnchantableTags() {

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get());

        tag(ItemTags.MINING_ENCHANTABLE).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get());

        tag(ItemTags.SWEEPING_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get());
        tag(ItemTags.LUNGE_ENCHANTABLE).add(GemistryItems.RUBY_SPEAR.get());

        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get());

        // FIX: vanilla grants Sharpness to swords AND axes. Sword was missing here.
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_AXE.get());

        // NEW: parent tag collecting all melee/ranged weapon enchant pools together.
        tag(ItemTags.WEAPON_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_HELMET.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(GemistryItems.RUBY_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get());

        tag(ItemTags.VANISHING_ENCHANTABLE).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get()).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get()).add(GemistryItems.RUBY_HORSE_ARMOR.get()).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get());
    }

    private void addVanillaTags() {
        tag(ItemTags.SWORDS).add(GemistryItems.RUBY_SWORD.get());
        tag(ItemTags.AXES).add(GemistryItems.RUBY_AXE.get());
        tag(ItemTags.PICKAXES).add(GemistryItems.RUBY_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(GemistryItems.RUBY_SHOVEL.get());
        tag(ItemTags.HOES).add(GemistryItems.RUBY_HOE.get());
        tag(ItemTags.SPEARS).add(GemistryItems.RUBY_SPEAR.get());
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(GemistryItems.RUBY.get());
    }

    private void addNeoForgeConventionTags() {
        tag(commonTag("gems/ruby")).add(GemistryItems.RUBY.get());
        tag(commonTag("storage_blocks/ruby")).add(GemistryItems.RUBY_BLOCK.get());

        tag(commonTag("tools/mining_tool")).add(GemistryItems.RUBY_PICKAXE.get());
        tag(commonTag("tools/melee_weapon")).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SPEAR.get());

        tag(Tags.Items.TOOLS).add(GemistryItems.RUBY_SWORD.get()).add(GemistryItems.RUBY_SPEAR.get()).add(GemistryItems.RUBY_PICKAXE.get()).add(GemistryItems.RUBY_AXE.get()).add(GemistryItems.RUBY_SHOVEL.get()).add(GemistryItems.RUBY_HOE.get());

        tag(Tags.Items.ARMORS).add(GemistryItems.RUBY_HELMET.get()).add(GemistryItems.RUBY_CHESTPLATE.get()).add(GemistryItems.RUBY_LEGGINGS.get()).add(GemistryItems.RUBY_BOOTS.get());
        tag(Tags.Items.ARMORS_HUMANOID).add(GemistryItems.RUBY_HELMET.get());
        tag(Tags.Items.ARMORS_HUMANOID).add(GemistryItems.RUBY_CHESTPLATE.get());
        tag(Tags.Items.ARMORS_HUMANOID).add(GemistryItems.RUBY_LEGGINGS.get());
        tag(Tags.Items.ARMORS_HUMANOID).add(GemistryItems.RUBY_BOOTS.get());
        tag(Tags.Items.ARMORS_HORSE).add(GemistryItems.RUBY_HORSE_ARMOR.get());
        tag(Tags.Items.ARMORS_NAUTILUS).add(GemistryItems.RUBY_NAUTILUS_ARMOR.get());
    }

    private void addCustomTags() {
        tag(GemistryTags.REPAIRS_RUBY_ARMOR).add(GemistryItems.RUBY.get());
        tag(GemistryTags.RUBY_TOOL_MATERIALS).add(GemistryItems.RUBY.get());
    }

    private static TagKey<Item> commonTag(String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
    }
}