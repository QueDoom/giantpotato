package net.quedoom.giant_potato.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.util.InputType;
import net.quedoom.giant_potato.util.MachineComponentSettings;
import net.quedoom.giant_potato.util.component.ComponentValue;
import net.quedoom.giant_potato.util.component.MachineComponent;

public abstract class AbstractMachineComponentEntity extends BlockEntity implements MachineComponent {
    @ComponentValue
    private InputType tttajp = InputType.INPUT;

    public AbstractMachineComponentEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }


}
