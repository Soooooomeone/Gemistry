package com.danako.gemistry.common.block.entity;

import com.danako.gemistry.common.menu.AttunementTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class AttunementTableBlockEntity extends BlockEntity implements MenuProvider {

    private static final RandomSource RANDOM = RandomSource.create();

    private static final double ACTIVATION_RANGE = 3.0D;

    public int time;

    public float rot;
    public float oRot;
    public float open;
    public float oOpen;
    public float flip;
    public float oFlip;
    private float tRot;
    private float flipT;
    private float flipA;

    public AttunementTableBlockEntity(BlockPos pos, BlockState state) {
        super(GemistryBlockEntities.ATTUNEMENT_TABLE.get(), pos, state);
    }

    public static void bookAnimationTick(Level level, BlockPos pos, BlockState state, AttunementTableBlockEntity be) {
        be.oOpen = be.open;
        be.oRot = be.rot;

        Player player = level.getNearestPlayer(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, ACTIVATION_RANGE, false);

        if (player != null) {
            double dx = player.getX() - (pos.getX() + 0.5D);
            double dz = player.getZ() - (pos.getZ() + 0.5D);
            be.tRot = (float) Mth.atan2(dz, dx);
            be.open += 0.1F;

            if (be.open < 0.5F || RANDOM.nextInt(40) == 0) {
                float previous = be.flipT;
                do {
                    be.flipT += (float) (RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while (previous == be.flipT);
            }
        } else {
            be.tRot += 0.02F;
            be.open -= 0.1F;
        }
        be.rot = normalizeAngle(be.rot);
        be.tRot = normalizeAngle(be.tRot);
        float delta = normalizeAngle(be.tRot - be.rot);
        be.rot += delta * 0.4F;

        be.open = Mth.clamp(be.open, 0.0F, 1.0F);
        ++be.time;

        be.oFlip = be.flip;
        float flipDelta = Mth.clamp((be.flipT - be.flip) * 0.4F, -0.2F, 0.2F);
        be.flipA += (flipDelta - be.flipA) * 0.9F;
        be.flip += be.flipA;
    }

    private static float normalizeAngle(float angle) {
        while (angle >= (float) Math.PI) {
            angle -= ((float) Math.PI * 2F);
        }
        while (angle < -(float) Math.PI) {
            angle += ((float) Math.PI * 2F);
        }
        return angle;
    }

    public float getFlip(float partialTick) {
        return Mth.lerp(partialTick, this.oFlip, this.flip);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(this.getBlockState().getBlock().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new AttunementTableMenu(containerId, inventory, ContainerLevelAccess.create(this.level, this.worldPosition));
    }
}