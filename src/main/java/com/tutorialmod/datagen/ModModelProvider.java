package com.tutorialmod.datagen;

import com.tutorialmod.block.ModBlocks;
import com.tutorialmod.block.custom.PinkGarnetLampBlock;
import com.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        //Pink Garnet Blocks
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAP_DOOR);

        //Changes the lamp model based on if it is on or off
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_BOOTS);


        //Vanilla Enhanced Item Models
        itemModelGenerator.register(ModItems.ENDSTONE_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_HAMMER_AND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_HAMMER_AND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER_AND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_HAMMER_AND_CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDSTONE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDSTONE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDSTONE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDSTONE_BOOTS);
    }

}
