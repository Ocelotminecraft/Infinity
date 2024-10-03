package net.ocelot.officialocelot.lostinfinitymodern.item.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.ocelot.officialocelot.lostinfinitymodern.item.tools.pickaxes.CelestialMinersPickaxeItem;
import net.ocelot.officialocelot.lostinfinitymodern.item.tools.transformationrods.RodOfDeviationItem;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModToolTiers;

public class RegisterTools {
    public static void register() {
        RegisterCreativeModeTabs.LOST_INFINITY_TOOL_LIST.add(RegisterItems.registerItem("rod_of_deviation", () -> new RodOfDeviationItem(new Item.Properties())));
        RegisterCreativeModeTabs.LOST_INFINITY_TOOL_LIST.add(RegisterItems.registerItem("forgefire_pickaxe", () -> new PickaxeItem(ModToolTiers.FORGEFIRE, 4,-2.8f, new Item.Properties())));
        RegisterCreativeModeTabs.LOST_INFINITY_TOOL_LIST.add(RegisterItems.registerItem("celestial_miners_pickaxe",  () -> new CelestialMinersPickaxeItem(ModToolTiers.CELESTIAL, 2,-2.8f, new Item.Properties())));
    }
}
