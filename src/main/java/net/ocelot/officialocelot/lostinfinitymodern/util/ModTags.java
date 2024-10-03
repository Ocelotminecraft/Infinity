package net.ocelot.officialocelot.lostinfinitymodern.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> NEEDS_FORGEFIRE_TOOL = tag("needs_forgefire_tool");
        public static TagKey<Block> CELESTIAL_SPECIAL_DROPS = tag("celestial_special_drops");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LostInfinityModern.MOD_ID, name));
        }
    }

    public static class Items {

    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> CAN_BE_DEVIATED = tag("can_be_deviated");
        public static final TagKey<EntityType<?>> DEVIANT = tag("deviant");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE ,new ResourceLocation(LostInfinityModern.MOD_ID, name));
        }
    }


}
