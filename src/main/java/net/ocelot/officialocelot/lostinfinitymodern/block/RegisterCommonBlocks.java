package net.ocelot.officialocelot.lostinfinitymodern.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterCreativeModeTabs;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

import java.util.function.Supplier;


public class RegisterCommonBlocks {

    public static final String[] BLOCK_NAMES = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            "astromolt_bubble", /*"astromud",*/ "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", /*"astrorock_hardened",*/ "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", /*"astrosteel"*/
    };


    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = RegisterBlocks.registerBlock(name, block);
        RegisterCreativeModeTabs.LOST_INFINITY_BLOCK_LIST.add(RegisterItems.BLOCK_ITEM_LIST.get(name));
        return toReturn;
    }


    public static void register() {
        for (String block : BLOCK_NAMES) {
            registerBlock(block, () ->
                    new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(15.0F, 360.0F).sound(SoundType.NETHERRACK)));
        }
        registerBlock("astromud", () ->  new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(10.0F, 120.0F).sound(SoundType.MUD)));
        registerBlock("astrorock_hardened", () ->  new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(20.0F, 480.0F).sound(SoundType.NETHER_BRICKS)));
        registerBlock("astrosteel", () ->  new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(50.0F, 1028.0F).sound(SoundType.NETHERITE_BLOCK)));
        registerBlock("astrorock_stairs", () -> new StairBlock(() -> RegisterBlocks.BLOCK_LIST.get("astrorock").get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(15.0F, 360.0F).sound(SoundType.NETHERRACK)));
        registerBlock("astrorock_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(15.0F, 360.0F).sound(SoundType.NETHERRACK)));

    }
}
