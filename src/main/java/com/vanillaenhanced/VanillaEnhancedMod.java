package com.vanillaenhanced;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.component.ModDataComponentTypes;
import com.vanillaenhanced.enchantment.ModEnchantmentEffects;
import com.vanillaenhanced.item.ModItemGroups;
import com.vanillaenhanced.item.ModItems;
import com.vanillaenhanced.util.*;
import com.vanillaenhanced.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
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

		ModifyExistingLootTables.modifyLootTables(); //Modifies loot tables

		ModWorldGeneration.generateModWorldGen();

		ModEnchantmentEffects.registerEnchantmentEffects();

		CompostingRegistry.registerCompostingChance();

		StrippableBlocksRegistry.registerStrippableBlock();

		FlammableBlocksRegistry.registerFlammableBlocks();

		FuelItemRegistry.registerFuel();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent()); //Registers hammer usage
	}
}