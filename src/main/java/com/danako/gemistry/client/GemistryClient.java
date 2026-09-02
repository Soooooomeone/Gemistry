package com.danako.gemistry.client;

import com.danako.gemistry.Gemistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Gemistry.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Gemistry.MODID, value = Dist.CLIENT)
public class GemistryClient {
    public GemistryClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
