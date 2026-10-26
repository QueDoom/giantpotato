package net.quedoom.giant_potato.util.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public interface MachineExtenderComponent extends MachineComponent {

    @Override
    default List<BlockPos> getComponentPosses(Level level, BlockPos componentPosition, List<BlockPos> alreadyVisited) {
        final List<BlockPos> positions = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            BlockPos relPos = componentPosition.relative(direction);
            if (alreadyVisited.contains(relPos)) continue;
            if (!(level.getBlockEntity(relPos) instanceof MachineComponent component)) continue;
            positions.addAll(component.getComponentPosses(level, relPos, alreadyVisited));
        }

        return positions;
    }
}
