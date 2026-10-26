package net.quedoom.giant_potato.init;

import net.minecraft.world.item.Item;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.datagen.lang.QueTLanguageProvider;
import net.quedoom.quet.init.QueTItem;

public class ModItems {
    private static final QueTItem Q = new QueTItem(GiantPotato.MOD_ID);

    public static final Item TILLER = Q.register("tiller", new Item.Properties().durability(200));

    public static void register() {
    }
}
