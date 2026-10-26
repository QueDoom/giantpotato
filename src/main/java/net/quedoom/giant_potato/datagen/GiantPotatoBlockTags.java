package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.giant_potato.init.ModTags;
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

        valueLookupBuilder(ModTags.Blocks.POTATO_COMPONENTS)
                .add(
                        ModBlocks.TEST_MACHINE_COMPONENT
                );

        valueLookupBuilder(ModTags.Blocks.POISONOUS_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.POTATO_COMPONENTS)
                .add(

                );

        valueLookupBuilder(ModTags.Blocks.VICIOUS_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.POISONOUS_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.POTATO_COMPONENTS)
                .add(

                );

        valueLookupBuilder(ModTags.Blocks.STRONG_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.VICIOUS_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.POISONOUS_POTATO_COMPONENTS)
                .addOptionalTag(ModTags.Blocks.POTATO_COMPONENTS)
                .add(

                );
        valueLookupBuilder(ModTags.Blocks.ENERGY_CABLES)
                .add(ModBlocks.COPPER_ENERGY_CABLE)
                .add(ModBlocks.GOLD_ENERGY_CABLE);
    }
}
