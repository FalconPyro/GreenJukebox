package net.funshinex.greenjukebox.block;

import net.funshinex.greenjukebox.util.GeneralUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNote;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGreenNote extends BlockNote{

	public BlockGreenNote(int par1) {
		super();
		this.setCreativeTab(CreativeTabs.tabRedstone);
		
		setBlockName(BlockInfo.GREEN_NOTE_UNLOCALIZED_NAME);
		
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GREEN_NOTE_TEXTURE);
	}
	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block par5)
    {
        super.onNeighborBlockChange(world, x, y, z, par5);
        if(!world.isRemote)
		{
			randomBonemeal(world, x,y,z);
		}
    }
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		super.onBlockActivated(world, x, y, z, par5EntityPlayer, par6, par7, par8, par9);
		if(!world.isRemote)
		{
			randomBonemeal(world, x,y,z);
		}
		
		return true;
    }
	private void randomBonemeal(World worldObj, int xCoord, int yCoord, int zCoord) {
		
		int range = BlockInfo.GROWTH_RANGE;
		
		int randX = worldObj.rand.nextInt(range*2+1) - range; // default -7 through 7
		int randZ = worldObj.rand.nextInt(range*2+1) - range;
		
		GeneralUtil.limBoneMeal(worldObj, xCoord+randX, yCoord, zCoord+randZ, null);
		GeneralUtil.limBoneMeal(worldObj, xCoord+randX, yCoord-1, zCoord+randZ, null);
		GeneralUtil.limBoneMeal(worldObj, xCoord+randX, yCoord+1, zCoord+randZ, null);
		
	}
	
}
