package net.quedoom.giant_potato.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.datagen.lang.QueTLanguageProvider;

import java.util.concurrent.CompletableFuture;

public class GiantPotatoLanguages extends QueTLanguageProvider {
    public GiantPotatoLanguages(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    protected String getNamespace() {
        return GiantPotato.MOD_ID;
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder, QTTranslationBuilder qtTranslationBuilder) {
        qtTranslationBuilder.auto(ModBlocks.TEST_MACHINE_COMPONENT);
        qtTranslationBuilder.auto(ModBlocks.BASIC_MACHINE_CORE);
    }
}
