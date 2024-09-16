package net.ocelot.officialocelot.lostinfinitymodern;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.ocelot.officialocelot.lostinfinitymodern.block.RegisterCommonBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.item.RegisterMaterials;
import net.ocelot.officialocelot.lostinfinitymodern.item.tools.RegisterTools;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LostInfinityModern.MOD_ID)
public class LostInfinityModern
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "lost_infinity_modern";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LostInfinityModern()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Block Preregistration
        RegisterCommonBlocks.register();

        // Item Preregistration
        RegisterMaterials.register();
        RegisterTools.register();

        // Creative Tab Registration
        RegisterCreativeModeTabs.register(modEventBus);

        // Register Blocks
        RegisterBlocks.register(modEventBus);

        // Register Items
        RegisterItems.register(modEventBus);



        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
