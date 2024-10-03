package net.ocelot.officialocelot.lostinfinitymodern.registration;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

import java.util.HashMap;
import java.util.function.Supplier;

public class RegisterBlocks {
    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LostInfinityModern.MOD_ID);

    public static final HashMap<String, RegistryObject<Block>> BLOCK_LIST = new HashMap<>();

    public static final RegistryObject<Block> DEFAULT_BLOCK = BLOCK_DEFERRED_REGISTER.register("useless_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).noLootTable()));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block, boolean register_block_item) {
        RegistryObject<Block> toReturn = BLOCK_DEFERRED_REGISTER.register(name, block);
        if(register_block_item) {
            RegisterItems.BLOCK_ITEM_LIST.put(name, RegisterItems.registerBlockItem(name, toReturn));
        }
        BLOCK_LIST.put(name, toReturn);
        return toReturn;
    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCK_DEFERRED_REGISTER.register(name, block);
        RegisterItems.BLOCK_ITEM_LIST.put(name, RegisterItems.registerBlockItem(name, toReturn));
        BLOCK_LIST.put(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCK_DEFERRED_REGISTER.register(eventBus);
    }
}
