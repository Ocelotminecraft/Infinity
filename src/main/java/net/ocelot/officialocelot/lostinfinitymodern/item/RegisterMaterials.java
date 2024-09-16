package net.ocelot.officialocelot.lostinfinitymodern.item;

import net.minecraft.world.item.Item;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

public class RegisterMaterials {

    public static final String[] ITEM_NAMES = new String[] {
            "deviant_bat_wing", "deviant_bear_hide", "deviant_beef", "deviant_blaze_rod",
            "deviant_bone", "deviant_bone_meal", "deviant_bottle", "deviant_egg",
            "deviant_ender_pearl", "deviant_fang", "deviant_flesh", "deviant_gel",
            "deviant_ghast_tear", "deviant_globe", "deviant_gold", "deviant_gunpowder",
            "deviant_ink", "deviant_iron", "deviant_magma_cream", "deviant_milk",
            "deviant_mushroom", "deviant_pelt", "deviant_pork_chop", "deviant_saddle",
            "deviant_sand", "deviant_shard", "deviant_shulker_shell", "deviant_skull",
            "deviant_slimeball", "deviant_snowball", "deviant_spider_eye", "deviant_star",
            "deviant_string", "deviant_wheat", "deviant_wing", "deviant_wool", "celestial_iron",
            "celestial_diamond", "celestial_redstone", "celestial_quartz", "celestial_emerald",
    };

    public static void register() {
        for(String name: ITEM_NAMES) {
            RegisterCreativeModeTabs.LOST_INFINITY_MATERIAL_LIST.add(RegisterItems.registerItem(name, () -> new Item(new Item.Properties())));
        }
    }
}
