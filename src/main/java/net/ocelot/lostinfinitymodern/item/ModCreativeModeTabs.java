package net.ocelot.lostinfinitymodern.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.lostinfinitymodern.LostInfinityModern;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostInfinityModern.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY_MATERIALS =
            CREATIVE_MODE_TABS.register("lost_infinity_material_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CelestialItems.CELESTIAL_ITEMS[0].get()))
                    .title(Component.translatable("creativetab.lost_infinity_material_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<Item> item : CelestialItems.CELESTIAL_ITEMS) {
                            pOutput.accept(item.get());
                        }
                        for (RegistryObject<Item> item : DeviantItems.DEVIANT_ITEMS) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
