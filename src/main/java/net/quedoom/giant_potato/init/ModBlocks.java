package net.quedoom.giant_potato.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.block.BasicMachineCoreBlock;
import net.quedoom.quet.init.QueTBlock;

public class ModBlocks {
    private static final QueTBlock Q = new QueTBlock(GiantPotato.MOD_ID);

    public static final Block BASIC_MACHINE_CORE = Q.register("basic_machine_core", BasicMachineCoreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));


    public static void register( ) { }
}
