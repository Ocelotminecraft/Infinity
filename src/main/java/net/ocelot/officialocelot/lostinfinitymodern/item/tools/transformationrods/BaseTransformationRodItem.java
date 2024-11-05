package net.ocelot.officialocelot.lostinfinitymodern.item.tools.transformationrods;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModTags;
import net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage.InfinityDamageHandler;
import net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage.InfinityDamageInstance;

public class BaseTransformationRodItem extends Item {
    public BaseTransformationRodItem(Item.Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(!player.level().isClientSide) {
            transformEntity(player, entity);
        }
        return true;
    }

    protected void transformEntity(Player player, Entity entity) { }

    protected boolean deviateEntity(Player player, LivingEntity entity) {
        if ((entity != null) && (entity.getType().is(ModTags.EntityTypes.CAN_BE_DEVIATED))) {
            player.sendSystemMessage(Component.literal("this entity would be deviated, but it isn't coded yet. ¯\\_(ツ)_/¯"));
            return true;
        }
        return false;
    }
}
