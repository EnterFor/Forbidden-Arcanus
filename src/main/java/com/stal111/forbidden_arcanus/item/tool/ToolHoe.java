package com.stal111.forbidden_arcanus.item.tool;

import com.stal111.forbidden_arcanus.Main;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.util.ResourceLocation;

public class ToolHoe extends ItemHoe {

	public ToolHoe(String name, IItemTier tier, float attackSpeedIn) {
		super(tier, attackSpeedIn,  new Item.Properties().group(Main.FORBIDDEN_ARCANUS));
		this.setRegistryName(new ResourceLocation(Main.MODID, name));
	}

}