package com.danako.gemistry;

import com.danako.gemistry.common.block.GemistryBlocks;
import com.danako.gemistry.common.block.entity.GemistryBlockEntities;
import com.danako.gemistry.common.menu.GemistryMenuTypes;
import com.danako.gemistry.config.GemistryConfig;
import com.danako.gemistry.common.item.GemistryItems;
import com.danako.gemistry.core.enchantment.GemistryEntityEffects;
import com.danako.gemistry.core.enchantment.GemistryFreezeTracker;
import com.danako.gemistry.core.creative_tab.GemistryTabs;
import com.danako.gemistry.datagen.DataGenerators;
import com.danako.gemistry.core.loot.GemistryLootModifierSerializers;
import com.danako.gemistry.core.worldgen.GemistryBiomeModifierSerializers;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(Gemistry.MODID)
public class Gemistry {
    public static final String MODID = "gemistry";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Gemistry(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        GemistryBlocks.BLOCKS.register(modEventBus);
        GemistryItems.ITEMS.register(modEventBus);
        GemistryTabs.CREATIVE_MODE_TABS.register(modEventBus);
        GemistryLootModifierSerializers.register(modEventBus);
        GemistryBiomeModifierSerializers.register(modEventBus);
        GemistryBlockEntities.register(modEventBus);
        DataGenerators.register(modEventBus);
        GemistryMenuTypes.MENU_TYPES.register(modEventBus);
        GemistryEntityEffects.register(modEventBus);
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.register(GemistryFreezeTracker.class);
        modContainer.registerConfig(ModConfig.Type.COMMON, GemistryConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Gemistry common setup complete");
    }
}