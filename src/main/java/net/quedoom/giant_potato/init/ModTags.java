package net.quedoom.giant_potato.init;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.quet.init.QueTTag;

public class ModTags {
    private static final QueTTag BUILDER = QueTTag.builder(GiantPotato.MOD_ID);


    public static class Items {
        private static final QueTTag.QTItemTags Q = BUILDER.item();
    }
    public static class Blocks {
        private static final QueTTag.QTBlockTags Q = BUILDER.block();

        public static final TagKey<Block> POTATO_COMPONENTS = Q.create("potato_components");
        public static final TagKey<Block> POISONOUS_POTATO_COMPONENTS = Q.create("poisonous_potato_components");
        public static final TagKey<Block> VICIOUS_POTATO_COMPONENTS = Q.create("vicious_potato_components");
        public static final TagKey<Block> STRONG_POTATO_COMPONENTS = Q.create("strong_potato_components");

        public static final TagKey<Block> ENERGY_CABLES = Q.create("energy_cables");
    }
}
