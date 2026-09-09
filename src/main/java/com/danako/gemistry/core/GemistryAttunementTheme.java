package com.danako.gemistry.core;

import com.danako.gemistry.tag.GemistryTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public enum GemistryAttunementTheme {
    PYRIC(GemistryTags.ATTUNEMENT_CATALYSTS_RUBY, GemistryTags.ATTUNEMENT_PYRIC), BOREAL(GemistryTags.ATTUNEMENT_CATALYSTS_SAPPHIRE, GemistryTags.ATTUNEMENT_BOREAL), ABYSSAL(GemistryTags.ATTUNEMENT_CATALYSTS_AQUAMARINE, GemistryTags.ATTUNEMENT_ABYSSAL), MIASMIC(GemistryTags.ATTUNEMENT_CATALYSTS_AMBER, GemistryTags.ATTUNEMENT_MIASMIC), UMBRAL(GemistryTags.ATTUNEMENT_CATALYSTS_ONYX, GemistryTags.ATTUNEMENT_UMBRAL);

    private final TagKey<Item> catalystTag;
    private final TagKey<Enchantment> themeTag;

    GemistryAttunementTheme(TagKey<Item> catalystTag, TagKey<Enchantment> themeTag) {
        this.catalystTag = catalystTag;
        this.themeTag = themeTag;
    }

    public TagKey<Item> catalystTag() {
        return this.catalystTag;
    }

    public TagKey<Enchantment> themeTag() {
        return this.themeTag;
    }
}