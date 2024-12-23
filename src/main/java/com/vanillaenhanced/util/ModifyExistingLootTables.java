package com.vanillaenhanced.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModifyExistingLootTables {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && (EntityType.SHEEP.getLootTableId().equals(registryKey))) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Items.EGG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                builder.pool(poolBuilder.build());
            }
        }));
    }

}
