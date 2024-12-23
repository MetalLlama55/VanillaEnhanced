package com.vanillaenhanced.datagen;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.block.custom.CauliflowerCropBlock;
import com.vanillaenhanced.block.custom.CherryCropBlock;
import com.vanillaenhanced.block.custom.HoneyBerryBushBlock;
import com.vanillaenhanced.block.custom.PinkGarnetLampBlock;
import com.vanillaenhanced.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_END_ORE);

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

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        //Register model for logs and wood
        blockStateModelGenerator.registerLog(ModBlocks.DRIFTWOOD_LOG).log(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DRIFTWOOD_LOG).log(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Bush Block
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(
                ModBlocks.HONEY_BERRY_BUSH,
                BlockStateModelGenerator.TintType.NOT_TINTED,
                HoneyBerryBushBlock.AGE, 0, 1, 2, 3);

        //Changes the lamp model based on if it is on or off
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));


        //Vanilla Enhanced Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUT_CACTUS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHERRY_LEAVES_CROP);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CHERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DRIFTWOOD_SAPLING.asItem(), Models.GENERATED);

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
        itemModelGenerator.register(ModItems.KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_CACTUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHERRY_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.PRUNING_SHEARS, Models.GENERATED);


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
