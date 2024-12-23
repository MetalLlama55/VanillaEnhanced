package com.vanillaenhanced.world.gen;

import com.vanillaenhanced.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushGeneration {

    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.PLAINS,
                BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.HONEY_BERRY_BUSH_PLACED_KEY);
    }

}
