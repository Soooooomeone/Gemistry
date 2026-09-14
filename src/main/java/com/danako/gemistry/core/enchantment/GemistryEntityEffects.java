package com.danako.gemistry.core.enchantment;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.core.tag.GemistryTags;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class GemistryEntityEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_EFFECTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Gemistry.MODID);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<IncreaseFreezeTicks>> INCREASE_FREEZE_TICKS = ENTITY_EFFECTS.register("increase_freeze_ticks", () -> IncreaseFreezeTicks.CODEC);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<ApplyMobEffectScaled>> APPLY_MOB_EFFECT_SCALED = ENTITY_EFFECTS.register("apply_mob_effect_scaled", () -> ApplyMobEffectScaled.CODEC);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<RegenerateHealth>> REGENERATE_HEALTH = ENTITY_EFFECTS.register("regenerate_health", () -> RegenerateHealth.CODEC);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<PurifyEffects>> PURIFY_EFFECTS = ENTITY_EFFECTS.register("purify_effects", () -> PurifyEffects.CODEC);
    @SuppressWarnings("unused")
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<LifestealEffect>> LIFESTEAL_EFFECT = ENTITY_EFFECTS.register("lifesteal_effect", () -> LifestealEffect.CODEC);

    public static void register(IEventBus modBus) {
        ENTITY_EFFECTS.register(modBus);
    }

    public record IncreaseFreezeTicks(LevelBasedValue ticks) implements EnchantmentEntityEffect {
        public static final MapCodec<IncreaseFreezeTicks> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(LevelBasedValue.CODEC.fieldOf("ticks").forGetter(IncreaseFreezeTicks::ticks)).apply(i, IncreaseFreezeTicks::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            int add = Math.round(this.ticks.calculate(enchantLevel));

            if (target instanceof LivingEntity living) {
                int protectionLevel = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).get(GemistryEnchantments.FROST_PROTECTION).map(holder -> EnchantmentHelper.getEnchantmentLevel(holder, living)).orElse(0);

                if (protectionLevel > 0) {
                    add = Math.round(add * Math.max(0.0F, 1.0F - 0.2F * protectionLevel));
                }
            }

            target.setTicksFrozen(target.getTicksFrozen() + add);
            if (target.canFreeze()) {
                GemistryFreezeTracker.chill(target, 30);
            }
        }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec() {
            return CODEC;
        }
    }

    public record ApplyMobEffectScaled(Holder<MobEffect> effect, LevelBasedValue duration,
                                       LevelBasedValue amplifier) implements EnchantmentEntityEffect {
        public static final MapCodec<ApplyMobEffectScaled> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(MobEffect.CODEC.fieldOf("effect").forGetter(ApplyMobEffectScaled::effect), LevelBasedValue.CODEC.fieldOf("duration").forGetter(ApplyMobEffectScaled::duration), LevelBasedValue.CODEC.fieldOf("amplifier").forGetter(ApplyMobEffectScaled::amplifier)).apply(i, ApplyMobEffectScaled::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            if (target instanceof LivingEntity living) {
                int durationTicks = Math.round(this.duration.calculate(enchantLevel));
                int amplifierLevel = Math.round(this.amplifier.calculate(enchantLevel));
                living.addEffect(new MobEffectInstance(this.effect, durationTicks, amplifierLevel));
            }
        }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec() {
            return CODEC;
        }
    }

    public record RegenerateHealth(LevelBasedValue amount) implements EnchantmentEntityEffect {
        public static final MapCodec<RegenerateHealth> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(LevelBasedValue.CODEC.fieldOf("amount").forGetter(RegenerateHealth::amount)).apply(i, RegenerateHealth::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            if (target instanceof LivingEntity living && living.isAlive() && living.getHealth() < living.getMaxHealth()) {
                living.heal(this.amount.calculate(enchantLevel));
            }
        }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec() {
            return CODEC;
        }
    }

    public record PurifyEffects(LevelBasedValue reductionPerTick) implements EnchantmentEntityEffect {
        public static final MapCodec<PurifyEffects> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(LevelBasedValue.CODEC.fieldOf("reduction_per_tick").forGetter(PurifyEffects::reductionPerTick)).apply(i, PurifyEffects::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            if (!(target instanceof LivingEntity living)) {
                return;
            }

            int reduction = Math.max(1, Math.round(this.reductionPerTick.calculate(enchantLevel)));

            for (MobEffectInstance instance : List.copyOf(living.getActiveEffects())) {
                if (instance.isInfiniteDuration() || !instance.getEffect().is(GemistryTags.PURIFIABLE_EFFECTS)) {
                    continue;
                }

                int newDuration = Math.max(0, instance.getDuration() - reduction);
                living.forceAddEffect(new MobEffectInstance(instance.getEffect(), newDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon()), null);
            }
        }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec() {
            return CODEC;
        }
    }

    public record LifestealEffect(LevelBasedValue amount, float maxHealPerHit) implements EnchantmentEntityEffect {
        public static final MapCodec<LifestealEffect> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(LevelBasedValue.CODEC.fieldOf("amount").forGetter(LifestealEffect::amount), com.mojang.serialization.Codec.FLOAT.fieldOf("max_heal_per_hit").forGetter(LifestealEffect::maxHealPerHit)).apply(i, LifestealEffect::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            if (target instanceof LivingEntity living && living.isAlive() && living.getHealth() < living.getMaxHealth()) {
                float heal = Math.min(this.amount.calculate(enchantLevel), this.maxHealPerHit);
                living.heal(heal);
            }
        }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec() {
            return CODEC;
        }
    }
}