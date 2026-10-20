package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.quedoom.quet.datagen.tag.QueTBlockTagProvider;

import java.util.concurrent.CompletableFuture;

public class GiantPotatoBlockTags extends QueTBlockTagProvider {
    public GiantPotatoBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

    }
}
