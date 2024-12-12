package com.tutorialmod.datagen;

import com.tutorialmod.block.ModBlocks;
import com.tutorialmod.item.ModItems;
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

        ///Allows for recipies like diamond block to 9 diamonds and the reverse
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);

        //Creates shaped recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("  G")
                .pattern(" G ")
                .pattern("S  ")
                .input('G', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        //Creates shapeless recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK, 1)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
    }

}
