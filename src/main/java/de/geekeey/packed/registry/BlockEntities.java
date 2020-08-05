package de.geekeey.packed.registry;

import de.geekeey.packed.initialisers.Initializer;
import de.geekeey.packed.block.entity.TestContainerEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static final BlockEntityType<TestContainerEntity> TEST_CONTAINER_ENTITY;

    static {
        TEST_CONTAINER_ENTITY = BlockEntityType.Builder.create(TestContainerEntity::new, Blocks.TEST_CONTAINER).build(null);
    }

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Initializer.id("test_container"), TEST_CONTAINER_ENTITY);
    }
}