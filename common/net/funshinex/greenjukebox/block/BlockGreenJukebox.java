package net.funshinex.greenjukebox.block;

import net.funshinex.greenjukebox.tileentity.TileEntityGreenRecordPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGreenJukebox extends BlockJukeBox {

	public BlockGreenJukebox(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(Block.soundWoodFootstep);
		
		setUnlocalizedName(BlockInfo.GREEN_JUKEBOX_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GREEN_JUKEBOX_TOP);
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GREEN_JUKEBOX_SIDE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		
		if (side == 1) {
			return topIcon;
		} else {
			return sideIcon;
		}
	}
	
	@Override
	public void insertRecord(World world, int x, int y, int z, ItemStack stack) {
		super.insertRecord(world, x, y, z, stack);
		
		TileEntityGreenRecordPlayer teGreenRecordPlayer = (TileEntityGreenRecordPlayer)world.getBlockTileEntity(x, y, z);	
		teGreenRecordPlayer.func_96098_a(stack);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.getBlockMetadata(x, y, z) == 0)
        {
        	if (player.getCurrentItemOrArmor(0) != null) {
        		ItemStack hand = player.getCurrentItemOrArmor(0);
        		
        		if (hand.getItem() instanceof ItemRecord) {
        			this.insertRecord(world, x, y, z, hand);
        			player.setCurrentItemOrArmor(0, null);
        			world.playAuxSFXAtEntity((EntityPlayer)null, 1005, x, y, z, hand.itemID);
        		}
        		else {
        			if(!world.isRemote)
        			{
        				player.addChatMessage("What are you holding?");
        			}
        		}
        			
        	}
            return false;
        }
        else
        {
            this.ejectRecord(world, x, y, z);
            return true;
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityGreenRecordPlayer();
    }
	

}
