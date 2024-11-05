package net.ocelot.officialocelot.lostinfinitymodern.util.events;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.item.weapons.BladesOfDualityItem;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

@Mod.EventBusSubscriber(modid = LostInfinityModern.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientModEvents {
    private void setup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ItemProperties.register(RegisterItems.ITEM_LIST.get("blades_of_duality").get(),
                    new ResourceLocation(LostInfinityModern.MOD_ID, "mode"), (stack, level, living, id) -> ((stack.getTag() != null) ? (stack.getTag().getString("mode").equals("RED") ? 1.0F : 0.0F) : 0.0F));
        });
    }
}
