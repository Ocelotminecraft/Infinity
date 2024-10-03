package net.ocelot.officialocelot.lostinfinitymodern.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;

public class LevelInteractionUtil {

    static public boolean dropLootTable(LootTable lootTable, Level level, BlockPos blockPos, LootParams lootParams) {
        ObjectArrayList<ItemStack> items = lootTable.getRandomItems(lootParams);
        for(ItemStack item:items) {
            level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), item));
        }
        return true;
    }
}
