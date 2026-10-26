package net.quedoom.giant_potato.init;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.quedoom.giant_potato.GiantPotato;
import net.quedoom.giant_potato.block.entity.machine.PotatoMachineCoreEntity;
import net.quedoom.giant_potato.block.entity.machine.TestMachineComponentEntity;
import net.quedoom.quet.init.QueTBlockEntity;

public class ModBlockEntities {
    private static final QueTBlockEntity Q = new QueTBlockEntity(GiantPotato.MOD_ID);

    public static final BlockEntityType<PotatoMachineCoreEntity> POTATO_CORE = Q.register("potato_core", PotatoMachineCoreEntity::new, ModBlocks.POTATO_CORE);

    public static final BlockEntityType<TestMachineComponentEntity> TEST_COMPONENT = Q.register("test_component", TestMachineComponentEntity::new, ModBlocks.TEST_MACHINE_COMPONENT);

    public static void register() {

    }
}
