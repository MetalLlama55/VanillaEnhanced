package com.tutorialmod.item.custom;

import com.tutorialmod.block.ModBlocks;
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

public class ChiselItem extends Item {

    // First param is original block, Second param is block it becomes
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK,
            Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock(); //Gets the block that was clicked with its world position

        //if the Map contains the block which was clicked
        if (CHISEL_MAP.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                //Damage the item by 1 durability on the server side updating the durability by 1 on use in the mainhand
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                //Play a sound on use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel.shift_down"));
        } else{
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
