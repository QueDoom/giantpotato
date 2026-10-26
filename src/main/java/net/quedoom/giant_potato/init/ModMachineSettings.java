package net.quedoom.giant_potato.init;

import net.quedoom.giant_potato.util.MachineComponentSettings;
import net.quedoom.giant_potato.util.MachineComponentType;
import net.quedoom.giant_potato.util.MachineCoreSettings;
import net.quedoom.giant_potato.util.MachineTier;
import net.quedoom.giant_potato.util.component.MachineComponent;

public class ModMachineSettings {
    public static final MachineComponentType TEST_TYPE = MachineComponentType.create("test");
    public static final MachineComponentSettings TEST = MachineComponentSettings.builder(TEST_TYPE, MachineTier.POTATO).build();

    public static final MachineCoreSettings POTATO = MachineCoreSettings.builder(ModTags.Blocks.POTATO_COMPONENTS, MachineTier.POTATO).build();
    public static final MachineCoreSettings POISONOUS = MachineCoreSettings.builder(ModTags.Blocks.POISONOUS_POTATO_COMPONENTS, MachineTier.POISONOUS_POTATO).build();
    public static final MachineCoreSettings VICIOUS = MachineCoreSettings.builder(ModTags.Blocks.VICIOUS_POTATO_COMPONENTS, MachineTier.VICIOUS_POTATO).build();
    public static final MachineCoreSettings STRONG = MachineCoreSettings.builder(ModTags.Blocks.STRONG_POTATO_COMPONENTS, MachineTier.STRONG_POTATO).build();
}
