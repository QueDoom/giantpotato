package net.quedoom.giant_potato.util;

import net.quedoom.giant_potato.util.component.MachineComponent;

public record MachineComponentType<T extends MachineComponent>(
        String name, Class<? extends T> interfaceClass) {

    public static <T extends MachineComponent> MachineComponentType<T> create(
            String name, Class<? extends T> interfaceClass) {
        return new MachineComponentType<>(name, interfaceClass);
    }



}
