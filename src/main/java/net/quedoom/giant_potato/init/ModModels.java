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
    public static final ModelTemplate MACHINE_CORE = block("machine_core_center", "_center", TextureSlots.CORE);
    public static final ModelTemplate MACHINE_CORE_ITEM = block("machine_core_center", TextureSlots.CORE);

    public static final ModelTemplate MACHINE_CORE_ARROWS_NORTH = block("machine_core_arrows_north", "_north", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_EAST = block("machine_core_arrows_east", "_east", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_SOUTH = block("machine_core_arrows_south", "_south", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_WEST = block("machine_core_arrows_west", "_west", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_UP = block("machine_core_arrows_up", "_up", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_DOWN = block("machine_core_arrows_down", "_down", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);

    public static final ModelTemplate MACHINE_CORE_ARROWS_NORTH_DISABLED = block("machine_core_arrows_north", "_north_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_EAST_DISABLED = block("machine_core_arrows_east", "_east_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_SOUTH_DISABLED = block("machine_core_arrows_south", "_south_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_WEST_DISABLED = block("machine_core_arrows_west", "_west_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_UP_DISABLED = block("machine_core_arrows_up", "_up_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);
    public static final ModelTemplate MACHINE_CORE_ARROWS_DOWN_DISABLED = block("machine_core_arrows_down", "_down_disabled", TextureSlots.SIDE_ARROWS, TextureSlots.FRONT_ARROWS);

    // helper method for creating Models
    private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    // helper method for creating Models with variants
    private static ModelTemplate block(String parent, String variant, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(GiantPotato.of("block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }


    public static class TextureSlots {
        public static final TextureSlot CORE = TextureSlot.create("core", TextureSlot.ALL);
        public static final TextureSlot SIDE_ARROWS = TextureSlot.create("arrows", TextureSlot.SIDE);
        public static final TextureSlot FRONT_ARROWS = TextureSlot.create("front", TextureSlot.FRONT);
    }

    public static class TextureMappings {
        public static TextureMapping core(Block block) {
            return new TextureMapping()
                    .put(TextureSlots.CORE, new Material(ModelLocationUtils.getModelLocation(block)));
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
        public static TextureMapping basicTierArrows() {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_tier_machine_core_front")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(GiantPotato.of("block/basic_tier_machine_core_pointing")))
                    ;
        }
        public static TextureMapping basicTierArrowsDisabled() {
            return new TextureMapping()
                    .put(TextureSlots.FRONT_ARROWS, new Material(GiantPotato.of("block/basic_tier_machine_core_front_disabled")))
                    .put(TextureSlots.SIDE_ARROWS, new Material(GiantPotato.of("block/basic_tier_machine_core_pointing_disabled")))
                    ;
        }
    }
}
