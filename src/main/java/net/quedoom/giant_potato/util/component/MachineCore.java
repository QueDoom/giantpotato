package net.quedoom.giant_potato.util.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.quedoom.giant_potato.util.MachineCoreSettings;

import java.util.ArrayList;
import java.util.List;

public interface MachineCore {
    MachineCoreSettings settings();

    default List<BlockPos> getDirectionPosses(Level level, BlockPos pos) {
        final List<Direction> notAllowed = settings().forbiddenSides();
        final List<BlockPos> positions = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (notAllowed.contains(direction)) continue;
            BlockPos relPos = pos.relative(direction);
            if (!(level.getBlockEntity(relPos) instanceof MachineComponent component)) continue;
            positions.addAll(component.getComponentPosses(level, relPos, List.of(pos)));
        }

        return positions;
    }

}
