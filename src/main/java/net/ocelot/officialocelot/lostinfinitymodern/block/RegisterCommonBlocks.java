package net.ocelot.officialocelot.lostinfinitymodern.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

import java.util.function.Supplier;


public class RegisterCommonBlocks {

    public static final String[] BLOCK_NAMES = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            "astromolt_bubble", "astromud", "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", "astrorock_hardened", "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", "astrosteel"
    };

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        return RegisterBlocks.registerBlock(name, block);
    }

    public static void register() {
        for (String block : BLOCK_NAMES) {
            registerBlock(block,
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(-1.0F, 3600000.0F).sound(SoundType.NETHERRACK)));
            RegisterCreativeModeTabs.LOST_INFINITY_BLOCK_LIST.add(RegisterItems.BLOCK_ITEM_LIST.get(block));
        }
    }
}
