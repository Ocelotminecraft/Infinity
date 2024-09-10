package net.ocelot.lostinfinitymodern.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.lostinfinitymodern.item.AstroBlockItems;

import java.util.ArrayList;
import java.util.function.Supplier;


public class AstroBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LostInfinityModern.MOD_ID);

    public static final String[] ASTRO_BLOCK_NAMES = new String[] {
            "astrorock"
    };

    public static final ArrayList<RegistryObject<Block>> ASTRO_BLOCKS = new ArrayList<>();

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return AstroBlockItems.registerBlockItem(name, block);
    }

    public static void preRegister(IEventBus eventBus) {
        for (String block : ASTRO_BLOCK_NAMES) {
            registerBlock(block,
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.NETHERRACK)));
        }
        register(eventBus);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
