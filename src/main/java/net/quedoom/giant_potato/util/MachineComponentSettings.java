package net.quedoom.giant_potato.util;

import net.minecraft.core.Direction;
import net.quedoom.giant_potato.util.component.MachineComponent;
import net.quedoom.giant_potato.util.component.MachineCore;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MachineComponentSettings {
    private final String name;
    private final MachineComponentType<? extends MachineComponent> componentType;
    private final InputType inputType;

    private final List<Direction> appliedOn;
    private final int maxAmountPerCore;

    protected MachineComponentSettings(String name, MachineComponentType<? extends MachineComponent> componentType,
                                       InputType inputType, List<Direction> appliedOn, int maxAmountPerCore) {
        this.name = name;
        this.componentType = componentType;
        this.inputType = inputType;

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
        private final InputType inputType;

        /**
         * Determines what sides the {@link MachineComponent} with this {@link MachineComponentSettings} can be on a {@link MachineCore} <br>
         * If the link is empty; all sides are available.
         */
        private List<Direction> appliedOn = List.of();
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
            this.inputType = Objects.requireNonNullElse(inputType, InputType.NOT_A_STORAGE_COMPONENT);
        }

        private Builder(
                String name,
                MachineComponentType<? extends MachineComponent> type
        ) {
            this.name = name;
            this.componentType = type;
            this.inputType = InputType.NOT_A_STORAGE_COMPONENT;
        }
        // endregion constructors

        @Override
        public String toString() {
            return "MachineComponentSettings#Builder[final name: " + this.name +
                    ", final componentType: " + this.componentType +
                    ", final inputType: " + this.inputType;
        }
    }
}
