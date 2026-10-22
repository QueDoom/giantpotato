package net.quedoom.giant_potato.init;

import net.quedoom.giant_potato.util.MachineComponentSettings;
import net.quedoom.giant_potato.util.MachineComponentType;
import net.quedoom.giant_potato.util.component.MachineComponent;

public class ModComponentSettings {
    public static final MachineComponentType<MachineComponent> TEST_TYPE = MachineComponentType.create("test", MachineComponent.class);
    public static final MachineComponentSettings TEST = MachineComponentSettings.builder("test", TEST_TYPE).build();
}
