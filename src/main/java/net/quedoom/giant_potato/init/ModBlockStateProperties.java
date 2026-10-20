package net.quedoom.giant_potato.init;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.quedoom.giant_potato.util.MachineCoreFace;

public class ModBlockStateProperties {
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_NORTH = EnumProperty.create("north", MachineCoreFace.class);
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_EAST = EnumProperty.create("east", MachineCoreFace.class);
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_SOUTH = EnumProperty.create("south", MachineCoreFace.class);
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_WEST = EnumProperty.create("west", MachineCoreFace.class);
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_UP = EnumProperty.create("up", MachineCoreFace.class);
    public static final EnumProperty<MachineCoreFace> MACHINE_CORE_FACE_DOWN = EnumProperty.create("down", MachineCoreFace.class);
}
