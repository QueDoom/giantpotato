package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.init.ModBlockStateProperties;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.giant_potato.init.ModModels;
import net.quedoom.giant_potato.util.MachineCoreFace;
import net.quedoom.quet.datagen.models.QTBlockModelGenerators;
import net.quedoom.quet.datagen.models.QTItemModelGenerators;
import net.quedoom.quet.datagen.models.QueTModelProvider;

public class GiantPotatoModels extends QueTModelProvider {
    public GiantPotatoModels(FabricPackOutput output) {
        super(output);
    }

    public static ConditionBuilder condition() {
        return new ConditionBuilder();
    }

    @Override
    protected String namespace() {
        return GiantPotato.MOD_ID;
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators, QTItemModelGenerators qtItemModelGenerators) {

    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators, QTBlockModelGenerators qtBlockModelGenerators) {
        machineCasing(blockModelGenerators, ModBlocks.BASIC_MACHINE_CORE);
    }

    public void machineCasing(BlockModelGenerators generators, final Block block) {
        Identifier centerId = ModModels.MACHINE_CORE.create(block, ModModels.TextureMappings.core(block), generators.modelOutput);
        MultiVariant center = BlockModelGenerators.plainVariant(centerId);
        MultiVariant north = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_NORTH.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant northDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_NORTH_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        MultiVariant east = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_EAST.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant eastDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_EAST_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        MultiVariant south = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_SOUTH.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant southDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_SOUTH_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        MultiVariant west = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_WEST.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant westDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_WEST_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        MultiVariant up = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_UP.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant upDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_UP_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        MultiVariant down = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_DOWN.create(block, ModModels.TextureMappings.arrows(block), generators.modelOutput));
        MultiVariant downDisabled = BlockModelGenerators.plainVariant(ModModels.MACHINE_CORE_ARROWS_DOWN_DISABLED.create(block, ModModels.TextureMappings.disabledArrows(block), generators.modelOutput));
        Identifier inventory = ModModels.MACHINE_CORE_ITEM.create(block.asItem(), ModModels.TextureMappings.core(block), generators.modelOutput);
        generators.blockStateOutput.accept(createMachineCasingBlockstate(block, center,
                north, east, south, west, up, down,
                northDisabled, eastDisabled, southDisabled, westDisabled, upDisabled, downDisabled));
        generators.registerSimpleItemModel(block, inventory);
    }

    private static BlockModelDefinitionGenerator createMachineCasingBlockstate(
            Block block, MultiVariant center,
            MultiVariant north, MultiVariant east, MultiVariant south,
            MultiVariant west, MultiVariant up, MultiVariant down,
            MultiVariant northDisabled, MultiVariant eastDisabled, MultiVariant southDisabled,
            MultiVariant westDisabled, MultiVariant upDisabled, MultiVariant downDisabled) {
        return MultiPartGenerator.multiPart(block)
                .with(center)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_NORTH, MachineCoreFace.CONNECTED), north)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_NORTH, MachineCoreFace.CONNECTED_BUT_DISABLED), northDisabled)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_EAST, MachineCoreFace.CONNECTED), east)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_EAST, MachineCoreFace.CONNECTED_BUT_DISABLED), eastDisabled)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_SOUTH, MachineCoreFace.CONNECTED), south)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_SOUTH, MachineCoreFace.CONNECTED_BUT_DISABLED), southDisabled)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_WEST, MachineCoreFace.CONNECTED), west)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_WEST, MachineCoreFace.CONNECTED_BUT_DISABLED), westDisabled)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_UP, MachineCoreFace.CONNECTED), up)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_UP, MachineCoreFace.CONNECTED_BUT_DISABLED), upDisabled)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_DOWN, MachineCoreFace.CONNECTED), down)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_DOWN, MachineCoreFace.CONNECTED_BUT_DISABLED), downDisabled);
    }
}
