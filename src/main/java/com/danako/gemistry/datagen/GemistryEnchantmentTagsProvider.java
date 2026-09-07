package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryEnchantments;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class GemistryEnchantmentTagsProvider extends EnchantmentTagsProvider {

    public GemistryEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(EnchantmentTags.ARMOR_EXCLUSIVE).add(GemistryEnchantments.FROST_PROTECTION);

        tag(EnchantmentTags.DAMAGE_EXCLUSIVE).add(GemistryEnchantments.ILLAGERS_BANE, GemistryEnchantments.SWINES_BANE);
    }
}