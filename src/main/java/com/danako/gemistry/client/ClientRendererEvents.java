package com.danako.gemistry.client;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.client.renderer.AttunementTableBlockEntityRenderer;
import com.danako.gemistry.common.block.entity.GemistryBlockEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Gemistry.MODID, value = Dist.CLIENT)
public class ClientRendererEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(GemistryBlockEntities.ATTUNEMENT_TABLE.get(), AttunementTableBlockEntityRenderer::new);
    }
}