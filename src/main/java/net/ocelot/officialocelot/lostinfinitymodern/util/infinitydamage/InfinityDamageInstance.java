package net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.util.LevelInteractionUtil;
import net.ocelot.officialocelot.lostinfinitymodern.util.damagetypes.ModDamageSources;

import static java.lang.Math.max;

public class InfinityDamageInstance {
    public int base_max_health_damage;
    public int base_true_damage;

    public double life_steal_percentage;
    
    public boolean reflection;
    public boolean undodgeable;
    public boolean instakill;

    public boolean applied = true;

    public LivingEntity source_entity;

    public InfinityDamageInstance(int base_max_health_damage, int base_true_damage, double life_steal_percentage, boolean reflection, boolean undodgeable, boolean instakill) {
        this.base_max_health_damage = base_max_health_damage;
        this.base_true_damage = base_true_damage;
        this.life_steal_percentage = life_steal_percentage;
        this.reflection = reflection;
        this.undodgeable = undodgeable;
        this.instakill = instakill;
    }

    public InfinityDamageInstance(int base_max_health_damage) {
        this(base_max_health_damage, 0, 0.0, false, false, false);
    }

    public InfinityDamageInstance(int base_max_health_damage, int base_true_damage) {
        this(base_max_health_damage, base_true_damage, 0.0, false, false, false);
    }

    public InfinityDamageInstance(int base_max_health_damage, double life_steal_percentage) {
        this(base_max_health_damage, 0, life_steal_percentage, false, false, false);
    }

    public InfinityDamageInstance(int base_max_health_damage, int base_true_damage, double life_steal_percentage) {
        this(base_max_health_damage, base_true_damage, life_steal_percentage, false, false, false);
    }

    public InfinityDamageInstance(int base_max_health_damage, int base_true_damage, double life_steal_percentage, boolean reflection) {
        this(base_max_health_damage, base_true_damage, life_steal_percentage, reflection, false, false);
    }

    public InfinityDamageInstance set_source_entity(LivingEntity source) {
        source_entity = source;
        return this;
    }

    public void apply_damage_to(LivingEntity entity, int max_health_damage_reduction, int true_damage_reduction) {
        if(!entity.level().isClientSide) {
            if (entity.isInvulnerable()) {
                return;
            }
            if (instakill) {
                if(source_entity == null) {
                    entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.INFINITY)), Float.MAX_VALUE);
                } else {
                    entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.INFINITY), source_entity), Float.MAX_VALUE);
                }
            }
            double health_percentage = 100.0 * (entity.getHealth() / entity.getMaxHealth());
            int overflow = true_damage_reduction - base_true_damage;
            int true_damage = max(base_true_damage - true_damage_reduction, 0);
            health_percentage -= true_damage;
            int max_health_damage = max(base_max_health_damage - (max_health_damage_reduction + overflow), 0);
            health_percentage -= max_health_damage;
            LevelInteractionUtil.spawnParticlesAt(entity.level(), ParticleTypes.DAMAGE_INDICATOR, entity.getPosition(0.0f), new Vec3(0.2, 0.5, 0.2), max_health_damage + true_damage, 0.1); ;
            if (health_percentage <= 0.0) {
                if ((entity.getPersistentData().get("lives") != null) && (entity.getPersistentData().getInt("lives") > 1)) {
                    entity.getPersistentData().putInt("lives", entity.getPersistentData().getInt("lives") - 1);
                    entity.setHealth(entity.getMaxHealth());
                } else {
                    if(source_entity == null) {
                        entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.INFINITY)), Float.MAX_VALUE);
                    } else {
                        entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.INFINITY), source_entity), Float.MAX_VALUE);
                    }
                }
            }
            entity.setHealth((float) (health_percentage / 100.0 * entity.getMaxHealth()));
            entity.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.INFINITY)),0.0f);
        } else {
            LostInfinityModern.LOGGER.error("Called damage on the client side? BUG?");
        }
    }
}
