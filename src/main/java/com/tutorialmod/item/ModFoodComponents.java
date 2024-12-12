package com.tutorialmod.item;

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

}
