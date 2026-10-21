package net.quedoom.giant_potato.util;

import net.minecraft.util.StringRepresentable;

public enum MachineComponentFace implements StringRepresentable {
    NOT_CONNECTED("none"),
    CONNECTED("connected"),
    CONNECTED_STORAGE("storage"),
    // connected but disabled
    CONNECTED_BUT_UNSUPPORTED("unsupported"),
    CONNECTED_BUT_CAPACITY_REACHED("capacity");

    private final String name;

    MachineComponentFace(String name) {
        this.name = name;
    }


    @Override
    public String getSerializedName() {
        return name;
    }
}
