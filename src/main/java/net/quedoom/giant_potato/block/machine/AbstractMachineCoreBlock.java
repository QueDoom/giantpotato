package net.quedoom.giant_potato.block.machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.quedoom.giant_potato.init.ModBlockStateProperties;
import net.quedoom.giant_potato.util.MachineCoreFace;
import org.jspecify.annotations.Nullable;
import org.lwjgl.util.freetype.FreeType;

public abstract class AbstractMachineCoreBlock extends BaseEntityBlock {
    public static final EnumProperty<MachineCoreFace> NORTH = ModBlockStateProperties.MACHINE_CORE_FACE_NORTH;
    public static final EnumProperty<MachineCoreFace> EAST = ModBlockStateProperties.MACHINE_CORE_FACE_EAST;
    public static final EnumProperty<MachineCoreFace> SOUTH = ModBlockStateProperties.MACHINE_CORE_FACE_SOUTH;
    public static final EnumProperty<MachineCoreFace> WEST = ModBlockStateProperties.MACHINE_CORE_FACE_WEST;
    public static final EnumProperty<MachineCoreFace> UP = ModBlockStateProperties.MACHINE_CORE_FACE_UP;
    public static final EnumProperty<MachineCoreFace> DOWN = ModBlockStateProperties.MACHINE_CORE_FACE_DOWN;

    public AbstractMachineCoreBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, MachineCoreFace.NOT_CONNECTED)
                .setValue(EAST, MachineCoreFace.NOT_CONNECTED)
                .setValue(SOUTH, MachineCoreFace.NOT_CONNECTED)
                .setValue(WEST, MachineCoreFace.NOT_CONNECTED)
                .setValue(UP, MachineCoreFace.NOT_CONNECTED)
                .setValue(DOWN, MachineCoreFace.NOT_CONNECTED)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return getState(context.getLevel(), context.getClickedPos(), this.defaultBlockState());
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return getState(((Level) level), pos, state);
    }

    private static BlockState getState(Level level, BlockPos pos, BlockState state) {
        BlockState state1 = state;
        for (Direction direction : Direction.values()) {
            if (!level.getBlockState(pos.relative(direction)).is(BlockTags.AIR))
                state1 = state.setValue(getProperty(direction), MachineCoreFace.CONNECTED);
            else
                state1 = state.setValue(getProperty(direction), MachineCoreFace.NOT_CONNECTED);
        }
        return state1;
    }

    private static EnumProperty<MachineCoreFace> getProperty(Direction direction) {
        return switch (direction) {
            case DOWN -> DOWN;
            case UP -> UP;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
        };
    }

    //
//    protected static <R extends BlockEntity> @Nullable BlockEntityTicker<R> createTicker(final Level level, final BlockEntityType<R> actualType, final BlockEntityType<? extends T> expectedType) {
//        return createTickerHelper(actualType, expectedType, (innerLevel, pos, state, entity) -> T.tick(level, pos, state, entity, level.getBlockState(pos.below())));
//    }
}
