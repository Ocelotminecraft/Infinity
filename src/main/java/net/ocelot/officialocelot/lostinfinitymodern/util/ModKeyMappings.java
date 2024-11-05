package net.ocelot.officialocelot.lostinfinitymodern.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = LostInfinityModern.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModKeyMappings {
    public static final Lazy<KeyMapping> SWITCH_MODE_ITEM = Lazy.of(() -> new KeyMapping(
            "key.lostinfinitymodern.switch_mode_item", // Will be localized using this translation key
            InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
            GLFW.GLFW_KEY_V, // Default key is V
            "key.categories.lostinfinitymodern.infinity"
    ));

    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(SWITCH_MODE_ITEM.get());
    }

    // Event is on the Forge event bus only on the physical client
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) { // Only call code once as the tick event is called twice every tick
            while (SWITCH_MODE_ITEM.get().consumeClick()) {

            }
        }
    }
}
