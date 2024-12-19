package com.vanillaenhanced.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    //How to make a custom food item
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200), 0.15f)
            .alwaysEdible()
            .build();

    public static final FoodComponent CACTUS_FRUIT = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.5f)
            .build();

    public static final FoodComponent COOKED_CACTUS_FRUIT = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(1.0f)
            .build();

    public static final FoodComponent HONEY_BERRY = new FoodComponent.Builder()
            .nutrition(1)
            .saturationModifier(0.15f)
            .snack()
            .build();

}
