package com.danako.gemistry.enchantment;

import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class GemistryFreezeTracker {
    private static final ConcurrentHashMap<Integer, Integer> CHILLED = new ConcurrentHashMap<>();

    public static void chill(Entity entity, int ticks) {
        CHILLED.merge(entity.getId(), ticks, Math::max);
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (entity.level().isClientSide() || !(entity instanceof LivingEntity)) {
            return;
        }

        if (entity.isRemoved()) {
            CHILLED.remove(entity.getId());
            return;
        }

        Integer remaining = CHILLED.get(entity.getId());
        if (remaining != null) {
            entity.setIsInPowderSnow(true);
            if (remaining <= 1) {
                CHILLED.remove(entity.getId());
            } else {
                CHILLED.put(entity.getId(), remaining - 1);
            }
        }
    }
}