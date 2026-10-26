package net.quedoom.giant_potato.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.block.TestMachineComponentBlock;
import net.quedoom.giant_potato.block.BasicMachineCoreBlock;
import net.quedoom.giant_potato.block.abstracts.CableBlock;
import net.quedoom.giant_potato.block.machine.PotatoMachineCore;
import net.quedoom.quet.init.QueTBlock;

public class ModBlocks {
    private static final QueTBlock Q = new QueTBlock(GiantPotato.MOD_ID);

    public static final Block BASIC_MACHINE_CORE = Q.register("basic_machine_core", BasicMachineCoreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final Block TEST_MACHINE_COMPONENT = Q.register("test_machine_component", TestMachineComponentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final Block POTATO_CORE = Q.register("potato_core", PotatoMachineCore::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final Block COPPER_ENERGY_CABLE = Q.register("copper_energy_cable", p -> new CableBlock(p, ModTags.Blocks.ENERGY_CABLES, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).noOcclusion().dynamicShape());
    public static final Block GOLD_ENERGY_CABLE = Q.register("gold_energy_cable", p -> new CableBlock(p, ModTags.Blocks.ENERGY_CABLES, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).noOcclusion().dynamicShape());

    public static void register( ) { }
}
