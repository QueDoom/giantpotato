package net.quedoom.giant_potato.util.pipecable;

import net.minecraft.util.StringRepresentable;

public enum PipeStates implements StringRepresentable {
    NOT_CONNECTED("none"),
    CONNECTED("connected"),
    INPUT("input"),
    OUTPUT("output");

    public static PipeStates of(boolean truefalse) {
        return truefalse ? CONNECTED : NOT_CONNECTED;
    }

    public static boolean toBool(PipeStates state) {
        return state.equals(CONNECTED);
    }

    private final String name;

    PipeStates(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
