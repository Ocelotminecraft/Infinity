package net.ocelot.officialocelot.lostinfinitymodern.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.Vec3;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import org.joml.Vector3d;

import java.awt.*;

public class LevelInteractionUtil {

    static public void dropLootTable(Level level, LootTable lootTable, BlockPos blockPos, LootParams lootParams) {
        ObjectArrayList<ItemStack> items = lootTable.getRandomItems(lootParams);
        for(ItemStack item:items) {
            level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), item));
        }
    }

    static public void spawnParticlesAt(Level level, ParticleOptions pOption, Vec3 blockPos, Vector3d offsetRandom, int amount, Color color, double speed) {
        if(level instanceof ServerLevel) {
            for (int i = 0; i < amount; i++) {
                Vector3d offsetPos = new Vector3d(blockPos.x + offsetRandom.x * (level.random.nextDouble() * 2.0 - 1.0), blockPos.y + offsetRandom.y * (level.random.nextDouble() * 2.0 - 1.0), blockPos.z + offsetRandom.z * (level.random.nextDouble() * 2.0 - 1.0));
                ((ServerLevel) level).sendParticles(pOption, offsetPos.x, offsetPos.y, offsetPos.z, 0, color.getRed() / 255.0, color.getGreen() / 255.0, color.getBlue() / 255.0, speed);
            }
        }
        else {
            LostInfinityModern.LOGGER.error("Somehow, the level returned is not server side, prolly forgot something." + " Particle spawner one");
        }
    }

    static public void spawnParticlesAt(Level level, ParticleOptions pOption, Vec3 position, Vec3 offsetRandom, int amount, double speed) {
        if(level instanceof ServerLevel) {
            ((ServerLevel) level).sendParticles(pOption, position.x, position.y, position.z, amount, offsetRandom.x, offsetRandom.y, offsetRandom.z, speed);
        }
        else {
            LostInfinityModern.LOGGER.error("Somehow, the level returned is not server side, prolly forgot something." + " Particle spawner two");
        }
    }
}
