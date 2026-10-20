package net.quedoom.giant_potato;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.quedoom.giant_potato.datagen.*;
import net.quedoom.quet.datagen.QTRegistryBuilder;
import net.quedoom.quet.datagen.QueTDataGeneratorEntrypoint;

public class GiantPotatoDataGenerator extends QueTDataGeneratorEntrypoint {
	@Override
	protected void doDatagen(FabricDataGenerator fabricDataGenerator, FabricDataGenerator.Pack pack) {
		pack.addProvider(GiantPotatoBlockTags::new);
		pack.addProvider(GiantPotatoItemTags::new);
		pack.addProvider(GiantPotatoLanguages::new);
		pack.addProvider(GiantPotatoModels::new);
		pack.addProvider(GiantPotatoLootTables::new);
	}

	@Override
	protected void buildRegistry(QTRegistryBuilder qtRegistryBuilder) {
	}
}
