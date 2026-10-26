package net.quedoom.giant_potato.init;

import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.level.block.Block;
import net.quedoom.giant_potato.GiantPotato;

import java.util.Optional;

public class ModModels {
    // region machine core
    public static final ModelTemplate MACHINE_CORE = block("machine_core_center", "_center", TextureSlots.CORE);
    public static final ModelTemplate MACHINE_CORE_ITEM = item("machine_core_center", TextureSlots.CORE);

    public static final ModelTemplate MACHINE_ARROWS_NORTH = block("machine_arrows_north", "_north", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_EAST = block("machine_arrows_east", "_east", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_SOUTH = block("machine_arrows_south", "_south", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_WEST = block("machine_arrows_west", "_west", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_UP = block("machine_arrows_up", "_up", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_DOWN = block("machine_arrows_down", "_down", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);

    public static final ModelTemplate MACHINE_ARROWS_NORTH_DISABLED = block("machine_arrows_north", "_north_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_EAST_DISABLED = block("machine_arrows_east", "_east_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_SOUTH_DISABLED = block("machine_arrows_south", "_south_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_WEST_DISABLED = block("machine_arrows_west", "_west_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_UP_DISABLED = block("machine_arrows_up", "_up_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_DOWN_DISABLED = block("machine_arrows_down", "_down_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    // endregion machine core

    // region machine component
    public static final ModelTemplate MACHINE_COMPONENT_ON = block("machine_component_center", "_center_on", TextureSlots.COMPONENT);
    public static final ModelTemplate MACHINE_COMPONENT_OFF = block("machine_component_center", "_center_off", TextureSlots.COMPONENT);
    public static final ModelTemplate MACHINE_COMPONENT_ITEM = item("machine_component_center", TextureSlots.COMPONENT);

    public static final ModelTemplate MACHINE_ARROWS_NORTH_UNSUPPORTED = block("machine_arrows_north", "_north_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_EAST_UNSUPPORTED = block("machine_arrows_east", "_east_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_SOUTH_UNSUPPORTED = block("machine_arrows_south", "_south_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_WEST_UNSUPPORTED = block("machine_arrows_west", "_west_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_UP_UNSUPPORTED = block("machine_arrows_up", "_up_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_DOWN_UNSUPPORTED = block("machine_arrows_down", "_down_unsupported", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);

    public static final ModelTemplate MACHINE_ARROWS_NORTH_CAPACITY = block("machine_arrows_north", "_north_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_EAST_CAPACITY = block("machine_arrows_east", "_east_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_SOUTH_CAPACITY = block("machine_arrows_south", "_south_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_WEST_CAPACITY = block("machine_arrows_west", "_west_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_UP_CAPACITY = block("machine_arrows_up", "_up_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_DOWN_CAPACITY = block("machine_arrows_down", "_down_capacity", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);

    public static final ModelTemplate MACHINE_ARROWS_NORTH_STORAGE = block("machine_arrows_north", "_north_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_EAST_STORAGE = block("machine_arrows_east", "_east_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_SOUTH_STORAGE = block("machine_arrows_south", "_south_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_WEST_STORAGE = block("machine_arrows_west", "_west_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_UP_STORAGE = block("machine_arrows_up", "_up_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_ARROWS_DOWN_STORAGE = block("machine_arrows_down", "_down_storage", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    // endregion machine component

    // region energy cable
    public static final ModelTemplate ENERGY_CABLE_CENTER = block("energy_cable_center", "_center", TextureSlots.CABLE_WOOL, TextureSlots.CABLE_WIRE);
    public static final ModelTemplate ENERGY_CABLE_INVENTORY = item("energy_cable_inventory", TextureSlots.CABLE_WOOL, TextureSlots.CABLE_WIRE);
    public static final ModelTemplate ENERGY_CABLE_BIT = block("energy_cable_bit", "_bit", TextureSlots.CABLE_WOOL, TextureSlots.CABLE_WIRE);
    public static final ModelTemplate ENERGY_CABLE_BIT_OUTPUT = block("energy_cable_output", "_bit_output", TextureSlots.CABLE_WOOL, TextureSlots.CABLE_WIRE);
    // endregion energy cable

    // helper method for creating Models
    private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    // helper method for creating Models with variants
    private static ModelTemplate block(String parent, String variant, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
    // helper method for creating Models
    private static ModelTemplate item(String parent, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    // helper method for creating Models with variants
    private static ModelTemplate item(String parent, String variant, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("item/" + parent)), Optional.of(variant), requiredTextureKeys);
    }


    public static class TextureSlots {
        public static final TextureSlot CORE = TextureSlot.create("core", TextureSlot.ALL);
        public static final TextureSlot COMPONENT = TextureSlot.create("component", TextureSlot.ALL);
        public static final TextureSlot SIDE_ARROWS = TextureSlot.create("arrows", TextureSlot.SIDE);
        public static final TextureSlot FRONT_ARROWS = TextureSlot.create("front", TextureSlot.FRONT);

        public static final TextureSlot CABLE_WOOL = TextureSlot.create("wool");
        public static final TextureSlot CABLE_WIRE = TextureSlot.create("wire");
    }

    public static class TextureMappings {
        // region machines
        public static TextureMapping core(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.CORE, new Material(ModelLocationUtils.getModelLocation(block)));
        }
        public static TextureMapping componentOn(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.COMPONENT, new Material(ModelLocationUtils.getModelLocation(block, "_on")));
        }
        public static TextureMapping componentOff(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.COMPONENT, new Material(ModelLocationUtils.getModelLocation(block, "_off")));
        }
        public static TextureMapping arrows(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_front")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_pointing")))
                    ;
        }
        public static TextureMapping disabledArrows(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_front_disabled")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_pointing_disabled")))
                    ;
        }
        public static TextureMapping storageArrows(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_front")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_storage")))
                    ;
        }
        public static TextureMapping unsupportedArrows(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_front_disabled")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_unsupported")))
                    ;
        }
        public static TextureMapping capacityReachedArrows(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_front_disabled")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(ModelLocationUtils.getModelLocation(block, "_capacity")))
                    ;
        }
        public static TextureMapping basicTierArrows() {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_front")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_pointing")))
                    ;
        }
        public static TextureMapping basicTierArrowsDisabled() {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_front_disabled")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(GiantPotato.of("block/basic_machine_core_pointing_disabled")))
                    ;
        }
        // endregion machines
        // region cable
        public static TextureMapping cableBlackWool(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.CABLE_WOOL, new Material(GiantPotato.of("block/energy_cable")))
                    .put(TextureSlots.CABLE_WIRE, new Material(ModelLocationUtils.getModelLocation(block)));
        }
        public static TextureMapping cable(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.CABLE_WOOL, new Material(ModelLocationUtils.getModelLocation(block, "_wool")))
                    .put(TextureSlots.CABLE_WIRE, new Material(ModelLocationUtils.getModelLocation(block)));
        }
        // endregion cable
    }
}
