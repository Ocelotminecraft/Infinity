package net.ocelot.officialocelot.lostinfinitymodern.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

import java.util.List;

public class ModToolTiers {
    public static final Tier FORGEFIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, -1,11f, 6f, 25,
                    ModTags.Blocks.NEEDS_FORGEFIRE_TOOL, () -> Ingredient.of(RegisterItems.ITEM_LIST.get("master_crafted_alloy").get())),
            new ResourceLocation(LostInfinityModern.MOD_ID, "forgefire"), List.of(Tiers.NETHERITE), List.of()
    );
    public static final Tier CELESTIAL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 512,8f, 2f, 30,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHER_STAR)),
            new ResourceLocation(LostInfinityModern.MOD_ID, "celestial"), List.of(Tiers.DIAMOND), List.of(FORGEFIRE)
    );
}
