package net.quedoom.giant_potato.util.component;

import net.quedoom.giant_potato.util.MachineComponentSettings;
import net.quedoom.giant_potato.util.MachineComponentType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface MachineComponent {
    public MachineComponentSettings getSettings();

    default Class<? extends MachineComponent> getChildInterface() {
        return getSettings().componentType.interfaceClass();
    }

    default boolean equals(MachineComponent machineComponent) {
        return machineComponent.equals(this) && sameComponentValues(machineComponent);
    }

    default boolean sameComponentValues(MachineComponent other) {
        if (other == null || other.getClass() != this.getClass()) return false;

        for (Field f : this.getClass().getDeclaredFields()) {
            if (!f.isAnnotationPresent(ComponentValue.class)) continue;
            try {
                f.setAccessible(true);
                if (!Objects.equals(f.get(this), f.get(other))) return false;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
