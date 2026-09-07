package com.danako.gemistry.common.block;

import com.danako.gemistry.common.block.entity.AttunementTableBlockEntity;
import com.danako.gemistry.common.block.entity.GemistryBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class AttunementTableBlock extends BaseEntityBlock {
    public static final MapCodec<AttunementTableBlock> CODEC = simpleCodec(AttunementTableBlock::new);

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public AttunementTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends AttunementTableBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AttunementTableBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? createTickerHelper(type, GemistryBlockEntities.ATTUNEMENT_TABLE.get(), AttunementTableBlockEntity::bookAnimationTick) : null;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        BlockEntity be = level.getBlockEntity(pos);
        boolean active = be instanceof AttunementTableBlockEntity table && table.open > 0.1F;

        int chanceDenominator = active ? 4 : 16;
        if (random.nextInt(chanceDenominator) == 0) {
            double x = pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.8D;
            double y = pos.getY() + 0.9D;
            double z = pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.8D;
            level.addParticle(ParticleTypes.ENCHANT, x, y, z, (random.nextDouble() - 0.5D) * 0.3D, -random.nextDouble() * 0.4D, (random.nextDouble() - 0.5D) * 0.3D);
        }
    }
}