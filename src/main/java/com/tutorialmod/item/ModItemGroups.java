package com.tutorialmod.item;

import com.tutorialmod.TutorialMod;
import com.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // Creative mode item group for items
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.STARLIGHT_ASHES);
                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.PINK_GARNET_HAMMER);
                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);
                    })
                    .build());

    // Creative mode block group for blocks
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks")) // Sets display name
                    .entries((displayContext, entries) -> { // Where the entries get added
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAP_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);
                        entries.add(ModBlocks.PINK_GARNET_LAMP);
                    })
                    .build());

    public static final ItemGroup VANILLA_ENHANCED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "vanilla_enhanced_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.END_STONE_BRICKS)) //Placeholder TODO replace with another item
                    .displayName(Text.translatable("itemgroup.tutorialmod.vanilla_enhanced_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MAGIC_BLOCK); //TODO replace
                    })
                    .build());

    public static final ItemGroup VANILLA_ENHANCED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "vanilla_enhanced_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENDSTONE_BRICK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.vanilla_enhanced_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDSTONE_BRICK);
                        entries.add(ModItems.IRON_HAMMER_AND_CHISEL);
                        entries.add(ModItems.GOLD_HAMMER_AND_CHISEL);
                        entries.add(ModItems.DIAMOND_HAMMER_AND_CHISEL);
                        entries.add(ModItems.NETHERITE_HAMMER_AND_CHISEL);

                        entries.add(ModItems.ENDSTONE_HELMET);
                        entries.add(ModItems.ENDSTONE_CHESTPLATE);
                        entries.add(ModItems.ENDSTONE_LEGGINGS);
                        entries.add(ModItems.ENDSTONE_BOOTS);

                        entries.add(ModItems.ENDSTONE_SWORD);
                        entries.add(ModItems.ENDSTONE_PICKAXE);
                        entries.add(ModItems.ENDSTONE_AXE);
                        entries.add(ModItems.ENDSTONE_SHOVEL);
                        entries.add(ModItems.ENDSTONE_HOE);
                    })
                    .build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }

}
