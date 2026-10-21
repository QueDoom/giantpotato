package net.quedoom.giant_potato.util;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.quedoom.giant_potato.init.ModModels;

public record ArrowModelTemplatesSet(ModelTemplate north, ModelTemplate east, ModelTemplate south,
                                     ModelTemplate west, ModelTemplate up, ModelTemplate down) {

    public static ArrowModelTemplatesSet normalArrow() {
        return new ArrowModelTemplatesSet(
                ModModels.MACHINE_ARROWS_NORTH, ModModels.MACHINE_ARROWS_EAST,
                ModModels.MACHINE_ARROWS_SOUTH, ModModels.MACHINE_ARROWS_WEST,
                ModModels.MACHINE_ARROWS_UP, ModModels.MACHINE_ARROWS_DOWN
                );
    }
    public static ArrowModelTemplatesSet storageArrow() {
        return new ArrowModelTemplatesSet(
                ModModels.MACHINE_ARROWS_NORTH_STORAGE, ModModels.MACHINE_ARROWS_EAST_STORAGE,
                ModModels.MACHINE_ARROWS_SOUTH_STORAGE, ModModels.MACHINE_ARROWS_WEST_STORAGE,
                ModModels.MACHINE_ARROWS_UP_STORAGE, ModModels.MACHINE_ARROWS_DOWN_STORAGE
                );
    }
    public static ArrowModelTemplatesSet unsupportedArrow() {
        return new ArrowModelTemplatesSet(
                ModModels.MACHINE_ARROWS_NORTH_UNSUPPORTED, ModModels.MACHINE_ARROWS_EAST_UNSUPPORTED,
                ModModels.MACHINE_ARROWS_SOUTH_UNSUPPORTED, ModModels.MACHINE_ARROWS_WEST_UNSUPPORTED,
                ModModels.MACHINE_ARROWS_UP_UNSUPPORTED, ModModels.MACHINE_ARROWS_DOWN_UNSUPPORTED
                );
    }
    public static ArrowModelTemplatesSet capacityArrow() {
        return new ArrowModelTemplatesSet(
                ModModels.MACHINE_ARROWS_NORTH_CAPACITY, ModModels.MACHINE_ARROWS_EAST_CAPACITY,
                ModModels.MACHINE_ARROWS_SOUTH_CAPACITY, ModModels.MACHINE_ARROWS_WEST_CAPACITY,
                ModModels.MACHINE_ARROWS_UP_CAPACITY, ModModels.MACHINE_ARROWS_DOWN_CAPACITY
                );
    }
    public static ArrowModelTemplatesSet disabledArrow() {
        return new ArrowModelTemplatesSet(
                ModModels.MACHINE_ARROWS_NORTH_DISABLED, ModModels.MACHINE_ARROWS_EAST_DISABLED,
                ModModels.MACHINE_ARROWS_SOUTH_DISABLED, ModModels.MACHINE_ARROWS_WEST_DISABLED,
                ModModels.MACHINE_ARROWS_UP_DISABLED, ModModels.MACHINE_ARROWS_DOWN_DISABLED
                );
    }

}
