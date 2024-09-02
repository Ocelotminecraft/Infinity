package net.ocelot.lostinfinitymodern.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.lostinfinitymodern.LostInfinityModern;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LostInfinityModern.MOD_ID);

    public static final RegistryObject<Item> CELESTIAL_IRON = ITEMS.register("celestial_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_DIAMOND = ITEMS.register("celestial_diamond",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
