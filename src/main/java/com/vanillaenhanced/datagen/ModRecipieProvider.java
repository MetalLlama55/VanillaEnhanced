package com.vanillaenhanced.datagen;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipieProvider extends FabricRecipeProvider {

    public ModRecipieProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        //List of items that should smelt into pink_garnet
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(
                ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        //Generates smelting recipes for the list PINK_GARNET_SMELTABLES
        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        ///Allows for recipes like diamond block to 9 diamonds and the reverse
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);

        //Creates shaped recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("   ")
                .pattern(" G ")
                .pattern("S  ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        //Creates shapeless recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK, 1)
                .input(Items.DIAMOND_BLOCK)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .input(Items.GOLD_INGOT)
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);


        //Pink Garnet Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD)
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                .pattern(" GG")
                .pattern(" SG")
                .pattern(" S ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                .pattern(" GG")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER)
                .pattern("GG ")
                .pattern("GGS")
                .pattern("GG ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);


        //Pink Garnet Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_HELMET)
                .pattern("GGG")
                .pattern("GHG")
                .pattern("   ")
                .input('G', ModItems.PINK_GARNET)
                .input('H', Items.IRON_HELMET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_CHESTPLATE)
                .pattern("GIG")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .input('I', Items.IRON_CHESTPLATE)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_LEGGINGS)
                .pattern("GGG")
                .pattern("GIG")
                .pattern("G G")
                .input('G', ModItems.PINK_GARNET)
                .input('I', Items.IRON_LEGGINGS)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_BOOTS)
                .pattern("   ")
                .pattern("G G")
                .pattern("GIG")
                .input('G', ModItems.PINK_GARNET)
                .input('I', Items.IRON_BOOTS)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);


        //Pink Garnet Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_STAIRS, 4)
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("GG ")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_FENCE, 6)
                .pattern("   ")
                .pattern("GSG")
                .pattern("GSG")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("SGS")
                .pattern("SGS")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_DOOR, 3)
                .pattern("GG ")
                .pattern("GG ")
                .pattern("GG ")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_TRAP_DOOR, 2)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_BUTTON, 1)
                .input(ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, 6)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_LAMP, 1)
                .pattern("GGG")
                .pattern("GLG")
                .pattern("GGG")
                .input('G', ModItems.PINK_GARNET)
                .input('L', Items.REDSTONE_LAMP)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);


        //Vanilla Enhanced Recipes
        List<ItemConvertible> ENDSTONE_SMELTABLES = List.of(
                Items.END_STONE);
        List<ItemConvertible> CACTUS_SMELTABLES = List.of(
                ModItems.CACTUS_FRUIT);


        offerSmelting(recipeExporter, ENDSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDSTONE_BRICK, 0.15f, 400, "endstone");
        offerSmelting(recipeExporter, CACTUS_SMELTABLES, RecipeCategory.MISC, ModItems.COOKED_CACTUS_FRUIT, 0.25f, 200, "cactus");
        offerBlasting(recipeExporter, ENDSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDSTONE_BRICK, 0.15f, 200, "endstone");

        offerNetheriteUpgradeRecipe(recipeExporter, ModItems.DIAMOND_HAMMER_AND_CHISEL, RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER_AND_CHISEL);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHERRY, 5)
                .input(ModBlocks.CHERRY_LEAVES_CROP)
                .input(ModItems.PRUNING_SHEARS)
                .criterion(hasItem(ModItems.PRUNING_SHEARS), conditionsFromItem(ModItems.PRUNING_SHEARS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.KNIFE)
                .pattern(" I ")
                .pattern(" SI")
                .pattern(" S ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRUNING_SHEARS)
                .pattern("I I")
                .pattern(" S ")
                .pattern("S S")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.IRON_HAMMER_AND_CHISEL)
                .pattern("   ")
                .pattern(" I ")
                .pattern(" S ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GOLD_HAMMER_AND_CHISEL)
                .pattern("   ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', Items.GOLD_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER_AND_CHISEL)
                .pattern("   ")
                .pattern(" D ")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDSTONE_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ENDSTONE_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ENDSTONE_AXE)
                .pattern(" BB")
                .pattern(" SB")
                .pattern(" S ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ENDSTONE_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ENDSTONE_HOE)
                .pattern(" BB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDSTONE_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.ENDSTONE_BRICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDSTONE_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.ENDSTONE_BRICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDSTONE_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.ENDSTONE_BRICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDSTONE_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.ENDSTONE_BRICK)
                .criterion(hasItem(ModItems.ENDSTONE_BRICK), conditionsFromItem(ModItems.ENDSTONE_BRICK))
                .offerTo(recipeExporter);

    }

}
