package net.quedoom.giant_potato.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.block.entity.abstracts.AbstractMachineCoreBlockEntity;
import net.quedoom.giant_potato.init.ModBlockEntities;
import net.quedoom.giant_potato.init.ModMachineSettings;
import net.quedoom.giant_potato.util.MachineCoreSettings;

public class PotatoMachineCoreEntity extends AbstractMachineCoreBlockEntity {
    public PotatoMachineCoreEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntities.POTATO_CORE, worldPosition, blockState);
    }

    @Override
    public MachineCoreSettings settings() {
        return ModMachineSettings.POTATO;
    }
}
