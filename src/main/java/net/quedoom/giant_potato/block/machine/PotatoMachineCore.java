package net.quedoom.giant_potato.block.machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.block.abstracts.AbstractMachineCoreBlock;
import net.quedoom.giant_potato.block.entity.machine.PotatoMachineCoreEntity;
import org.jspecify.annotations.Nullable;

public class PotatoMachineCore extends AbstractMachineCoreBlock {
    public PotatoMachineCore(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(PotatoMachineCore::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new PotatoMachineCoreEntity(worldPosition, blockState);
    }
}
