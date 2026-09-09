package com.danako.gemistry.client;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.client.renderer.AttunementTableBlockEntityRenderer;
import com.danako.gemistry.client.screen.AttunementTableScreen;
import com.danako.gemistry.common.block.entity.GemistryBlockEntities;
import com.danako.gemistry.common.menu.GemistryMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Gemistry.MODID, value = Dist.CLIENT)
public class GemistryClientEvents {

    @SubscribeEvent
    public static void registerGemistryRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(GemistryBlockEntities.ATTUNEMENT_TABLE.get(), AttunementTableBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerGemistryScreens(RegisterMenuScreensEvent event) {
        event.register(GemistryMenuTypes.ATTUNEMENT_TABLE.get(), AttunementTableScreen::new);
    }
}