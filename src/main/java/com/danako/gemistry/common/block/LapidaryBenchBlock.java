package com.danako.gemistry.common.block;

import com.danako.gemistry.common.block.entity.LapidaryBenchBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LapidaryBenchBlock extends BaseEntityBlock {
    public static final MapCodec<LapidaryBenchBlock> CODEC = simpleCodec(LapidaryBenchBlock::new);

    private static final VoxelShape TOP = Block.box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape LEG_NORTH_WEST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 4.0D, 3.0D);
    private static final VoxelShape LEG_NORTH_EAST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 4.0D, 3.0D);
    private static final VoxelShape LEG_SOUTH_EAST = Block.box(13.0D, 0.0D, 13.0D, 16.0D, 4.0D, 16.0D);
    private static final VoxelShape LEG_SOUTH_WEST = Block.box(0.0D, 0.0D, 13.0D, 3.0D, 4.0D, 16.0D);
    private static final VoxelShape SHAPE = Shapes.or(TOP, LEG_NORTH_WEST, LEG_NORTH_EAST, LEG_SOUTH_EAST, LEG_SOUTH_WEST);

    public LapidaryBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends LapidaryBenchBlock> codec() {
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
        return new LapidaryBenchBlockEntity(pos, state);
    }
}