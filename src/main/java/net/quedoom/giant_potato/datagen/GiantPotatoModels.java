package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.init.ModBlockStateProperties;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.giant_potato.init.ModModels;
import net.quedoom.giant_potato.util.ArrowModelTemplatesSet;
import net.quedoom.giant_potato.util.ArrowModelsSet;
import net.quedoom.giant_potato.util.MachineComponentFace;
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
        machineComponent(blockModelGenerators, ModBlocks.TEST_MACHINE_COMPONENT);
    }

    public void machineCasing(BlockModelGenerators generators, final Block block) {
        Identifier centerId = ModModels.MACHINE_CORE.create(block, ModModels.TextureMappings.core(block), generators.modelOutput);
        MultiVariant center = BlockModelGenerators.plainVariant(centerId);
        ArrowModelsSet normal = ArrowModelsSet.of(ArrowModelTemplatesSet.normalArrow(), ModModels.TextureMappings.arrows(block), block, generators);
        ArrowModelsSet disabled = ArrowModelsSet.of(ArrowModelTemplatesSet.disabledArrow(), ModModels.TextureMappings.disabledArrows(block), block, generators);
        Identifier inventory = ModModels.MACHINE_CORE_ITEM.create(block.asItem(), ModModels.TextureMappings.core(block), generators.modelOutput);
        generators.blockStateOutput.accept(createMachineCoreBlockstate(block, center,
                normal, disabled
                ));
        generators.registerSimpleItemModel(block, inventory);
    }

    private static BlockModelDefinitionGenerator createMachineCoreBlockstate(
            Block block, MultiVariant center,
            ArrowModelsSet normal, ArrowModelsSet disabled) {
        return MultiPartGenerator.multiPart(block)
                .with(center)
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_NORTH, MachineCoreFace.CONNECTED), normal.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_NORTH, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_EAST, MachineCoreFace.CONNECTED), normal.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_EAST, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_SOUTH, MachineCoreFace.CONNECTED), normal.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_SOUTH, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_WEST, MachineCoreFace.CONNECTED), normal.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_WEST, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_UP, MachineCoreFace.CONNECTED), normal.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_UP, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_DOWN, MachineCoreFace.CONNECTED), normal.down())
                .with(condition().term(ModBlockStateProperties.MACHINE_CORE_FACE_DOWN, MachineCoreFace.CONNECTED_BUT_DISABLED), disabled.down());
    }

    public void machineComponent(BlockModelGenerators generators, final Block block) {
            Identifier centerId = ModModels.MACHINE_COMPONENT.create(block, ModModels.TextureMappings.component(block), generators.modelOutput);
        MultiVariant center = BlockModelGenerators.plainVariant(centerId);
        ArrowModelsSet normal = ArrowModelsSet.of(ArrowModelTemplatesSet.normalArrow(), ModModels.TextureMappings.arrows(block), block, generators);
        ArrowModelsSet storage = ArrowModelsSet.of(ArrowModelTemplatesSet.storageArrow(), ModModels.TextureMappings.storageArrows(block), block, generators);
        ArrowModelsSet capacity = ArrowModelsSet.of(ArrowModelTemplatesSet.capacityArrow(), ModModels.TextureMappings.capacityReachedArrows(block), block, generators);
        ArrowModelsSet unsupported = ArrowModelsSet.of(ArrowModelTemplatesSet.unsupportedArrow(), ModModels.TextureMappings.unsupportedArrows(block), block, generators);
        Identifier inventory = ModModels.MACHINE_COMPONENT_ITEM.create(block.asItem(), ModModels.TextureMappings.component(block), generators.modelOutput);
        generators.blockStateOutput.accept(createMachineComponentBlockstate(block, center, normal, storage, unsupported, capacity));
        generators.registerSimpleItemModel(block, inventory);
    }

    private static BlockModelDefinitionGenerator createMachineComponentBlockstate(
            Block block, MultiVariant center,
            ArrowModelsSet normal, ArrowModelsSet storage, ArrowModelsSet unsupported, ArrowModelsSet capacity) {
        return MultiPartGenerator.multiPart(block)
                .with(center)
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_NORTH, MachineComponentFace.CONNECTED), normal.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_NORTH, MachineComponentFace.CONNECTED_STORAGE), storage.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_NORTH, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_NORTH, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.north())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_EAST, MachineComponentFace.CONNECTED), normal.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_EAST, MachineComponentFace.CONNECTED_STORAGE), storage.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_EAST, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_EAST, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.east())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_SOUTH, MachineComponentFace.CONNECTED), normal.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_SOUTH, MachineComponentFace.CONNECTED_STORAGE), storage.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_SOUTH, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_SOUTH, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.south())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_WEST, MachineComponentFace.CONNECTED), normal.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_WEST, MachineComponentFace.CONNECTED_STORAGE), storage.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_WEST, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_WEST, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.west())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_UP, MachineComponentFace.CONNECTED), normal.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_UP, MachineComponentFace.CONNECTED_STORAGE), storage.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_UP, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_UP, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.up())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_DOWN, MachineComponentFace.CONNECTED), normal.down())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_DOWN, MachineComponentFace.CONNECTED_STORAGE), storage.down())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_DOWN, MachineComponentFace.CONNECTED_BUT_UNSUPPORTED), unsupported.down())
                .with(condition().term(ModBlockStateProperties.MACHINE_COMPONENT_FACE_DOWN, MachineComponentFace.CONNECTED_BUT_CAPACITY_REACHED), capacity.down());
    }


}
