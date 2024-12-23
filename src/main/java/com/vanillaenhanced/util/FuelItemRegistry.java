package com.vanillaenhanced.util;

import com.vanillaenhanced.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelItemRegistry {

    public static void registerFuel() {
        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);
    }

}
