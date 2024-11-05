package net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = LostInfinityModern.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class InfinityDamageHandler {
    public static final HashMap<LivingEntity, InfinityDamageHandler> HANDLERS = new HashMap<>();

    public LivingEntity entity;
    public InfinityDefenseInstance defenseInstance;

    InfinityDamageHandler(LivingEntity entity) {
        this.entity = entity;
        this.defenseInstance = new InfinityDefenseInstance();
    }

    public void damage(InfinityDamageInstance damageInstance) {
        for(InfinityDamageReaction reaction: defenseInstance.reactions) {
            damageInstance = reaction.react(damageInstance);
        }
        if(damageInstance.applied) {
            damageInstance.apply_damage_to(entity, defenseInstance.max_health_defense, defenseInstance.true_defense);
        }
    }

    public static void damage(LivingEntity entity, int max_health_damage, LivingEntity source_entity) {
        HANDLERS.get(entity).damage(new InfinityDamageInstance(max_health_damage).set_source_entity(source_entity));
    }

    public static void damage(LivingEntity entity, int max_health_damage, int true_damage, LivingEntity source_entity) {
        HANDLERS.get(entity).damage(new InfinityDamageInstance(max_health_damage, true_damage).set_source_entity(source_entity));
    }


    @SubscribeEvent
    public static void give_damage_handler(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide && (event.getEntity() instanceof LivingEntity)) {
            HANDLERS.put((LivingEntity) event.getEntity(), new InfinityDamageHandler((LivingEntity) event.getEntity()));
        }
    }

    @SubscribeEvent
    public static void remove_damage_handler(EntityLeaveLevelEvent event) {
        if(!event.getLevel().isClientSide && (event.getEntity() instanceof LivingEntity)) {
            HANDLERS.remove((LivingEntity) event.getEntity());
        }
    }
}
