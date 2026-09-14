package com.danako.gemistry.core.tag;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;

import java.util.concurrent.CompletableFuture;

public class GemistryMobEffectTagsProvider extends KeyTagProvider<MobEffect> {

    public GemistryMobEffectTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.MOB_EFFECT, lookupProvider, Gemistry.MODID);
    }

    private static ResourceKey<MobEffect> vanilla(String name) {
        return ResourceKey.create(Registries.MOB_EFFECT, Identifier.withDefaultNamespace(name));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addPurifiableEffectsTag();
    }

    private void addPurifiableEffectsTag() {
        tag(GemistryTags.PURIFIABLE_EFFECTS)
                .add(vanilla("poison"))
                .add(vanilla("wither"))
                .add(vanilla("weakness"))
                .add(vanilla("slowness"))
                .add(vanilla("mining_fatigue"))
                .add(vanilla("nausea"))
                .add(vanilla("blindness"))
                .add(vanilla("hunger"))
                .add(vanilla("unluck"))
                .add(vanilla("darkness"));
    }
}