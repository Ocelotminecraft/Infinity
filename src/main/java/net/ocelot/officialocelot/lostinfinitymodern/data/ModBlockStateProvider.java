package net.ocelot.officialocelot.lostinfinitymodern.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, LostInfinityModern.MOD_ID, exFileHelper);
    }


    public static final String[] SIMPLE_BLOCK_NAMES = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            /*"astromolt_bubble",*/ /*"astromud",*/ "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", /*"astrorock_hardened",*/ "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", "astrosteel"
    };


    @Override
    protected void registerStatesAndModels() {
        for(String blockName:SIMPLE_BLOCK_NAMES) {
            blockWithItem(RegisterBlocks.BLOCK_LIST.getOrDefault(blockName, RegisterBlocks.DEFAULT_BLOCK));
        }

        stairsBlock(((StairBlock) RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_stairs", RegisterBlocks.DEFAULT_BLOCK).get()), blockTexture(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock", RegisterBlocks.DEFAULT_BLOCK).get()));
        slabBlock(((SlabBlock) RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_slab", RegisterBlocks.DEFAULT_BLOCK).get()), blockTexture(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock", RegisterBlocks.DEFAULT_BLOCK).get()), blockTexture(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock", RegisterBlocks.DEFAULT_BLOCK).get()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
