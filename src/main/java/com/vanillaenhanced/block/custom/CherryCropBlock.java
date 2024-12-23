package com.vanillaenhanced.block.custom;

import com.vanillaenhanced.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class CherryCropBlock extends CropBlock {

    public static final int MAX_AGE = 1;
    public static final IntProperty AGE = IntProperty.of("age", 0, 7);

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CAULIFLOWER_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public CherryCropBlock(Settings settings) {
        super(settings);
    }

}
