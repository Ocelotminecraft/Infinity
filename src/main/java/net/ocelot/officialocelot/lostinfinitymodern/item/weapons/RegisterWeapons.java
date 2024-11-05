package net.ocelot.officialocelot.lostinfinitymodern.item.weapons;

import net.minecraft.world.item.Item;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModToolTiers;

public class RegisterWeapons {
    public static void register() {
        RegisterCreativeModeTabs.LOST_INFINITY_WEAPON_LIST.add(RegisterItems.registerItem("blades_of_duality",  () -> new BladesOfDualityItem(ModToolTiers.INFINITY, 2,0.0f, new Item.Properties())));
    }
}
