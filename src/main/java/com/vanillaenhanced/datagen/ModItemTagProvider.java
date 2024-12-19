package com.vanillaenhanced.datagen;

import com.vanillaenhanced.block.ModBlocks;
import com.vanillaenhanced.item.ModItems;
import com.vanillaenhanced.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                ;

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.PINK_GARNET_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PINK_GARNET_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.PINK_GARNET_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_GARNET_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PINK_GARNET_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.DRIFTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS.asItem());


        //Vanilla Enhanced Tags
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ENDSTONE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ENDSTONE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ENDSTONE_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ENDSTONE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ENDSTONE_HOE);


        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDSTONE_HELMET)
                .add(ModItems.ENDSTONE_CHESTPLATE)
                .add(ModItems.ENDSTONE_LEGGINGS)
                .add(ModItems.ENDSTONE_BOOTS);
    }

}
