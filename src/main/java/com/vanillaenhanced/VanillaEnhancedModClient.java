package com.vanillaenhanced;

import com.vanillaenhanced.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class VanillaEnhancedModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //Makes the cutout see-through
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CAULIFLOWER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HONEY_BERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRIFTWOOD_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHERRY_SAPLING);
    }

}
