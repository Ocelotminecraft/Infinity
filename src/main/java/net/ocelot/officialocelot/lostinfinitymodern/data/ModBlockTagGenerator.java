package net.ocelot.officialocelot.lostinfinitymodern.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LostInfinityModern.MOD_ID, existingFileHelper);
    }

    //Mineable Tags
    public static final String[] MINEABLE_WITH_PICKAXE = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            "astromolt_bubble", /*"astromud",*/ "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", "astrorock_hardened", "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", "astrosteel",
            "astrorock_stairs", "astrorock_slab",
    };

    public static final String[] MINEABLE_WITH_SHOVEL = new String[] {
            "astromud"
    };

    //Needs Tool Tags
    public static final String[] NEEDS_DIAMOND_TOOL = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            "astromolt_bubble", "astromud", "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", "astrorock_hardened", "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", /*"astrosteel"*/
            "astrorock_stairs", "astrorock_slab",
    };

    public static final String[] NEEDS_NETHERITE_TOOL = new String[] {
            "astrosteel"
    };


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Mineable Tags
        for(String name:MINEABLE_WITH_PICKAXE) {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(RegisterBlocks.BLOCK_LIST.getOrDefault(name, RegisterBlocks.DEFAULT_BLOCK).get());
        }
        for(String name:MINEABLE_WITH_SHOVEL) {
            this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(RegisterBlocks.BLOCK_LIST.getOrDefault(name, RegisterBlocks.DEFAULT_BLOCK).get());
        }

        //this.tag(ModTags.Blocks.CELESTIAL_SPECIAL_DROPS).add(Blocks.IRON_ORE, Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.NETHER_QUARTZ_ORE);

        //Needs Tool Tags
        for(String name:NEEDS_DIAMOND_TOOL) {
            this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(RegisterBlocks.BLOCK_LIST.getOrDefault(name, RegisterBlocks.DEFAULT_BLOCK).get());
        }
        for(String name:NEEDS_NETHERITE_TOOL) {
            this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(RegisterBlocks.BLOCK_LIST.getOrDefault(name, RegisterBlocks.DEFAULT_BLOCK).get());
        }
    }
}
