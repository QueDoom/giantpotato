package net.quedoom.giant_potato.init;

import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.quet.init.QueTTag;

public class ModTags {
    private static final QueTTag BUILDER = QueTTag.builder(GiantPotato.MOD_ID);


    public static class Items {
        private static final QueTTag.QTItemTags Q = BUILDER.item();
    }
    public static class Blocks {
        private static final QueTTag.QTBlockTags Q = BUILDER.block();
    }
}
