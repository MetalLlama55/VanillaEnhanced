package com.tutorialmod;

import com.tutorialmod.block.ModBlocks;
import com.tutorialmod.component.ModDataComponentTypes;
import com.tutorialmod.item.ModItemGroups;
import com.tutorialmod.item.ModItems;
import com.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<PlacedFeature> PINK_GARNET_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("tutorialmod", "pink_garnet_ore"));
	public static final RegistryKey<PlacedFeature> MEDIUM_PINK_GARNET_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("tutorialmod", "medium_pink_garnet_ore"));
	public static final RegistryKey<PlacedFeature> LARGE_PINK_GARNET_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("tutorialmod", "large_pink_garnet_ore"));

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems(); //Needed so that items can be added on startup
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		//Registers Fuel
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		//Registers hammer usage
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		//Adds the ore spawns on world creation and startup
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PINK_GARNET_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MEDIUM_PINK_GARNET_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, LARGE_PINK_GARNET_ORE_PLACED_KEY);
	}
}