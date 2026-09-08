package com.danako.gemistry.tag;

import com.danako.gemistry.core.GemistryEnchantments;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.concurrent.CompletableFuture;

public class GemistryEnchantmentTagsProvider extends EnchantmentTagsProvider {

    public GemistryEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.Provider registries) {
        this.tooltipOrder(registries, Enchantments.BINDING_CURSE, Enchantments.VANISHING_CURSE, Enchantments.RIPTIDE, Enchantments.CHANNELING, Enchantments.WIND_BURST, Enchantments.FROST_WALKER, Enchantments.LUNGE, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, GemistryEnchantments.ILLAGERS_BANE, GemistryEnchantments.SWINES_BANE, Enchantments.IMPALING, Enchantments.POWER, Enchantments.DENSITY, Enchantments.BREACH, Enchantments.PIERCING, Enchantments.SWEEPING_EDGE, Enchantments.MULTISHOT, Enchantments.FIRE_ASPECT, GemistryEnchantments.FROST_ASPECT, GemistryEnchantments.VENOM_ASPECT, Enchantments.FLAME, Enchantments.KNOCKBACK, Enchantments.PUNCH, Enchantments.PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION, GemistryEnchantments.FROST_PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.FEATHER_FALLING, Enchantments.FORTUNE, GemistryEnchantments.PROSPERITY, GemistryEnchantments.EXCAVATION, Enchantments.LOOTING, GemistryEnchantments.LEECHING, GemistryEnchantments.INSIGHT, Enchantments.SILK_TOUCH, GemistryEnchantments.REFINING_TOUCH, Enchantments.LUCK_OF_THE_SEA, Enchantments.EFFICIENCY, Enchantments.QUICK_CHARGE, Enchantments.LURE, Enchantments.RESPIRATION, Enchantments.AQUA_AFFINITY, GemistryEnchantments.PURIFICATION, Enchantments.SOUL_SPEED, Enchantments.SWIFT_SNEAK, Enchantments.DEPTH_STRIDER, Enchantments.THORNS, GemistryEnchantments.VITALITY, Enchantments.LOYALTY, Enchantments.UNBREAKING, Enchantments.INFINITY, GemistryEnchantments.SOULBOUND, Enchantments.MENDING);

        this.tag(EnchantmentTags.ARMOR_EXCLUSIVE).add(GemistryEnchantments.FROST_PROTECTION);

        this.tag(EnchantmentTags.DAMAGE_EXCLUSIVE).add(GemistryEnchantments.ILLAGERS_BANE, GemistryEnchantments.SWINES_BANE);

        this.tag(EnchantmentTags.NON_TREASURE).add(GemistryEnchantments.FROST_PROTECTION, GemistryEnchantments.FROST_ASPECT, GemistryEnchantments.ILLAGERS_BANE, GemistryEnchantments.VENOM_ASPECT, GemistryEnchantments.PURIFICATION, GemistryEnchantments.LEECHING, GemistryEnchantments.VITALITY, GemistryEnchantments.INSIGHT, GemistryEnchantments.PROSPERITY, GemistryEnchantments.SWINES_BANE, GemistryEnchantments.REFINING_TOUCH, GemistryEnchantments.EXCAVATION);

        this.tag(EnchantmentTags.MINING_EXCLUSIVE).add(GemistryEnchantments.REFINING_TOUCH);

        this.tag(EnchantmentTags.TREASURE).add(GemistryEnchantments.SOULBOUND);
        this.tag(EnchantmentTags.ON_RANDOM_LOOT).add(GemistryEnchantments.SOULBOUND);
        this.tag(EnchantmentTags.TRADEABLE).add(GemistryEnchantments.SOULBOUND);
    }
}