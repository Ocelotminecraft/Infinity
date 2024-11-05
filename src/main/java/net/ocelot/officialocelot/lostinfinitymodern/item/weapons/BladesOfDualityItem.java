package net.ocelot.officialocelot.lostinfinitymodern.item.weapons;

import net.minecraft.nbt.StringTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.item.capability.IMultipleModesItem;
import net.ocelot.officialocelot.lostinfinitymodern.util.infinitydamage.InfinityDamageHandler;
import org.jetbrains.annotations.NotNull;

public class BladesOfDualityItem extends SwordItem implements IMultipleModesItem<BladesOfDualityItem.Mode> {
    public BladesOfDualityItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(player.level().isClientSide && isMode(stack, Mode.BLUE)) {
            player.push(0.0, 10.0, 0.0);
        }
        if(!player.level().isClientSide && entity instanceof LivingEntity) {
            if (isMode(stack, Mode.RED)) {
                InfinityDamageHandler.damage((LivingEntity) entity, (entity.getPosition(0.0f).y >= 80.0) ? 50 : 10, player);
                changeMode(stack, Mode.BLUE);
            } else {
                entity.push(0, 10.0, 0.0);
                changeMode(stack, Mode.RED);
            }
        }
        return true;
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        stack.addTagElement("mode", StringTag.valueOf(Mode.RED.name));
        return stack;
    }

    @Override
    public void changeMode(ItemStack stack, Mode mode) {
        stack.addTagElement("mode", StringTag.valueOf(mode.name));
    }

    @Override
    public Mode getMode(ItemStack stack) {
        String mode;
        if (stack.getTag() != null) {
            mode = stack.getTag().getString("mode");
        } else {
            stack.addTagElement("mode", StringTag.valueOf(Mode.RED.name));
            mode = Mode.RED.name;
        }
        return Mode.getModeByName(mode);
    }

    @Override
    public boolean isMode(ItemStack stack, Mode mode) {
        return getMode(stack) == mode;
    }

    public enum Mode {
        RED("red",0),
        BLUE("blue",1);

        final String name;
        final int id;

        public static Mode getModeByName(String name) {
            for(Mode m: Mode.values()) {
                if(name.equals(m.name)) {
                    return m;
                }
            }
            LostInfinityModern.LOGGER.error("Something broke, there is no mode with that name???");
            return null;
        }

        Mode(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
