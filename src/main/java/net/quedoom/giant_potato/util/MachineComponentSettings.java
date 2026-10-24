package net.quedoom.giant_potato.util;

import net.minecraft.core.Direction;
import net.quedoom.giant_potato.util.component.MachineComponent;
import net.quedoom.giant_potato.util.component.MachineCore;
import org.jspecify.annotations.Nullable;

import java.util.*;

public record MachineComponentSettings(MachineComponentType<? extends MachineComponent> componentType, int machineTier,
                                       List<Direction> appliedOn, int maxAmountPerCore) {
    public static <T extends MachineComponent> Builder builder(
            MachineComponentType<T> machineComponentType, int machineTier) {
        return new Builder(machineComponentType, machineTier);
    }

    public static class Builder {
        /**
         * What Interface the BlockEntity extends, will most likely be {@link MachineComponent}
         */
        private final MachineComponentType<? extends MachineComponent> componentType;
        private final int machineTier;

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


        private Builder(
                MachineComponentType<? extends MachineComponent> type,
                int machineTier
        ) {
            this.componentType = type;
            this.machineTier = machineTier;
        }

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
            return new MachineComponentSettings(componentType, appliedOn, maxAmountPerCore);
        }

        @Override
        public String toString() {
            return "MachineComponentSettings#Builderfinal componentType: " + this.componentType +
                    ", appliedOn: " + this.appliedOn +
                    ", maxAmountPerCore: " + this.maxAmountPerCore
                    + "]";
        }
    }
}
