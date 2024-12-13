package com.tutorialmod.block;

import com.tutorialmod.TutorialMod;
import com.tutorialmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //Creates the pink_garnet_block
    public static final Block PINK_GARNET_BLOCK = registerBlock(
            "pink_garnet_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(4f) // Strength o block
                            .requiresTool() // Weather it can be mined with a hand or not
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK) // What sound it will play
            )
    );
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
            )
    );
    //For an ore type block use ExperienceDroppingBlock
    public static final Block PINK_GARNET_ORE = registerBlock(
            "pink_garnet_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .strength(5f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock(
            "pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3,8),
                    AbstractBlock.Settings.create()
                            .strength(6f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)
            )
    );
    public static final Block MAGIC_BLOCK = registerBlock(
            "magic_block",
            new MagicBlock(
                    AbstractBlock.Settings.create()
                            .strength(1f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.FROGSPAWN)
            )
    );
    public static final Block PINK_GARNET_STAIRS = registerBlock(
            "pink_garnet_stairs",
            new StairsBlock(
                    ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_SLAB = registerBlock(
            "pink_garnet_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_BUTTON = registerBlock(
            "pink_garnet_button",
            new ButtonBlock(
                    BlockSetType.IRON, 10,
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .noCollision() //Button has no collision so needs this
            )
    );
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock(
            "pink_garnet_pressure_plate",
            new PressurePlateBlock(
                    BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_FENCE = registerBlock(
            "pink_garnet_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock(
            "pink_garnet_fence_gate",
            new FenceGateBlock(
                    WoodType.ACACIA,
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_WALL = registerBlock(
            "pink_garnet_wall",
            new WallBlock(
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
            )
    );
    public static final Block PINK_GARNET_DOOR = registerBlock(
            "pink_garnet_door",
            new DoorBlock(
                    BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .nonOpaque() //Allows the transparent part of the texture to be visible
            )
    );
    public static final Block PINK_GARNET_TRAP_DOOR = registerBlock(
            "pink_garnet_trapdoor",
            new TrapdoorBlock(
                    BlockSetType.IRON,
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .nonOpaque() //Allows the transparent part of the texture to be visible
            )
    );


    //Registers the block
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    //Registers the block as an item
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    //Called in the OnInitialized in TutorialMod.java class
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        //Add custom blocks to existing creative tab group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });

    }

}
