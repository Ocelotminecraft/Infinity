package net.ocelot.officialocelot.lostinfinitymodern.registration;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

import java.util.HashMap;
import java.util.function.Supplier;

public class RegisterItems {
    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, LostInfinityModern.MOD_ID);

    public static final HashMap<String, RegistryObject<Item>> ITEM_LIST = new HashMap<>();
    public static final HashMap<String, RegistryObject<Item>> BLOCK_ITEM_LIST = new HashMap<>();

    public static final RegistryObject<Item> DEFAULT_ITEM = ITEM_DEFERRED_REGISTER.register("useless_item", () -> new Item(new Item.Properties()));

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> item = ITEM_DEFERRED_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        BLOCK_ITEM_LIST.put(name, item);
        ITEM_LIST.put(name, item);
        return item;
    }

    public static RegistryObject<Item> registerItem(String name, Supplier<Item> properties) {
        RegistryObject<Item> item = ITEM_DEFERRED_REGISTER.register(name, properties);
        ITEM_LIST.put(name, item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEM_DEFERRED_REGISTER.register(eventBus);
    }
}
