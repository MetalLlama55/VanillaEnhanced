package com.vanillaenhanced.item.custom;

import com.vanillaenhanced.block.ModBlocks;
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

public class KnifeItem extends Item {

    // First param is original block, Second param is block it becomes
    private static final Map<Block, Block> KNIFE_MAP = Map.of(
            Blocks.CACTUS, ModBlocks.CUT_CACTUS_BLOCK
    );

    public KnifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock(); //Gets the block that was clicked with its world position

        //if the Map contains the block which was clicked
        if (KNIFE_MAP.containsKey(clickedBlock)) {
            //If the world is the server and not the client
            if (!world.isClient()) {
                //Set the block state based on the block position and Map
                world.setBlockState(context.getBlockPos(), KNIFE_MAP.get(clickedBlock).getDefaultState());

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
            tooltip.add(Text.translatable("tooltip.vanillaenhanced.knife.shift_down"));
        } else{
            tooltip.add(Text.translatable("tooltip.vanillaenhanced.knife"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
