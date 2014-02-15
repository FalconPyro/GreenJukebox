package net.funshinex.greenjukebox.recipes;

import net.funshinex.greenjukebox.block.GJ_Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	public static void AddBlockRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(GJ_Blocks.greenJukebox), 
				new Object[] { "sss",
							   "cjp",
							   "ddd",
							   's', new ItemStack(Blocks.sapling) , 
							   'c', new ItemStack(Items.carrot),
							   'j', new ItemStack(Blocks.jukebox),
							   'p', new ItemStack(Items.potato),
							   'd', new ItemStack(Items.wheat_seeds)
		
		});
		
		GameRegistry.addRecipe(new ItemStack(GJ_Blocks.greenNote), 
				new Object[] { "sss",
							   "cjc",
							   "sss",
							   's', new ItemStack(Items.flint) , 
							   'c', new ItemStack(Items.bone),
							   'j', new ItemStack(Blocks.noteblock),		
		});
	}
	
}
