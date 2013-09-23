package net.funshinex.greenjukebox.tileentity;

import net.funshinex.greenjukebox.block.BlockInfo;
import net.funshinex.greenjukebox.util.GeneralUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityRecordPlayer;

public class TileEntityGreenRecordPlayer extends TileEntityRecordPlayer {

	private int timer;
	private ItemStack growthRecord;
	
	public TileEntityGreenRecordPlayer() {
		timer = BlockInfo.GROWTH_TIME;
	}
	
	public boolean hasRecord() {
		return growthRecord != null;
	}
	
	@Override
	public void updateEntity() {
		if(hasRecord()) {
			if (timer == 0) {
				randomBonemeal();
				
				timer = BlockInfo.GROWTH_TIME;
				
			} else {
				timer --;
			}			
		}
	}
	
	@Override
	public void func_96098_a(ItemStack stack)
    {
        super.func_96098_a(stack);
        growthRecord = stack;
    }
	
	private void randomBonemeal() {
		
		int range = BlockInfo.GROWTH_RANGE;
		
		int randX = worldObj.rand.nextInt(range*2+1) - range; // default -7 through 7
		int randZ = worldObj.rand.nextInt(range*2+1) - range;
		
		GeneralUtil.applyBonemeal(worldObj, xCoord+randX, yCoord, zCoord+randZ, null);
		GeneralUtil.applyBonemeal(worldObj, xCoord+randX, yCoord-1, zCoord+randZ, null);
		GeneralUtil.applyBonemeal(worldObj, xCoord+randX, yCoord+1, zCoord+randZ, null);
		
	}
}
