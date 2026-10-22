package net.quedoom.giant_potato.util;

import net.minecraft.util.StringRepresentable;

public enum InputType implements StringRepresentable {
    INPUT("input"),
    INPUT_SUCK("suck"),
    OUTPUT("output"),
    OUTPUT_PUSH("push"),
    NOT_A_STORAGE_COMPONENT("not_storage")
    ;

    private final String name;

    InputType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
