package com.stal111.forbidden_arcanus.item;

import com.stal111.forbidden_arcanus.entity.projectile.ChorusPearlEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ChorusPearlItem extends BasicItem {

	public ChorusPearlItem(String name) {
		super(name, new Item.Properties().maxStackSize(16));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}
		world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		player.getCooldownTracker().setCooldown(this, 15);
		if (!world.isRemote) {
			ChorusPearlEntity chorus_pearl = new ChorusPearlEntity(world, player);
			chorus_pearl.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(chorus_pearl);
		}
		player.addStat(StatList.ITEM_USED.get(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);

	}

}