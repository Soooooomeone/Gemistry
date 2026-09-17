package com.danako.gemistry.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LapidaryBenchBlockEntity extends BlockEntity {

    public LapidaryBenchBlockEntity(BlockPos pos, BlockState state) {
        super(GemistryBlockEntities.LAPIDARY_BENCH.get(), pos, state);
    }
}