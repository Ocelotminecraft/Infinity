package net.ocelot.officialocelot.lostinfinitymodern.data.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    public static final String[] BLOCK_DROP_SELF = new String[] {
            "astrobarrier_blue", "astrobarrier_green", "astrobarrier_purple", "astrobarrier_yellow", "astromolt",
            "astromolt_bubble", "astromud", "astrorock", "astrorock_blue", "astrorock_crystal_blue",
            "astrorock_glass", "astrorock_green", "astrorock_hardened", "astrorock_lamp_blue", "astrorock_lamp_green",
            "astrorock_lamp_purple", "astrorock_lamp_yellow", "astrorock_purple", "astrorock_yellow", "astrosteel",
            "astrorock_stairs",
    };


    @Override
    protected void generate() {
        for(String blockName:BLOCK_DROP_SELF) {
            this.dropSelf(RegisterBlocks.BLOCK_LIST.getOrDefault(blockName, RegisterBlocks.DEFAULT_BLOCK).get());
        }

        this.add(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_slab", RegisterBlocks.DEFAULT_BLOCK).get(),
                block -> createSlabItemTable(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_slab", RegisterBlocks.DEFAULT_BLOCK).get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegisterBlocks.BLOCK_DEFERRED_REGISTER.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
