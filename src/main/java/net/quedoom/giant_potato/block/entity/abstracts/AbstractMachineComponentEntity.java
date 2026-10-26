package net.quedoom.giant_potato.block.entity.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.util.component.MachineComponent;

public abstract class AbstractMachineComponentEntity extends BlockEntity implements MachineComponent {
    public AbstractMachineComponentEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }



}
