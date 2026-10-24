package net.quedoom.giant_potato.util.component;

import net.quedoom.giant_potato.util.MachineComponentSettings;

import java.lang.reflect.Field;
import java.util.Objects;

public interface MachineComponent {
    public MachineComponentSettings getSettings();

    default Class<? extends MachineComponent> getChildInterface() {
        return getSettings().componentType.interfaceClass();
    }

    default boolean equals(MachineComponent other) {
        return other != null && sameInterfaceCanonical(other) && sameComponentValues(other);
    }

    default boolean sameInterfaceCanonical(MachineComponent other) {
        return other.getClass().getCanonicalName().equals(this.getChildInterface().getCanonicalName());
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
}
