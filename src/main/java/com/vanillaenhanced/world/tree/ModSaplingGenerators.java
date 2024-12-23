package com.vanillaenhanced.world.tree;

import com.vanillaenhanced.VanillaEnhancedMod;
import com.vanillaenhanced.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {

    //Assigns the key to the sapling
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(
            VanillaEnhancedMod.MOD_ID + ":driftwood",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY),
            Optional.empty()
            );

    public static final SaplingGenerator CHERRY = new SaplingGenerator(
            VanillaEnhancedMod.MOD_ID + ":cherry",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.CHERRY_KEY),
            Optional.empty()
            );

}
