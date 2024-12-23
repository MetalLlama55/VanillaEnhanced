package com.vanillaenhanced.item.custom;

import com.vanillaenhanced.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class HammerAndChiselItem extends Item {

    // First param is original block, Second param is block it becomes
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_1 = Map.of(
            Blocks.OAK_PLANKS, Blocks.OAK_SLAB,
            Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB,
            Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB,
            Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB,
            Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB,
            Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB,
            Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB,
            Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB,
            Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB,
            Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB
    );
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_2 = Map.of(
            Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB,
            Blocks.BAMBOO_MOSAIC, Blocks.BAMBOO_MOSAIC_SLAB,
            Blocks.STONE, Blocks.STONE_SLAB,
            Blocks.COBBLESTONE, Blocks.COBBLESTONE_SLAB,
            Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE_SLAB,
            Blocks.SMOOTH_STONE, Blocks.SMOOTH_STONE_SLAB,
            Blocks.STONE_BRICKS, Blocks.STONE_BRICK_SLAB,
            Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICK_SLAB,
            Blocks.GRANITE, Blocks.GRANITE_SLAB,
            Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE_SLAB
    );
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_3 = Map.of(
            Blocks.DIORITE, Blocks.DIORITE_SLAB,
            Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE_SLAB,
            Blocks.ANDESITE, Blocks.ANDESITE_SLAB,
            Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE_SLAB,
            Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_SLAB,
            Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_SLAB,
            Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_SLAB,
            Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_SLAB,
            Blocks.TUFF, Blocks.TUFF_SLAB,
            Blocks.POLISHED_TUFF, Blocks.POLISHED_TUFF_SLAB
    );
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_4 = Map.of(
            Blocks.TUFF_BRICKS, Blocks.TUFF_BRICK_SLAB,
            Blocks.BRICKS, Blocks.BRICK_SLAB,
            Blocks.MUD_BRICKS, Blocks.MUD_BRICK_SLAB,
            Blocks.SANDSTONE, Blocks.SANDSTONE_SLAB,
            Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_SANDSTONE_SLAB,
            Blocks.CUT_SANDSTONE, Blocks.CUT_SANDSTONE_SLAB,
            Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE_SLAB,
            Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE_SLAB,
            Blocks.CUT_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE_SLAB,
            Blocks.PRISMARINE, Blocks.PRISMARINE_SLAB
    );
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_5 = Map.of(
            Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICK_SLAB,
            Blocks.DARK_PRISMARINE, Blocks.DARK_PRISMARINE_SLAB,
            Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_SLAB,
            Blocks.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICK_SLAB,
            Blocks.BLACKSTONE, Blocks.BLACKSTONE_SLAB,
            Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_SLAB,
            Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB,
            Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_SLAB,
            Blocks.PURPUR_BLOCK, Blocks.PURPUR_SLAB,
            Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_SLAB
    );
    private static final Map<Block, Block> HAMMER_AND_CHISEL_MAP_6 = Map.of(
            Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_QUARTZ_SLAB,
            Blocks.CUT_COPPER, Blocks.CUT_COPPER_SLAB,
            Blocks.EXPOSED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER_SLAB,
            Blocks.OXIDIZED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER_SLAB,
            Blocks.WAXED_CUT_COPPER, Blocks.WAXED_CUT_COPPER_SLAB,
            Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
            Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
            Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
            Blocks.WEATHERED_CUT_COPPER, Blocks.WAXED_CUT_COPPER_SLAB
    );


    public HammerAndChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock(); //Gets the block that was clicked with its world position

        //if the Map contains the block which was clicked
        if (HAMMER_AND_CHISEL_MAP_1.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_1.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }if (HAMMER_AND_CHISEL_MAP_2.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_2.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }if (HAMMER_AND_CHISEL_MAP_3.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_3.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }if (HAMMER_AND_CHISEL_MAP_4.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_4.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }if (HAMMER_AND_CHISEL_MAP_5.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_5.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }if (HAMMER_AND_CHISEL_MAP_6.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), HAMMER_AND_CHISEL_MAP_6.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.vanillaenhanced.hammer_and_chisel.shift_down"));
        } else{
            tooltip.add(Text.translatable("tooltip.vanillaenhanced.hammer_and_chisel"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
