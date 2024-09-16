package net.ocelot.officialocelot.lostinfinitymodern.item.tools.transformationrods;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModTags;


public class RodOfDeviationItem extends Item {
    public RodOfDeviationItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(!player.level().isClientSide) {
            if (canDeviateEntity(entity)) {
                player.sendSystemMessage(Component.literal("this entity would be deviated, but it isn't coded yet. ¯\\_(ツ)_/¯"));
            }
        }
        return true;
    }

    private boolean canDeviateEntity(Entity entity) {
        return entity.getType().is(ModTags.EntityTypes.CAN_BE_DEVIATED);
    }
}
