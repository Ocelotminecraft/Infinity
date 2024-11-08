package net.ocelot.officialocelot.lostinfinitymodern.item.tools.transformationrods;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.ocelot.officialocelot.lostinfinitymodern.util.LevelInteractionUtil;
import net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage.InfinityDamageHandler;
import net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage.InfinityDamageInstance;
import org.joml.Vector3d;

import java.awt.*;
import java.util.Objects;


public class RodOfDeviationItem extends BaseTransformationRodItem {
    public RodOfDeviationItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void transformEntity(Player player, Entity entity) {
        if(!deviateEntity(player, (LivingEntity) entity)) {
            LevelInteractionUtil.spawnParticlesAt(entity.level(), ParticleTypes.ENTITY_EFFECT, entity.getPosition(0.0f), new Vec3(0.2, 0.5, 0.2), 25, 1.0);
            InfinityDamageHandler.HANDLERS.get(entity).damage(new InfinityDamageInstance(10).set_source_entity(player));
        }
    }
}
