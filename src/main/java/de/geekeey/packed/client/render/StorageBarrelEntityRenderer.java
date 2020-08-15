package de.geekeey.packed.client.render;

import de.geekeey.packed.block.entity.VariantStorageBarrelBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class StorageBarrelEntityRenderer extends BlockEntityRenderer<VariantStorageBarrelBlockEntity> {

    public StorageBarrelEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(VariantStorageBarrelBlockEntity entity, float delta, MatrixStack matrices, VertexConsumerProvider vertices, int light, int overlay) {
        var stack = entity.getStack(0);

        if (!stack.isEmpty()) {
            World world = entity.getWorld();
            boolean hasWorld = world != null;

            var state = hasWorld ? entity.getCachedState() : Blocks.BARREL.getDefaultState().with(BarrelBlock.FACING, Direction.SOUTH);

            matrices.push();

            BlockPos pos = entity.getPos();
            Direction direction = state.get(ChestBlock.FACING);
            // normalize
            float facing = direction.asRotation();
            matrices.translate(0.5D, 0.5D, 0.5D);
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-facing));

            // move from center to correct pos
            matrices.translate(0, 0, 0.5 - 1 / 9.0);
            matrices.scale(0.5f, 0.5f, 0.5f);

            // set the light level in front of the block
            var frontLight = WorldRenderer.getLightmapCoordinates(entity.getWorld(), pos.add(direction.getVector()));
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, frontLight, OverlayTexture.DEFAULT_UV, matrices, vertices);

            matrices.pop();
        }
    }
}
