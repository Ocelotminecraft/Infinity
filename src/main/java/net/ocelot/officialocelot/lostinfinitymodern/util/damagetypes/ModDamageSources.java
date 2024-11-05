package net.ocelot.officialocelot.lostinfinitymodern.util.damagetypes;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

import javax.annotation.Nullable;

public class ModDamageSources {
    public static final ResourceKey<DamageType> INFINITY = register("infinity");

    private static ResourceKey<DamageType> register(String name)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LostInfinityModern.MOD_ID, name));
    }
}