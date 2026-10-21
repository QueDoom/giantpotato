package net.quedoom.giant_potato.block.machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.quedoom.giant_potato.init.ModBlockStateProperties;
import net.quedoom.giant_potato.util.MachineComponentFace;
import net.quedoom.giant_potato.util.SlotComponentStates;
import org.jspecify.annotations.Nullable;

public abstract class AbstractMachineComponent extends BaseEntityBlock {
    public static final EnumProperty<MachineComponentFace> NORTH = ModBlockStateProperties.MACHINE_COMPONENT_FACE_NORTH;
    public static final EnumProperty<MachineComponentFace> EAST = ModBlockStateProperties.MACHINE_COMPONENT_FACE_EAST;
    public static final EnumProperty<MachineComponentFace> SOUTH = ModBlockStateProperties.MACHINE_COMPONENT_FACE_SOUTH;
    public static final EnumProperty<MachineComponentFace> WEST = ModBlockStateProperties.MACHINE_COMPONENT_FACE_WEST;
    public static final EnumProperty<MachineComponentFace> UP = ModBlockStateProperties.MACHINE_COMPONENT_FACE_UP;
    public static final EnumProperty<MachineComponentFace> DOWN = ModBlockStateProperties.MACHINE_COMPONENT_FACE_DOWN;
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public AbstractMachineComponent(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, MachineComponentFace.NOT_CONNECTED).setValue(EAST, MachineComponentFace.NOT_CONNECTED)
                .setValue(SOUTH, MachineComponentFace.NOT_CONNECTED).setValue(WEST, MachineComponentFace.NOT_CONNECTED)
                .setValue(UP, MachineComponentFace.NOT_CONNECTED).setValue(DOWN, MachineComponentFace.NOT_CONNECTED)
                .setValue(ON, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, ON);
    }
}
