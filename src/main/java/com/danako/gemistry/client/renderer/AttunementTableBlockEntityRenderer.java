package com.danako.gemistry.client.renderer;

import com.danako.gemistry.common.block.entity.AttunementTableBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.object.book.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.blockentity.state.EnchantTableRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class AttunementTableBlockEntityRenderer
        implements BlockEntityRenderer<AttunementTableBlockEntity, EnchantTableRenderState> {

    private static final SpriteId BOOK_TEXTURE =
            Sheets.BLOCK_ENTITIES_MAPPER.apply(Identifier.fromNamespaceAndPath("gemistry", "attunement/attunement_table_book"));

    private final SpriteGetter sprites;
    private final BookModel bookModel;

    public AttunementTableBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.sprites = context.sprites();
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public EnchantTableRenderState createRenderState() {
        return new EnchantTableRenderState();
    }

    @Override
    public void extractRenderState(AttunementTableBlockEntity blockEntity, EnchantTableRenderState state,
                                   float partialTick, Vec3 cameraPosition,
                                   ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderState.extractBase(blockEntity, state, crumblingOverlay);

        state.time = blockEntity.time + partialTick;
        state.yRot = -Mth.lerp(partialTick, blockEntity.oRot, blockEntity.rot) * (180.0F / (float) Math.PI);
        state.flip = Mth.lerp(partialTick, blockEntity.oFlip, blockEntity.flip);
        state.open = Mth.lerp(partialTick, blockEntity.oOpen, blockEntity.open);
    }

    @Override
    public void submit(EnchantTableRenderState state, PoseStack poseStack,
                       SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();

        poseStack.translate(0.5F, 0.75F, 0.5F);
        poseStack.translate(0.0F, 0.1F + Mth.sin(state.time * 0.1F) * 0.01F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot));
        poseStack.mulPose(Axis.ZP.rotationDegrees(80.0F));

        float pageFlip1 = state.flip + 0.25F;
        pageFlip1 = (pageFlip1 - Mth.floor(pageFlip1)) * 1.6F - 0.3F;
        pageFlip1 = Mth.clamp(pageFlip1, 0.0F, 1.0F);

        float pageFlip2 = state.flip + 0.75F;
        pageFlip2 = (pageFlip2 - Mth.floor(pageFlip2)) * 1.6F - 0.3F;
        pageFlip2 = Mth.clamp(pageFlip2, 0.0F, 1.0F);

        BookModel.State bookState = BookModel.State.forAnimation(state.time, pageFlip1, pageFlip2, state.open);

        collector.submitModel(
                this.bookModel,
                bookState,
                poseStack,
                state.lightCoords,
                OverlayTexture.NO_OVERLAY,
                -1,
                BOOK_TEXTURE,
                this.sprites,
                0,
                state.breakProgress
        );

        poseStack.popPose();
    }
}