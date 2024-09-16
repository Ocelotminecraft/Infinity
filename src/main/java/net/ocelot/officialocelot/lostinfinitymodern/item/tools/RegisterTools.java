package net.ocelot.officialocelot.lostinfinitymodern.item.tools;

import net.minecraft.world.item.Item;
import net.ocelot.officialocelot.lostinfinitymodern.item.tools.transformationrods.RodOfDeviationItem;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

public class RegisterTools {
    public static void register() {
        RegisterCreativeModeTabs.LOST_INFINITY_TOOL_LIST.add(RegisterItems.registerItem("rod_of_deviation", () -> new RodOfDeviationItem(new Item.Properties())));

    }
}
