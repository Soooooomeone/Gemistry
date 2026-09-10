package com.danako.gemistry.common.block;

import com.danako.gemistry.common.block.entity.AttunementTableBlockEntity;
import com.danako.gemistry.common.block.entity.GemistryBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class AttunementTableBlock extends BaseEntityBlock {
    public static final MapCodec<AttunementTableBlock> CODEC = simpleCodec(AttunementTableBlock::new);
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter((offset) -> Math.abs(offset.getX()) == 2 || Math.abs(offset.getZ()) == 2).map(BlockPos::immutable).toList();
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    private static final int LIGHT_LEVEL = 8;

    public AttunementTableBlock(Properties properties) {
        super(properties.lightLevel(state -> LIGHT_LEVEL));
    }

    public static boolean isValidBookShelf(Level level, BlockPos pos, BlockPos offset) {
        return level.getBlockState(pos.offset(offset)).getEnchantPowerBonus(level, pos.offset(offset)) != 0.0F && level.getBlockState(pos.offset(offset.getX() / 2, offset.getY(), offset.getZ() / 2)).is(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
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
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof AttunementTableBlockEntity table) {
            if (!level.isClientSide()) {
                player.openMenu(table);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        BlockEntity be = level.getBlockEntity(pos);
        boolean active = be instanceof AttunementTableBlockEntity table && table.open > 0.1F;

        for (BlockPos offset : BOOKSHELF_OFFSETS) {
            if (random.nextInt(16) == 0 && isValidBookShelf(level, pos, offset)) {
                level.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5D, pos.getY() + 2.0D, pos.getZ() + 0.5D, (offset.getX() + random.nextFloat()) - 0.5D, (offset.getY() - random.nextFloat() - 1.0D), (offset.getZ() + random.nextFloat()) - 0.5D);
            }
        }

        int chanceDenominator = active ? 4 : 16;
        if (random.nextInt(chanceDenominator) == 0) {
            double x = pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.8D;
            double y = pos.getY() + 0.9D;
            double z = pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.8D;
            level.addParticle(ParticleTypes.ENCHANT, x, y, z, (random.nextDouble() - 0.5D) * 0.3D, -random.nextDouble() * 0.4D, (random.nextDouble() - 0.5D) * 0.3D);
        }
    }
}