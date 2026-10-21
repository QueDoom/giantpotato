package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.quet.datagen.tag.QueTBlockTagProvider;

import java.util.concurrent.CompletableFuture;

public class GiantPotatoBlockTags extends QueTBlockTagProvider {
    public GiantPotatoBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.BASIC_MACHINE_CORE,

                        ModBlocks.TEST_MACHINE_COMPONENT
                );
    }
}
