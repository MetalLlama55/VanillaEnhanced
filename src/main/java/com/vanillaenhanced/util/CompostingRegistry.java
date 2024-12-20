package com.vanillaenhanced.util;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class CompostingRegistry {

    public static void registerCompostingChance() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES, 0.15f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.DRIFTWOOD_SAPLING, 0.15f);
    }

}
