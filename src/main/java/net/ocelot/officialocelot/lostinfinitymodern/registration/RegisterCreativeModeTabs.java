package net.ocelot.officialocelot.lostinfinitymodern.registration;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

import java.util.ArrayList;

public class RegisterCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> LOST_INFINITY_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostInfinityModern.MOD_ID);

    public static final ArrayList<RegistryObject<? extends Item>> LOST_INFINITY_MATERIAL_LIST = new ArrayList<>();
    public static final ArrayList<RegistryObject<? extends Item>> LOST_INFINITY_BLOCK_LIST = new ArrayList<>();
    public static final ArrayList<RegistryObject<? extends Item>> LOST_INFINITY_TOOL_LIST = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY_MATERIALS =
            LOST_INFINITY_TABS.register("material_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RegisterItems.ITEM_LIST.get("celestial_iron").get()))
                    .title(Component.translatable("itemGroup." + LostInfinityModern.MOD_ID + ".materials"))
                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<? extends Item> item : LOST_INFINITY_MATERIAL_LIST) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY_BLOCKS =
            LOST_INFINITY_TABS.register("block_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RegisterItems.ITEM_LIST.get("astrorock").get()))
                    .title(Component.translatable("itemGroup." + LostInfinityModern.MOD_ID + ".blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<? extends Item> item : LOST_INFINITY_BLOCK_LIST) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY_TOOLS =
            LOST_INFINITY_TABS.register("tool_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RegisterItems.ITEM_LIST.get("rod_of_deviation").get()))
                    .title(Component.translatable("itemGroup." + LostInfinityModern.MOD_ID + ".tools"))
                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<? extends Item> item : LOST_INFINITY_TOOL_LIST) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        LOST_INFINITY_TABS.register(eventBus);
    }
}