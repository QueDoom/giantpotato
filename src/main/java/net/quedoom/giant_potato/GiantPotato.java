package net.quedoom.giant_potato;

import net.fabricmc.api.ModInitializer;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import net.quedoom.giant_potato.api.LoadedMods;
import net.quedoom.giant_potato.init.ModBlockEntities;
import net.quedoom.giant_potato.init.ModBlocks;
import net.quedoom.giant_potato.init.ModCreativeModeTabs;
import net.quedoom.giant_potato.init.ModItems;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class GiantPotato implements ModInitializer {
	public static final String MOD_ID = "giantpotato";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
	public static Component translatable(String suffix, String prefix) {
		return Component.translatable(translationString(suffix, prefix));
	}
	public static String translationString(String prefix, String suffix) {
		return prefix + '.' + MOD_ID + '.' + suffix;
	}

	@Override
	public void onInitialize() {
		LoadedMods.set();
		QTTranslationBuilder.SHOULD_AUTO_TRANSLATE_BY_DEFAULT = true;

		ModItems.register();

		ModBlocks.register();
		ModBlockEntities.register();

		ModCreativeModeTabs.register();
	}
}
