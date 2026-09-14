package com.danako.gemistry.core.enchantment;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.*;

@EventBusSubscriber(modid = Gemistry.MODID)
public class SoulboundEnchantmentHandler {

    private static final Map<UUID, List<ItemStack>> PENDING_SOULBOUND_ITEMS = new HashMap<>();

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        List<ItemStack> saved = new ArrayList<>();
        event.getDrops().removeIf(itemEntity -> {
            ItemStack stack = itemEntity.getItem();
            if (isSoulbound(player, stack)) {
                saved.add(stack.copy());
                return true;
            }
            return false;
        });

        if (saved.isEmpty()) {
            return;
        }

        for (ItemStack stack : saved) {
            player.getInventory().add(stack.copy());
        }

        PENDING_SOULBOUND_ITEMS.put(player.getUUID(), saved);
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            return;
        }

        List<ItemStack> saved = PENDING_SOULBOUND_ITEMS.remove(event.getOriginal().getUUID());
        if (saved == null || saved.isEmpty()) {
            return;
        }

        Player newPlayer = event.getEntity();
        for (ItemStack stack : saved) {
            if (!newPlayer.getInventory().add(stack)) {
                newPlayer.drop(stack, false);
            }
        }
    }

    private static boolean isSoulbound(Player player, ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        Holder<Enchantment> soulbound = player.level().registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(GemistryEnchantments.SOULBOUND);

        return EnchantmentHelper.getItemEnchantmentLevel(soulbound, stack) > 0;
    }
}