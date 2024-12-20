package com.vanillaenhanced.util;

import com.vanillaenhanced.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class StrippableBlocksRegistry {

    public static void registerStrippableBlock() {
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
    }

}
