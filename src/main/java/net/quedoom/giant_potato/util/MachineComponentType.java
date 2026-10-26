package net.quedoom.giant_potato.util;

import net.quedoom.giant_potato.util.component.MachineComponent;

public record MachineComponentType(String name) {

    public static  MachineComponentType create(
            String name) {
        return new MachineComponentType(name);
    }

    public boolean compareName(String name) {
        return this.name.equals(name);
    }

}
