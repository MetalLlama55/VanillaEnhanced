package com.tutorialmod.item;

import com.tutorialmod.TutorialMod;
import com.tutorialmod.item.custom.ChiselItem;
import com.tutorialmod.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems { //Class needed to register new items, must be in item folder

   //To add new items use same syntax
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings())); //Adds the pink_garnet item to the game
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    //Pink Garnet Tools
    public static final Item PINK_GARNET_SWORD = registerItem(
            "pink_garnet_sword",
            new SwordItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 5, -2.5f))));
    public static final Item PINK_GARNET_PICKAXE = registerItem(
            "pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.0f))));
    public static final Item PINK_GARNET_AXE = registerItem(
            "pink_garnet_axe",
            new AxeItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6, -3.0f))));
    public static final Item PINK_GARNET_SHOVEL = registerItem(
            "pink_garnet_shovel",
            new ShovelItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1, -2.0f))));
    public static final Item PINK_GARNET_HOE = registerItem(
            "pink_garnet_hoe",
            new HoeItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1, -1.5f))));
    public static final Item PINK_GARNET_HAMMER = registerItem(
            "pink_garnet_hammer",
            new HammerItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 7, 3.5f))));

    //Pink Garnet Armor
    public static final Item PINK_GARNET_HELMET = registerItem(
            "pink_garnet_helmet",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem(
            "pink_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem(
            "pink_garnet_leggings",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PINK_GARNET_BOOTS =registerItem(
            "pink_garnet_boots",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    //Helper method for registering items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID); ///Debug Log

        //Add items to creative tab group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET); //Adds pink_garnet to creative tab INGREDIENTS
            entries.add(RAW_PINK_GARNET);
        });
    }

}
