package com.vanillaenhanced.util;

import com.vanillaenhanced.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 15), //Price
                            new ItemStack(ModItems.PINK_GARNET_SWORD, 1), //Item Obtained
                            2, //Max uses
                            5,  //Experience Earned
                            0.05f //Price Multiplier
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.SAPPHIRE, 1),
                            new ItemStack(Items.EMERALD, 1),
                            5,
                            5,
                            0.05f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ModItems.SAPPHIRE, 1),
                            5,
                            5,
                            0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.CAULIFLOWER, 15),
                            new ItemStack(Items.EMERALD, 1),
                            10,
                            5,
                            0.05f
                    ));
                });

        TradeOfferHelper.registerWanderingTraderOffers(3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 3),
                            new ItemStack(ModItems.PINK_GARNET, 1),
                            3,
                            10,
                            0.10f
                    ));
                });
        TradeOfferHelper.registerWanderingTraderOffers(3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(ModItems.SAPPHIRE, 1),
                            3,
                            10,
                            0.10f
                    ));
                });
    }

}
