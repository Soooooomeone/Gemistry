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
        addAttunementElementTags();
    }

    private void addAttunementElementTags() {
        tag(attunementTag("abyssal"))
                // Aquamarine themed
                .add(Enchantments.RESPIRATION)
                .add(Enchantments.AQUA_AFFINITY)
                .add(Enchantments.DEPTH_STRIDER)
                .add(Enchantments.LUCK_OF_THE_SEA)
                .add(Enchantments.LURE)
                .add(Enchantments.LOYALTY)
                .add(Enchantments.IMPALING)
                .add(Enchantments.RIPTIDE)
                // Common
                .add(Enchantments.PROTECTION)
                .add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.KNOCKBACK)
                .add(Enchantments.SWEEPING_EDGE)
                .add(Enchantments.EFFICIENCY)
                .add(Enchantments.SILK_TOUCH)
                .add(Enchantments.UNBREAKING)
                .add(Enchantments.MENDING)
                .add(Enchantments.SWIFT_SNEAK)
                .add(Enchantments.POWER)
                .add(Enchantments.PUNCH)
                .add(Enchantments.INFINITY)
                .add(Enchantments.MULTISHOT)
                .add(Enchantments.QUICK_CHARGE)
                .add(Enchantments.PIERCING)
                .add(Enchantments.DENSITY)
                .add(Enchantments.BREACH)
                .add(Enchantments.WIND_BURST)
                .add(Enchantments.LUNGE)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.LOOTING);

        tag(attunementTag("boreal"))
                // Sapphire themed
                .add(Enchantments.FROST_WALKER)
                .add(Enchantments.FEATHER_FALLING)
                // Common
                .add(Enchantments.PROTECTION)
                .add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.KNOCKBACK)
                .add(Enchantments.SWEEPING_EDGE)
                .add(Enchantments.EFFICIENCY)
                .add(Enchantments.SILK_TOUCH)
                .add(Enchantments.UNBREAKING)
                .add(Enchantments.MENDING)
                .add(Enchantments.SWIFT_SNEAK)
                .add(Enchantments.POWER)
                .add(Enchantments.PUNCH)
                .add(Enchantments.INFINITY)
                .add(Enchantments.MULTISHOT)
                .add(Enchantments.QUICK_CHARGE)
                .add(Enchantments.PIERCING)
                .add(Enchantments.DENSITY)
                .add(Enchantments.BREACH)
                .add(Enchantments.WIND_BURST)
                .add(Enchantments.LUNGE)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.LOOTING);

        tag(attunementTag("miasmic"))
                // Amber themed
                .add(Enchantments.BINDING_CURSE)
                .add(Enchantments.VANISHING_CURSE)
                .add(Enchantments.THORNS)
                .add(Enchantments.SOUL_SPEED)
                .add(Enchantments.CHANNELING)
                .add(Enchantments.BANE_OF_ARTHROPODS)
                // Common
                .add(Enchantments.PROTECTION)
                .add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.KNOCKBACK)
                .add(Enchantments.SWEEPING_EDGE)
                .add(Enchantments.EFFICIENCY)
                .add(Enchantments.SILK_TOUCH)
                .add(Enchantments.UNBREAKING)
                .add(Enchantments.MENDING)
                .add(Enchantments.SWIFT_SNEAK)
                .add(Enchantments.POWER)
                .add(Enchantments.PUNCH)
                .add(Enchantments.INFINITY)
                .add(Enchantments.MULTISHOT)
                .add(Enchantments.QUICK_CHARGE)
                .add(Enchantments.PIERCING)
                .add(Enchantments.DENSITY)
                .add(Enchantments.BREACH)
                .add(Enchantments.WIND_BURST)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.LOOTING)
                .add(Enchantments.LUNGE);

        tag(attunementTag("pyric"))
                // Ruby themed
                .add(Enchantments.FIRE_ASPECT)
                .add(Enchantments.FLAME)
                .add(Enchantments.FIRE_PROTECTION)
                .add(Enchantments.SMITE)
                // Common
                .add(Enchantments.PROTECTION)
                .add(Enchantments.BLAST_PROTECTION)
                .add(Enchantments.PROJECTILE_PROTECTION)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.KNOCKBACK)
                .add(Enchantments.SWEEPING_EDGE)
                .add(Enchantments.EFFICIENCY)
                .add(Enchantments.SILK_TOUCH)
                .add(Enchantments.UNBREAKING)
                .add(Enchantments.MENDING)
                .add(Enchantments.SWIFT_SNEAK)
                .add(Enchantments.POWER)
                .add(Enchantments.PUNCH)
                .add(Enchantments.INFINITY)
                .add(Enchantments.MULTISHOT)
                .add(Enchantments.QUICK_CHARGE)
                .add(Enchantments.PIERCING)
                .add(Enchantments.DENSITY)
                .add(Enchantments.BREACH)
                .add(Enchantments.WIND_BURST)
                .add(Enchantments.LUNGE)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.LOOTING);
    }
}