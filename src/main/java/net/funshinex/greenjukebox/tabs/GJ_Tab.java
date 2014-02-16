package net.funshinex.greenjukebox.tabs;

import net.funshinex.greenjukebox.block.GJ_Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GJ_Tab extends CreativeTabs{

	public GJ_Tab(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(GJ_Blocks.greenJukebox);
	}

}
