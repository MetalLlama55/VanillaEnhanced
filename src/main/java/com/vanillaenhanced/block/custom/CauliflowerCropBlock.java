package com.vanillaenhanced.block.custom;

import com.vanillaenhanced.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

import javax.swing.text.html.BlockView;

public class CauliflowerCropBlock extends CropBlock {

    public static final int MAX_AGE = 7;
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

    public CauliflowerCropBlock(Settings settings) {
        super(settings);
    }

}
