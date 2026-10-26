package net.quedoom.giant_potato.util;

import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record MachineCoreSettings(int machineTier, List<Direction> forbiddenSides, TagKey<Block> acceptsComponents) {
    public static Builder builder(TagKey<Block> acceptsComponents, int machineTier) {
        return new Builder(acceptsComponents, machineTier);
    }

    public static class Builder {
        private final int machineTier;
        private final TagKey<Block> acceptsComponents;

        private final List<Direction> forbiddenSides = new ArrayList<>();

        public Builder forbidSide(Direction direction) {
            forbiddenSides.add(direction);
            return this;
        }
        public Builder forbidSides(Direction... directions) {
            forbiddenSides.addAll(Arrays.asList(directions));
            return this;
        }
        public Builder forbidSides(List<Direction> directions) {
            forbiddenSides.addAll(directions);
            return this;
        }

        private Builder(TagKey<Block> acceptsComponents, int machineTier) {
            this.acceptsComponents = acceptsComponents;
            this.machineTier = machineTier;
        }

        public MachineCoreSettings build() {
            return new MachineCoreSettings(machineTier, forbiddenSides, acceptsComponents);
        }

    }
}
