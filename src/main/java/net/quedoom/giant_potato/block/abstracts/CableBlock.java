package net.quedoom.giant_potato.block.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.init.ModItems;
import net.quedoom.giant_potato.util.component.MachineComponent;
import net.quedoom.giant_potato.util.pipecable.PipeStates;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CableBlock extends Block {
    private final VoxelShape SHAPE_CENTER;
    private final VoxelShape SHAPE_NORTH;
    private final VoxelShape SHAPE_SOUTH;
    private final VoxelShape SHAPE_EAST;
    private final VoxelShape SHAPE_WEST;
    private final VoxelShape SHAPE_UP;
    private final VoxelShape SHAPE_DOWN;

    public static final EnumProperty<PipeStates> NORTH = EnumProperty.create("north", PipeStates.class);
    public static final EnumProperty<PipeStates> SOUTH = EnumProperty.create("south", PipeStates.class);
    public static final EnumProperty<PipeStates> EAST = EnumProperty.create("east", PipeStates.class);
    public static final EnumProperty<PipeStates> WEST = EnumProperty.create("west", PipeStates.class);
    public static final EnumProperty<PipeStates> UP = EnumProperty.create("up", PipeStates.class);
    public static final EnumProperty<PipeStates> DOWN = EnumProperty.create("down", PipeStates.class);

    private final TagKey<Block> cables;
    private final int thickness;

    public CableBlock(Properties properties, TagKey<Block> cables, int thickness) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, PipeStates.NOT_CONNECTED).setValue(SOUTH, PipeStates.NOT_CONNECTED)
                .setValue(EAST, PipeStates.NOT_CONNECTED).setValue(WEST, PipeStates.NOT_CONNECTED)
                .setValue(UP, PipeStates.NOT_CONNECTED).setValue(DOWN, PipeStates.NOT_CONNECTED)
        );
        this.cables       = cables;
        this.thickness    = thickness;

        this.SHAPE_CENTER = box(5, 5, 5, 5 + thickness, 5 + thickness, 5 + thickness);
        this.SHAPE_NORTH  = box(5, 5, 0, 5 + thickness, 5 + thickness, 5);
        this.SHAPE_SOUTH  = box(5, 5, 5 + thickness, 5 + thickness, 5 + thickness, 16);
        this.SHAPE_WEST   = box(0, 5, 5, 5, 5 + thickness, 5 + thickness);
        this.SHAPE_EAST   = box(5 + thickness, 5, 5, 16, 5 + thickness, 5 + thickness);
        this.SHAPE_DOWN   = box(5, 0, 5, 5 + thickness, 5, 5 + thickness);
        this.SHAPE_UP     = box(5, 5 + thickness, 5, 5 + thickness, 16, 5 + thickness);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    protected InteractionResult tryChangeOutput(Level level, BlockPos pos, BlockState state, BlockHitResult hitResult) {
        EnumProperty<PipeStates> property = getPropertyFromHitResult(hitResult).orElse(null);
        if (property == null) return InteractionResult.PASS;

        PipeStates current = state.getValue(property);
        if (current != PipeStates.CONNECTED && current != PipeStates.INPUT && current != PipeStates.OUTPUT)
            return InteractionResult.PASS;

        if (current == PipeStates.OUTPUT) {
            if (!level.isClientSide()) {
                level.setBlock(pos, state.setValue(property,
                        PipeStates.CONNECTED), UPDATE_CLIENTS);
            }
        } else {
            if (level.getBlockEntity(pos.relative(getDirectionFromProperty(property))) instanceof MachineComponent) {
                if (!level.isClientSide()) {
                    level.setBlock(pos, state.setValue(property,
                            PipeStates.OUTPUT), UPDATE_CLIENTS);
                }
            } else {
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.SUCCESS;
    }

    protected Optional<EnumProperty<PipeStates>> getPropertyFromHitResult(BlockHitResult hitResult) {
        BlockPos pos = hitResult.getBlockPos();
        Vec3 p = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

        double min = (16 - this.thickness) / 2.0 / 16.0;
        double max = min + this.thickness / 16.0;
        double eps = 1e-4;

        if (p.x < min - eps) return Optional.of(getProperty(Direction.WEST));
        if (p.x > max + eps) return Optional.of(getProperty(Direction.EAST));
        if (p.y < min - eps) return Optional.of(getProperty(Direction.DOWN));
        if (p.y > max + eps) return Optional.of(getProperty(Direction.UP));
        if (p.z < min - eps) return Optional.of(getProperty(Direction.NORTH));
        if (p.z > max + eps) return Optional.of(getProperty(Direction.SOUTH));

        return Optional.of(getProperty(hitResult.getDirection()));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Direction side = hitResult.getDirection();
        if (!isInMiddle(hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ()), side))
            return tryChangeOutput(level, pos, state, hitResult);

        boolean isEmpty = level.getBlockState(pos.relative(side)).isAir();
        if (isEmpty && !itemStack.is(ModItems.TILLER)) return tryChangeOutput(level, pos, state, hitResult);
        if (!(itemStack.is(state.getBlock().asItem()) || itemStack.is(ModItems.TILLER)))
            return tryChangeOutput(level, pos, state, hitResult);

        EnumProperty<PipeStates> prop = getProperty(side);
        boolean remove = state.getValue(prop) == PipeStates.INPUT || state.getValue(prop) == PipeStates.CONNECTED;

        if (!level.isClientSide()) {
            if (remove) {
                level.playSound(null, pos, SoundEvents.SHEARS_SNIP, SoundSource.BLOCKS, 0.5f,
                        level.getRandom().nextFloat() * 0.1f + 0.95f);
            } else {
                SoundType sound = state.getSoundType();
                level.playSound(null, pos, sound.getPlaceSound(), SoundSource.BLOCKS,
                        (sound.getVolume() + 1.0f) / 2.0f, sound.getPitch() * 0.8f);
            }
            level.setBlock(pos, state.setValue(prop, remove ? PipeStates.NOT_CONNECTED : PipeStates.INPUT), UPDATE_CLIENTS);
        }
        return InteractionResult.SUCCESS;
    }

    private boolean isInMiddle(Vec3 p, Direction side) {
        double min = (16 - this.thickness) / 2.0 / 16.0;
        double max = min + this.thickness / 16.0;
        return switch (side.getAxis()) {
            case X -> within(p.y, min, max) && within(p.z, min, max);
            case Y -> within(p.x, min, max) && within(p.z, min, max);
            case Z -> within(p.x, min, max) && within(p.y, min, max);
        };
    }

    private static boolean within(double v, double min, double max) {
        return v >= min - 1e-4 && v <= max + 1e-4;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return getState(context.getLevel(), context.getClickedPos(), this.defaultBlockState(), Direction.values());
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState,
                                     RandomSource random) {
        return withSide(state, directionToNeighbour, neighbourState);
    }

    public BlockState getState(LevelReader level, BlockPos pos, BlockState state, Direction... checkSides) {
        for (Direction side : checkSides) {
            state = withSide(state, side, level.getBlockState(pos.relative(side)));
        }
        return state;
    }

    private BlockState withSide(BlockState state, Direction side, BlockState neighbour) {
        EnumProperty<PipeStates> prop = getProperty(side);
        if (state.getValue(prop) == PipeStates.INPUT) return state;
        return state.setValue(prop, neighbour.is(this.cables) ? PipeStates.CONNECTED : PipeStates.NOT_CONNECTED);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return absoluteShape(state);
    }

    private VoxelShape absoluteShape(BlockState state) {
        VoxelShape shape = SHAPE_CENTER;
        shape = Shapes.joinUnoptimized(shape, state.getValue(NORTH) != PipeStates.NOT_CONNECTED ? SHAPE_NORTH : Shapes.empty(), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, state.getValue(SOUTH) != PipeStates.NOT_CONNECTED ? SHAPE_SOUTH : Shapes.empty(), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, state.getValue(EAST) != PipeStates.NOT_CONNECTED ? SHAPE_EAST : Shapes.empty(), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, state.getValue(WEST) != PipeStates.NOT_CONNECTED ? SHAPE_WEST : Shapes.empty(), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, state.getValue(UP) != PipeStates.NOT_CONNECTED ? SHAPE_UP : Shapes.empty(), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, state.getValue(DOWN) != PipeStates.NOT_CONNECTED ? SHAPE_DOWN : Shapes.empty(), BooleanOp.OR);
        return shape.optimize();
    }

    public static EnumProperty<PipeStates> getProperty(Direction direction) {
        return switch(direction) {
            case DOWN -> DOWN;
            case UP -> UP;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
        };
    }

    public static Direction getDirectionFromProperty(EnumProperty<PipeStates> property) {
        if (property == NORTH) return Direction.NORTH;
        if (property == SOUTH) return Direction.SOUTH;
        if (property == EAST)  return Direction.EAST;
        if (property == WEST)  return Direction.WEST;
        if (property == UP)    return Direction.UP;
        if (property == DOWN)  return Direction.DOWN;
        throw new IllegalArgumentException("Not a cable side property: " + property);
    }
}
