package net.quedoom.giant_potato.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.block.entity.abstracts.AbstractMachineComponentEntity;
import net.quedoom.giant_potato.init.ModBlockEntities;
import net.quedoom.giant_potato.init.ModMachineSettings;
import net.quedoom.giant_potato.util.MachineComponentSettings;

public class TestMachineComponentEntity extends AbstractMachineComponentEntity {
    public TestMachineComponentEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntities.TEST_COMPONENT, worldPosition, blockState);
    }

    @Override
    public MachineComponentSettings getSettings() {
        return ModMachineSettings.TEST;
    }
}
