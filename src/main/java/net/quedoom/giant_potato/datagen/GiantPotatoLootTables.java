package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.quet.datagen.QueTBlockStateLootProvider;

import java.util.concurrent.CompletableFuture;

public class GiantPotatoLootTables extends QueTBlockStateLootProvider {
    public GiantPotatoLootTables(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.BASIC_MACHINE_CORE);
        dropSelf(ModBlocks.TEST_MACHINE_COMPONENT);
    }
}
