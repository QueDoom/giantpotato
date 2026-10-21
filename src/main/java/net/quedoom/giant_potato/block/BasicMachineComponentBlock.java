package net.quedoom.giant_potato.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.quedoom.giant_potato.block.machine.AbstractMachineComponent;
import org.jspecify.annotations.Nullable;

public class BasicMachineComponentBlock extends AbstractMachineComponent {
    public BasicMachineComponentBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(BasicMachineComponentBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return null;
    }
}
