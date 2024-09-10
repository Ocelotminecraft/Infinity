package net.ocelot.lostinfinitymodern.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.lostinfinitymodern.LostInfinityModern;

import java.util.ArrayList;

public class DeviantItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LostInfinityModern.MOD_ID);

    public static final String[] DEVIANT_ITEM_NAMES = new String[] {
            "deviant_bat_wing", "deviant_bear_hide", "deviant_beef", "deviant_blaze_rod",
            "deviant_bone", "deviant_bone_meal", "deviant_bottle", "deviant_egg",
            "deviant_ender_pearl", "deviant_fang", "deviant_flesh", "deviant_gel",
            "deviant_ghast_tear", "deviant_globe", "deviant_gold", "deviant_gunpowder",
            "deviant_ink", "deviant_iron", "deviant_magma_cream", "deviant_milk",
            "deviant_mushroom", "deviant_pelt", "deviant_pork_chop", "deviant_saddle",
            "deviant_sand", "deviant_shard", "deviant_shulker_shell", "deviant_skull",
            "deviant_slimeball", "deviant_snowball", "deviant_spider_eye", "deviant_star",
            "deviant_string", "deviant_wheat", "deviant_wing", "deviant_wool",
    };

    public static final ArrayList<RegistryObject<Item>> DEVIANT_ITEMS = new ArrayList<>();

    public static void preregister(IEventBus eventBus) {
        for (String item : DEVIANT_ITEM_NAMES) {
            DEVIANT_ITEMS.add(ITEMS.register(item, () -> new Item(new Item.Properties())));
        }
        register(eventBus);
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
