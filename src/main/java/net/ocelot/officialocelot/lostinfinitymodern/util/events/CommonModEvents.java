package net.ocelot.officialocelot.lostinfinitymodern.util.events;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.util.networking.ModPacketHandler;

@Mod.EventBusSubscriber(modid = LostInfinityModern.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonModEvents {
    @SubscribeEvent
    public static void common_setup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModPacketHandler::register);
    }
}
