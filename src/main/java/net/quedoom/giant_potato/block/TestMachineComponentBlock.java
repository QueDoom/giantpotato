package net.quedoom.giant_potato.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.quedoom.giant_potato.block.machine.AbstractMachineComponent;
import net.quedoom.giant_potato.init.ModComponentSettings;
import net.quedoom.giant_potato.util.MachineComponentSettings;
import org.jspecify.annotations.Nullable;

public class TestMachineComponentBlock extends AbstractMachineComponent {
    public TestMachineComponentBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(TestMachineComponentBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return null;
    }
}
