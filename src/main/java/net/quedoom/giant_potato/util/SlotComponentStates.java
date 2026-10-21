package net.quedoom.giant_potato.util;

import net.minecraft.util.StringRepresentable;

public enum SlotComponentStates implements StringRepresentable {
    NO_EXPORT_OR_IMPORT("none"),
    IMPORT("import"),
    EXPORT("export");

    private final String name;

    SlotComponentStates(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
