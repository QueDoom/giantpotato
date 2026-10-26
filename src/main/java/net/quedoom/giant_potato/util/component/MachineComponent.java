package net.quedoom.giant_potato.util.component;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.quedoom.giant_potato.util.MachineComponentSettings;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public interface MachineComponent {
    public MachineComponentSettings getSettings();

    default boolean equals(MachineComponent other) {
        return other != null && sameInterfaceCanonical(other) && sameComponentValues(other);
    }

    default boolean sameInterfaceCanonical(MachineComponent other) {
        return other.getClass().getCanonicalName().equals(this.getClass().getCanonicalName());
    }

    default boolean sameComponentValues(MachineComponent other) {
        if (other == null || !sameInterfaceCanonical(other)) return false;

        for (Field field : this.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(ComparableComponentValue.class)) continue;
            try {
                field.setAccessible(true);
                if (!Objects.equals(field.get(this), field.get(other))) return false;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    default List<BlockPos> getComponentPosses(Level level, BlockPos componentPosition, List<BlockPos> alreadyVisited) {
        return List.of(componentPosition);
    }
}
