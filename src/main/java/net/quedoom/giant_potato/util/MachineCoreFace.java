package net.quedoom.giant_potato.util;

import net.minecraft.util.StringRepresentable;

public enum MachineCoreFace implements StringRepresentable {
    NOT_CONNECTED("none"),
    CONNECTED("connected"),
    CONNECTED_BUT_DISABLED("disabled");

    private final String name;

    MachineCoreFace(String name) {
        this.name = name;
    }


    @Override
    public String getSerializedName() {
        return this.name;
    }
}
