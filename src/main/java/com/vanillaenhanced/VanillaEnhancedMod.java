package com.vanillaenhanced;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.component.ModDataComponentTypes;
import com.vanillaenhanced.enchantment.ModEnchantmentEffects;
import com.vanillaenhanced.item.ModItemGroups;
import com.vanillaenhanced.item.ModItems;
import com.vanillaenhanced.util.HammerUsageEvent;
import com.vanillaenhanced.util.ModifyExistingLootTables;
import com.vanillaenhanced.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaEnhancedMod implements ModInitializer {
	public static final String MOD_ID = "vanillaenhanced";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems(); //Needed so that items can be added on startup
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		//Modifies loot tables
		ModifyExistingLootTables.modifyLootTables();

		ModWorldGeneration.generateModWorldGen();
		ModEnchantmentEffects.registerEnchantmentEffects();

		//Registers Fuel
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		//Registers hammer usage
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES, 0.15f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.DRIFTWOOD_SAPLING, 0.15f);

		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);
	}
}