package com.danako.gemistry.tag;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.concurrent.CompletableFuture;

public class GemistryEnchantmentTagsProvider extends EnchantmentTagsProvider {

    public GemistryEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Gemistry.MODID);
    }

    private static TagKey<Enchantment> attunementTag(String path) {
        return TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Gemistry.MODID, "attunement/" + path));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addAttunementCommonTag();
        addAttunementThemeTags();
    }

    private void addAttunementCommonTag() {
        tag(attunementTag("common"))
                .add(
                        Enchantments.PROTECTION,
                        Enchantments.FIRE_PROTECTION,
                        Enchantments.FEATHER_FALLING,
                        Enchantments.BLAST_PROTECTION,
                        Enchantments.PROJECTILE_PROTECTION,
                        Enchantments.RESPIRATION,
                        Enchantments.AQUA_AFFINITY,
                        Enchantments.THORNS,
                        Enchantments.DEPTH_STRIDER,
                        Enchantments.SHARPNESS,
                        Enchantments.SMITE,
                        Enchantments.BANE_OF_ARTHROPODS,
                        Enchantments.KNOCKBACK,
                        Enchantments.FIRE_ASPECT,
                        Enchantments.LOOTING,
                        Enchantments.SWEEPING_EDGE,
                        Enchantments.EFFICIENCY,
                        Enchantments.SILK_TOUCH,
                        Enchantments.UNBREAKING,
                        Enchantments.FORTUNE,
                        Enchantments.POWER,
                        Enchantments.PUNCH,
                        Enchantments.FLAME,
                        Enchantments.INFINITY,
                        Enchantments.LUCK_OF_THE_SEA,
                        Enchantments.LURE,
                        Enchantments.LOYALTY,
                        Enchantments.IMPALING,
                        Enchantments.RIPTIDE,
                        Enchantments.CHANNELING,
                        Enchantments.MULTISHOT,
                        Enchantments.QUICK_CHARGE,
                        Enchantments.PIERCING,
                        Enchantments.DENSITY,
                        Enchantments.BREACH,
                        Enchantments.LUNGE
                );
    }

    private void addAttunementThemeTags() {
        tag(attunementTag("pyric")).add(Enchantments.FIRE_ASPECT)
                .add(Enchantments.FIRE_PROTECTION).add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.EFFICIENCY)
                .add(Enchantments.SMITE)
                .add(Enchantments.FLAME)
                .add(Enchantments.PIERCING).add(Enchantments.MULTISHOT).add(Enchantments.QUICK_CHARGE
                );

        tag(attunementTag("boreal"))
                .add(Enchantments.FEATHER_FALLING)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.FROST_WALKER)
                .add(Enchantments.KNOCKBACK).add(Enchantments.PUNCH)
                .add(Enchantments.BANE_OF_ARTHROPODS
        );

        tag(attunementTag("abyssal"))
                .add(Enchantments.AQUA_AFFINITY)
                .add(Enchantments.RIPTIDE).add(Enchantments.IMPALING).add(Enchantments.LOYALTY)
                .add(Enchantments.DEPTH_STRIDER).add(Enchantments.RESPIRATION)
                .add(Enchantments.LURE).add(Enchantments.LUCK_OF_THE_SEA
        );

        tag(attunementTag("miasmic"))
                .add(Enchantments.INFINITY)
                .add(Enchantments.SILK_TOUCH)
                .add(Enchantments.LOOTING)
                .add(Enchantments.SOUL_SPEED)
                .add(Enchantments.BINDING_CURSE)
                .add(Enchantments.VANISHING_CURSE)
                .add(Enchantments.FORTUNE
        );

        tag(attunementTag("umbral"))
                .add(Enchantments.THORNS)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.PROTECTION)
                .add(Enchantments.POWER)
                .add(Enchantments.UNBREAKING
        );
    }
}