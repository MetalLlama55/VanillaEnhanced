package com.vanillaenhanced.world.gen;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        //Make sure they are ordered by generation step
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModBushGeneration.generateBushes();


    }

}
