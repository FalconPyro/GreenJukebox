package net.funshinex.greenjukebox.util;

import net.funshinex.greenjukebox.block.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GeneralUtil {

	public static void limBoneMeal(World world, int x, int y, int z, ItemStack stack)
	{
		if(BlockInfo.DISC_REQUIRED)
		{
			if(stack == null)
			{
				InterfaceBoneMeal(world,x,y,z);
			}
			else
			{
				if(stack.getItem() instanceof ItemRecord)
				{
					if(stack.getItem() == Items.record_11 && world.getBlock(x, y, z) == Blocks.potatoes)
					{
						InterfaceBoneMeal(world, x, y, z);
					}
					else if(stack.getItem() == Items.record_cat && world.getBlock(x, y, z) == Blocks.cactus)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_13 && world.getBlock(x, y, z) == Blocks.reeds)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_blocks && world.getBlock(x, y, z) == Blocks.carrots)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_chirp && world.getBlock(x, y, z) == Blocks.sapling)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_ward && world.getBlock(x, y, z) == Blocks.wheat)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_wait && world.getBlock(x,y,z) == Blocks.red_mushroom)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_stal && world.getBlock(x,y,z) == Blocks.brown_mushroom)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_far && world.getBlock(x, y, z) == Blocks.pumpkin_stem)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_mall && world.getBlock(x, y, z) == Blocks.cocoa)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(stack.getItem() == Items.record_mellohi && world.getBlock(x,y,z) == Blocks.melon_stem)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
					else if(world.getBlock(x, y, z) == Blocks.grass)
					{
						InterfaceBoneMeal(world,x,y,z );
					}
				}
			}
		}
		else
		{
			InterfaceBoneMeal(world, x, y, z);
		}
	}

	public static void InterfaceBoneMeal(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		if(block != null)
		{
			if(block instanceof IGrowable)
			{
				IGrowable iGrow = (IGrowable)block;
	            if(iGrow.func_149851_a(world, x, y, z, world.isRemote))
	            {
	            	if(iGrow.func_149852_a(world, world.rand, x, y, z))
	            	{
	            		iGrow.func_149853_b(world, world.rand, x, y, z);
	            	}
	            }
			}
			else if(block == Blocks.cactus || block == Blocks.reeds)
			{
				if(world.getBlock(x, y+1, z) == Blocks.air)
				{
					if(world.getBlock(x,y-2,z) != block)
					{
						world.setBlock(x,y+1,z,block);
					}
				}
			}
		}
	}	
}