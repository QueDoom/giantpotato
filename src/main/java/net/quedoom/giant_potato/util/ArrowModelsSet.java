package net.quedoom.giant_potato.util;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;
import net.quedoom.giant_potato.init.ModModels;

public record ArrowModelsSet(MultiVariant north, MultiVariant east, MultiVariant south,
                             MultiVariant west, MultiVariant up, MultiVariant down) {

    public static ArrowModelsSet of(ArrowModelTemplatesSet template, TextureMapping mapping, Block block, BlockModelGenerators generators) {
        MultiVariant north = BlockModelGenerators.plainVariant(template.north().create(block, mapping, generators.modelOutput));
        MultiVariant east = BlockModelGenerators.plainVariant(template.east().create(block, mapping, generators.modelOutput));
        MultiVariant south = BlockModelGenerators.plainVariant(template.south().create(block, mapping, generators.modelOutput));
        MultiVariant west = BlockModelGenerators.plainVariant(template.west().create(block, mapping, generators.modelOutput));
        MultiVariant up = BlockModelGenerators.plainVariant(template.up().create(block, mapping, generators.modelOutput));
        MultiVariant down = BlockModelGenerators.plainVariant(template.down().create(block, mapping, generators.modelOutput));
        return new ArrowModelsSet(north, east, south, west, up, down);
    }

}
