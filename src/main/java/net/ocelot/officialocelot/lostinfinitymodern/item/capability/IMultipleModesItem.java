package net.ocelot.officialocelot.lostinfinitymodern.item.capability;

import net.minecraft.world.item.ItemStack;

public interface IMultipleModesItem<MODE extends Enum<MODE>> {

    String[] modes = null;

    void changeMode(ItemStack stack, MODE mode);

    MODE getMode(ItemStack stack);

    boolean isMode(ItemStack stack, MODE mode);
}
