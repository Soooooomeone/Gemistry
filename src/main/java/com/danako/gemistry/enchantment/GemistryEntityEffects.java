package com.danako.gemistry.enchantment;

import com.danako.gemistry.Gemistry;
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
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GemistryEntityEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Gemistry.MODID);

    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<IncreaseFreezeTicks>> INCREASE_FREEZE_TICKS =
            ENTITY_EFFECTS.register("increase_freeze_ticks", () -> IncreaseFreezeTicks.CODEC);

    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<ApplyMobEffectScaled>> APPLY_MOB_EFFECT_SCALED =
            ENTITY_EFFECTS.register("apply_mob_effect_scaled", () -> ApplyMobEffectScaled.CODEC);

    public static void register(IEventBus modBus) {
        ENTITY_EFFECTS.register(modBus);
    }

    public record IncreaseFreezeTicks(LevelBasedValue ticks) implements EnchantmentEntityEffect {
        public static final MapCodec<IncreaseFreezeTicks> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                LevelBasedValue.CODEC.fieldOf("ticks").forGetter(IncreaseFreezeTicks::ticks)
        ).apply(i, IncreaseFreezeTicks::new));

        @Override
        public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse item, Entity target, Vec3 position) {
            int add = Math.round(this.ticks.calculate(enchantLevel));
            int capped = Math.min(target.getTicksFrozen() + add, target.getTicksRequiredToFreeze());
            target.setTicksFrozen(capped);
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
        public static final MapCodec<ApplyMobEffectScaled> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                MobEffect.CODEC.fieldOf("effect").forGetter(ApplyMobEffectScaled::effect),
                LevelBasedValue.CODEC.fieldOf("duration").forGetter(ApplyMobEffectScaled::duration),
                LevelBasedValue.CODEC.fieldOf("amplifier").forGetter(ApplyMobEffectScaled::amplifier)
        ).apply(i, ApplyMobEffectScaled::new));

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
}