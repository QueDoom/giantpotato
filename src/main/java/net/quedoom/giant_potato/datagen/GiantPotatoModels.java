package net.quedoom.giant_potato.datagen;

import com.mojang.math.Quadrant;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.block.abstracts.AbstractMachineComponentBlock;
import net.quedoom.giant_potato.block.abstracts.CableBlock;
import net.quedoom.giant_potato.init.ModBlockStateProperties;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.giant_potato.init.ModItems;
import net.quedoom.giant_potato.init.ModModels;
import net.quedoom.giant_potato.util.ArrowModelTemplatesSet;
import net.quedoom.giant_potato.util.ArrowModelsSet;
import net.quedoom.giant_potato.util.MachineComponentFace;
import net.quedoom.giant_potato.util.MachineCoreFace;
import net.quedoom.giant_potato.util.pipecable.PipeStates;
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
        qtItemModelGenerators.generate(ModItems.TILLER, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators, QTBlockModelGenerators qtBlockModelGenerators) {
        machineCasing(blockModelGenerators, ModBlocks.BASIC_MACHINE_CORE);
        machineCasing(blockModelGenerators, ModBlocks.POTATO_CORE);
        machineComponent(blockModelGenerators, ModBlocks.TEST_MACHINE_COMPONENT);

        energyCableWithBlackWool(blockModelGenerators, ModBlocks.GOLD_ENERGY_CABLE);
        energyCableWithBlackWool(blockModelGenerators, ModBlocks.COPPER_ENERGY_CABLE);
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
            Identifier centerId = ModModels.MACHINE_COMPONENT_ON.create(block, ModModels.TextureMappings.componentOn(block), generators.modelOutput);
        MultiVariant centerOn = BlockModelGenerators.plainVariant(centerId);
        MultiVariant centerOff = BlockModelGenerators.plainVariant(ModModels.MACHINE_COMPONENT_OFF.create(block, ModModels.TextureMappings.componentOff(block), generators.modelOutput));
        ArrowModelsSet normal = ArrowModelsSet.of(ArrowModelTemplatesSet.normalArrow(), ModModels.TextureMappings.arrows(block), block, generators);
        ArrowModelsSet storage = ArrowModelsSet.of(ArrowModelTemplatesSet.storageArrow(), ModModels.TextureMappings.storageArrows(block), block, generators);
        ArrowModelsSet capacity = ArrowModelsSet.of(ArrowModelTemplatesSet.capacityArrow(), ModModels.TextureMappings.capacityReachedArrows(block), block, generators);
        ArrowModelsSet unsupported = ArrowModelsSet.of(ArrowModelTemplatesSet.unsupportedArrow(), ModModels.TextureMappings.unsupportedArrows(block), block, generators);
        Identifier inventory = ModModels.MACHINE_COMPONENT_ITEM.create(block.asItem(), ModModels.TextureMappings.componentOn(block), generators.modelOutput);
        generators.blockStateOutput.accept(createMachineComponentBlockstate(block, centerOn, centerOff, normal, storage, unsupported, capacity));
        generators.registerSimpleItemModel(block, inventory);
    }

    private static BlockModelDefinitionGenerator createMachineComponentBlockstate(
            Block block, MultiVariant centerOn, MultiVariant centerOff,
            ArrowModelsSet normal, ArrowModelsSet storage, ArrowModelsSet unsupported, ArrowModelsSet capacity) {
        return MultiPartGenerator.multiPart(block)
                .with(condition().term(AbstractMachineComponentBlock.ON, true), centerOn)
                .with(condition().term(AbstractMachineComponentBlock.ON, false), centerOff)
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

    public void energyCable(BlockModelGenerators generators, final Block block) {
        cable(generators, block, ModModels.TextureMappings.cable(block));
    }

    public void energyCableWithBlackWool(BlockModelGenerators generators, final Block block) {
        cable(generators, block, ModModels.TextureMappings.cableBlackWool(block));
    }

    private void cable(BlockModelGenerators generators, Block block, TextureMapping textures) {
        Identifier center = ModModels.ENERGY_CABLE_CENTER.create(block, textures, generators.modelOutput);
        Identifier bit = ModModels.ENERGY_CABLE_BIT.create(block, textures, generators.modelOutput);
        Identifier bitOutput = ModModels.ENERGY_CABLE_BIT_OUTPUT.create(block, textures, generators.modelOutput);
        Identifier inventory = ModModels.ENERGY_CABLE_INVENTORY.create(block.asItem(), textures, generators.modelOutput);
        generators.blockStateOutput.accept(energyCableBlockstate(block, center, bit, bitOutput));
        generators.registerSimpleItemModel(block, inventory);
    }

    private static BlockModelDefinitionGenerator energyCableBlockstate(
            Block block, Identifier center, Identifier bit, Identifier bitOutput) {

        MultiPartGenerator gen = MultiPartGenerator.multiPart(block)
                .with(BlockModelGenerators.plainVariant(center));

        addSide(gen, CableBlock.NORTH, bit, bitOutput, VariantMutator.Y_ROT.withValue(Quadrant.R0));
        addSide(gen, CableBlock.EAST,  bit, bitOutput, VariantMutator.Y_ROT.withValue(Quadrant.R90));
        addSide(gen, CableBlock.SOUTH, bit, bitOutput, VariantMutator.Y_ROT.withValue(Quadrant.R180));
        addSide(gen, CableBlock.WEST,  bit, bitOutput, VariantMutator.Y_ROT.withValue(Quadrant.R270));
        addSide(gen, CableBlock.UP,    bit, bitOutput, VariantMutator.X_ROT.withValue(Quadrant.R270));
        addSide(gen, CableBlock.DOWN,  bit, bitOutput, VariantMutator.X_ROT.withValue(Quadrant.R90));
        return gen;
    }

    private static void addSide(MultiPartGenerator gen, EnumProperty<PipeStates> prop,
                                Identifier bit, Identifier out, VariantMutator rot) {
        gen.with(BlockModelGenerators.condition().term(prop, PipeStates.CONNECTED),
                BlockModelGenerators.plainVariant(bit).with(rot));
        gen.with(BlockModelGenerators.condition().term(prop, PipeStates.INPUT),
                BlockModelGenerators.plainVariant(bit).with(rot));
        gen.with(BlockModelGenerators.condition().term(prop, PipeStates.OUTPUT),
                BlockModelGenerators.plainVariant(out).with(rot));
    }


}
