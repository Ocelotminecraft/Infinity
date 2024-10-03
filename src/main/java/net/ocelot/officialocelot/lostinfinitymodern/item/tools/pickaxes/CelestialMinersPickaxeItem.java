package net.ocelot.officialocelot.lostinfinitymodern.item.tools.pickaxes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootDataResolver;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;
import net.ocelot.officialocelot.lostinfinitymodern.LostInfinityModern;
import net.ocelot.officialocelot.lostinfinitymodern.util.LevelInteractionUtil;
import net.ocelot.officialocelot.lostinfinitymodern.util.ModTags;

public class CelestialMinersPickaxeItem extends PickaxeItem {
    public CelestialMinersPickaxeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_40992_) -> {
                p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
            if(pState.is(ModTags.Blocks.CELESTIAL_SPECIAL_DROPS)) {
                LootParams.Builder pParams = new LootParams.Builder(pLevel.getServer().getLevel(pEntityLiving.getCommandSenderWorld().dimension())).withParameter(LootContextParams.BLOCK_STATE, pState).withParameter(LootContextParams.TOOL, pEntityLiving.getMainHandItem()).withParameter(LootContextParams.ORIGIN, pPos.getCenter());
                LootParams lootparams = pParams.withParameter(LootContextParams.BLOCK_STATE, pState).create(LootContextParamSets.BLOCK);
                LootTable lootTable = pLevel.getServer().getLootData().getLootTable(new ResourceLocation(ForgeRegistries.BLOCKS.getKey(pState.getBlock()).getNamespace() +":"+"block/celestial_mined_blocks/"+ ForgeRegistries.BLOCKS.getKey(pState.getBlock()).getPath()));
                LostInfinityModern.LOGGER.debug((new ResourceLocation(ForgeRegistries.BLOCKS.getKey(pState.getBlock()).getNamespace() +":"+"block/celestial_mined_blocks/"+ ForgeRegistries.BLOCKS.getKey(pState.getBlock()).getPath())).toString());
                LevelInteractionUtil.dropLootTable(lootTable, pLevel, pPos, lootparams);
            }
        }
        return true;
    }
}
