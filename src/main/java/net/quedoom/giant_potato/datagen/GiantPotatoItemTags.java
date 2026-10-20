package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.quet.datagen.tag.QueTItemTagProvider;
import net.quedoom.quet.init.ModRegistrator;

import java.util.concurrent.CompletableFuture;

public class GiantPotatoItemTags extends QueTItemTagProvider {
    public GiantPotatoItemTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected ModRegistrator getRegistrator() {
        return new ModRegistrator(GiantPotato.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

    }
}
