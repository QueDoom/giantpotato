package net.quedoom.giant_potato.util;

import net.minecraft.core.Direction;
import net.quedoom.giant_potato.util.component.MachineComponent;
import net.quedoom.giant_potato.util.component.MachineCore;
import org.jspecify.annotations.Nullable;

import java.util.*;

public class MachineComponentSettings {
    public final String name;
    public final MachineComponentType<? extends MachineComponent> componentType;

    public final List<Direction> appliedOn;
    public final int maxAmountPerCore;

    protected MachineComponentSettings(String name, MachineComponentType<? extends MachineComponent> componentType,
                                       List<Direction> appliedOn, int maxAmountPerCore) {
        this.name = name;
        this.componentType = componentType;

        this.appliedOn = appliedOn;
        this.maxAmountPerCore = maxAmountPerCore;
    }

    public static <T extends MachineComponent> Builder builder(String name, MachineComponentType<T> machineComponentType) {
        return new Builder(name, machineComponentType);
    }
    public static <T extends MachineComponent> Builder builder(String name, MachineComponentType<T> machineComponentType, @Nullable InputType inputType) {
        return new Builder(name, machineComponentType, inputType);
    }

    public static class Builder {
        private final String name;
        private final MachineComponentType<? extends MachineComponent> componentType;

        /**
         * Determines what sides the {@link MachineComponent} with this {@link MachineComponentSettings} can be on a {@link MachineCore} <br>
         * If the link is empty; all sides are available.
         */
        private final ArrayList<Direction> appliedOn = new ArrayList<>();
        /**
         * <strong><0</strong> = No limit <br>
         * <strong>1-5</strong> = The max amount of {@link MachineComponent}s with this {@link MachineComponentSettings} can be on a {@link MachineCore} <br>
         * <strong>≥6</strong> = No effect (same as negative number)
         */
        private int maxAmountPerCore = -1;


        // region constructors
        private Builder(
                String name,
                MachineComponentType<? extends MachineComponent> type,
                @Nullable InputType inputType
        ) {
            this.name = name;
            this.componentType = type;
        }

        private Builder(
                String name,
                MachineComponentType<? extends MachineComponent> type
        ) {
            this.name = name;
            this.componentType = type;
        }
        // endregion constructors

        public Builder acceptableSide(Direction side) {
            this.appliedOn.add(side);
            return this;
        }
        public Builder acceptableSides(Direction... sides) {
            this.appliedOn.addAll(Arrays.asList(sides));
            return this;
        }
        public Builder acceptableSides(ArrayList<Direction> sides) {
            this.appliedOn.addAll(sides);
            return this;
        }

        public Builder capacity(int maxAmountPerCore) {
            this.maxAmountPerCore = maxAmountPerCore < 1 ? -1 : maxAmountPerCore;
            return this;
        }

        public MachineComponentSettings build() {
            return new MachineComponentSettings(name, componentType, appliedOn, maxAmountPerCore);
        }

        @Override
        public String toString() {
            return "MachineComponentSettings#Builder[final name: " + this.name +
                    ", final componentType: " + this.componentType +
                    ", appliedOn: " + this.appliedOn +
                    ", maxAmountPerCore: " + this.maxAmountPerCore
                    + "]";
        }
    }
}
