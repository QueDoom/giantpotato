package net.quedoom.giant_potato.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.quet.init.QueTCreativeTab;
import org.jspecify.annotations.NonNull;

public class ModCreativeModeTabs {
    private static final QueTCreativeTab Q = new QueTCreativeTab(GiantPotato.MOD_ID);

    public static final ResourceKey<CreativeModeTab> GIANT_BLOCKS_KEY = Q.create("giant_blocks");

    public static final CreativeModeTab GIANT_BLOCKS = Q.register(ModBlocks.BASIC_MACHINE_CORE.asItem(), "giant_blocks", (parameters, output) -> {
        output.accept(ModBlocks.BASIC_MACHINE_CORE);
        output.accept(ModBlocks.TEST_MACHINE_COMPONENT);
    });

    public static void register() {
        QueTCreativeTab.connectEntries(GIANT_BLOCKS, GIANT_BLOCKS_KEY);
    }
}
