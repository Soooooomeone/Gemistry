package com.danako.gemistry;

import com.danako.gemistry.config.Config;
import com.danako.gemistry.core.GemistryBlocks;
import com.danako.gemistry.core.GemistryItems;
import com.danako.gemistry.core.GemistryTabs;
import com.danako.gemistry.datagen.DataGenerators;
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

        DataGenerators.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Gemistry common setup complete");
    }
}