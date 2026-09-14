package com.danako.gemistry.core.enchantment;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

@EventBusSubscriber(modid = Gemistry.MODID)
public class InsightEnchantmentHandler {

    private static final LevelBasedValue MOB_XP_BONUS_PER_LEVEL = LevelBasedValue.perLevel(0.25F);
    private static final LevelBasedValue BLOCK_XP_BONUS_PER_LEVEL = LevelBasedValue.perLevel(0.25F);

    @SubscribeEvent
    public static void onMobExperienceDrop(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if (player == null) {
            return;
        }

        if (!(player.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        int insightLevel = getInsightLevel(serverLevel, player.getMainHandItem());
        if (insightLevel <= 0) {
            return;
        }

        float multiplier = 1.0F + MOB_XP_BONUS_PER_LEVEL.calculate(insightLevel);
        int buffed = Math.round(event.getDroppedExperience() * multiplier);
        event.setDroppedExperience(buffed);
    }


    @SubscribeEvent
    public static void onBlockBreakExperience(BlockDropsEvent event) {
        if (event.getDroppedExperience() <= 0) {
            return;
        }

        Entity breaker = event.getBreaker();
        if (!(breaker instanceof Player player)) {
            return;
        }

        ServerLevel serverLevel = event.getLevel();

        ItemStack tool = event.getTool();
        int insightLevel = getInsightLevel(serverLevel, tool);
        if (insightLevel <= 0) {
            return;
        }

        float multiplier = 1.0F + BLOCK_XP_BONUS_PER_LEVEL.calculate(insightLevel);
        int buffed = Math.round(event.getDroppedExperience() * multiplier);
        event.setDroppedExperience(buffed);
    }

    private static int getInsightLevel(ServerLevel level, ItemStack stack) {
        Holder<Enchantment> insight = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(GemistryEnchantments.INSIGHT);
        return EnchantmentHelper.getItemEnchantmentLevel(insight, stack);
    }
}