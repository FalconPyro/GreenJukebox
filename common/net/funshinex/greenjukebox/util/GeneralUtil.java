package net.funshinex.greenjukebox.util;

import java.util.Random;

import net.funshinex.greenjukebox.block.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class GeneralUtil {
	
	public static boolean applyBonemeal(World world, int x, int y, int z, EntityPlayer player)
    {
		Random itemRand = new Random();
        int id = world.getBlockId(x, y, z);

        BonemealEvent event = new BonemealEvent(player, world, id, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            return true;
        }

        if (id == Block.sapling.blockID)
        {
            if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < 0.45D)
                {
                    ((BlockSapling)Block.sapling).markOrGrowMarked(world, x, y, z, world.rand);
                }
            }

            return true;
        }
        else if(id == Block.cactus.blockID || id == Block.reed.blockID)
        {
        	if(!world.isRemote)
        	{
        		if((double)world.rand.nextFloat() < 0.45 && world.isAirBlock(x, y+1, z))
        		{
        			if(BlockInfo.LIMIT_GROWTH_TO_VANILLA)
        			{
        				if(world.getBlockId(x,y-2,z) != id)
        				{
        					world.setBlock(x, y+1, z, id);
        				}
        			}
        			else
        			{
        				world.setBlock(x, y+1, z, id);
        			}
        		}
        	}
        	return true;
        }
        else if (id != Block.mushroomBrown.blockID && id != Block.mushroomRed.blockID)
        {
            if (id != Block.melonStem.blockID && id != Block.pumpkinStem.blockID)
            {
                if (id > 0 && Block.blocksList[id] instanceof BlockCrops)
                {
                    if (world.getBlockMetadata(x, y, z) == 7)
                    {
                        return false;
                    }
                    else
                    {
                        if (!world.isRemote)
                        {
                            ((BlockCrops)Block.blocksList[id]).fertilize(world, x, y, z);
                        }

                        return true;
                    }
                }
                else
                {
                    int i1;
                    int j1;
                    int k1;

                    if (id == Block.cocoaPlant.blockID)
                    {
                        i1 = world.getBlockMetadata(x, y, z);
                        j1 = BlockDirectional.getDirection(i1);
                        k1 = BlockCocoa.func_72219_c(i1);

                        if (k1 >= 2)
                        {
                            return false;
                        }
                        else
                        {
                            if (!world.isRemote)
                            {
                                ++k1;
                                world.setBlockMetadataWithNotify(x, y, z, k1 << 2 | j1, 2);
                            }

                            return true;
                        }
                    }
                    else if (id != Block.grass.blockID)
                    {
                        return false;
                    }
                    else
                    {
                        if (!world.isRemote)
                        {
                            label102:

                            for (i1 = 0; i1 < 128; ++i1)
                            {
                                j1 = x;
                                k1 = y + 1;
                                int l1 = z;

                                for (int i2 = 0; i2 < i1 / 16; ++i2)
                                {
                                    j1 += itemRand.nextInt(3) - 1;
                                    k1 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
                                    l1 += itemRand.nextInt(3) - 1;

                                    if (world.getBlockId(j1, k1 - 1, l1) != Block.grass.blockID || world.isBlockNormalCube(j1, k1, l1))
                                    {
                                        continue label102;
                                    }
                                }

                                if (world.getBlockId(j1, k1, l1) == 0)
                                {
                                    if (itemRand.nextInt(10) != 0)
                                    {
                                        if (Block.tallGrass.canBlockStay(world, j1, k1, l1))
                                        {
                                            world.setBlock(j1, k1, l1, Block.tallGrass.blockID, 1, 3);
                                        }
                                    }
                                    else
                                    {
                                        ForgeHooks.plantGrass(world, j1, k1, l1);
                                    }
                                }
                            }
                        }

                        return true;
                    }
                }
            }
            else if (world.getBlockMetadata(x, y, z) == 7)
            {
                return false;
            }
            else
            {
                if (!world.isRemote)
                {
                    ((BlockStem)Block.blocksList[id]).fertilizeStem(world, x, y, z);
                }

                return true;
            }
        }
        else
        {
            if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < 0.4D)
                {
                    ((BlockMushroom)Block.blocksList[id]).fertilizeMushroom(world, x, y, z, world.rand);
                }
            }

            return true;
        }
    }
}
