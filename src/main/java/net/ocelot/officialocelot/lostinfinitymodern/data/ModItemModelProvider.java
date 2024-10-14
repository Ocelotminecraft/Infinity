package net.ocelot.officialocelot.lostinfinitymodern.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterBlocks;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, LostInfinityModern.MOD_ID, existingFileHelper);
    }

    public static final String[] SIMPLE_ITEM_NAMES = new String[] {
            "deviant_bat_wing", "deviant_bear_hide", "deviant_beef", "deviant_blaze_rod",
            "deviant_bone", "deviant_bone_meal", "deviant_bottle", "deviant_egg",
            "deviant_ender_pearl", "deviant_fang", "deviant_flesh", "deviant_gel",
            "deviant_ghast_tear", "deviant_globe", "deviant_gold", "deviant_gunpowder",
            "deviant_ink", "deviant_iron", "deviant_magma_cream", "deviant_milk",
            "deviant_mushroom", "deviant_pelt", "deviant_pork_chop", "deviant_saddle",
            "deviant_sand", "deviant_shard", "deviant_shulker_shell", "deviant_skull",
            "deviant_slimeball", "deviant_snowball", "deviant_spider_eye", "deviant_star",
            "deviant_string", "deviant_wheat", "deviant_wing", "deviant_wool", "celestial_iron",
            "celestial_diamond", "celestial_redstone", "celestial_quartz", "celestial_emerald",
            "master_crafted_alloy", "master_forged_iron", "master_cut_diamond", "master_faceted_quartz",
            "master_enthralled_emerald", "master_charged_redstone",
    };

    @Override
    protected void registerModels() {
        for(String itemName:SIMPLE_ITEM_NAMES) {
            simpleItem(RegisterItems.ITEM_LIST.getOrDefault(itemName, RegisterItems.DEFAULT_ITEM));
        }

        handheldItem(RegisterItems.ITEM_LIST.getOrDefault("rod_of_deviation", RegisterItems.DEFAULT_ITEM));

        handheldItem(RegisterItems.ITEM_LIST.getOrDefault("forgefire_pickaxe", RegisterItems.DEFAULT_ITEM));
        handheldItem(RegisterItems.ITEM_LIST.getOrDefault("celestial_miners_pickaxe", RegisterItems.DEFAULT_ITEM));

        evenSimplerBlockItem(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_slab", RegisterBlocks.DEFAULT_BLOCK));
        evenSimplerBlockItem(RegisterBlocks.BLOCK_LIST.getOrDefault("astrorock_stairs", RegisterBlocks.DEFAULT_BLOCK));
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LostInfinityModern.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(LostInfinityModern.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(LostInfinityModern.MOD_ID,"item/" + item.getId().getPath()));
    }
}
