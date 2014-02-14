package net.funshinex.greenjukebox.block;

import net.funshinex.greenjukebox.chatcomponents.GreenJukeboxChat;
import net.funshinex.greenjukebox.tileentity.TileEntityGreenRecordPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukebox;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGreenJukebox extends BlockJukebox {

	public BlockGreenJukebox(int id) {
		super();
		
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(Block.soundTypeWood);
		
		setBlockName(BlockInfo.GREEN_JUKEBOX_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	
	@SideOnly(Side.CLIENT)
	private IIcon sideIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GREEN_JUKEBOX_TOP);
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.GREEN_JUKEBOX_SIDE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if (side == 1) {
			return topIcon;
		} else {
			return sideIcon;
		}
	}
	
	
	@Override
	/**insertRecord */
	public void func_149926_b(World world, int x, int y, int z, ItemStack stack) {
		super.func_149926_b(world, x, y, z, stack);
		System.out.println("");
		
		TileEntityGreenRecordPlayer teGreenRecordPlayer = (TileEntityGreenRecordPlayer)world.getTileEntity(x, y, z);	
		teGreenRecordPlayer.func_145857_a(stack);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.getBlockMetadata(x, y, z) == 0)
        {
        	
        	if (player.getHeldItem() != null) {
        		ItemStack hand = player.getHeldItem();
        		if (hand.getItem() instanceof ItemRecord) {
        			this.func_149926_b(world, x, y, z, hand);
        			player.setCurrentItemOrArmor(0, null);
        			world.playAuxSFXAtEntity((EntityPlayer)null, 1005, x, y, z, 0);
        		}
        		else {
        			if(!world.isRemote)
        			{
//        				GreenJukeboxChat msg = new GreenJukeboxChat();
//        				msg.appendText("What you holding?");
//        				player.addChatComponentMessage(msg);
        			}
        		}
        			
        	}
            return false;
        }
        else
        {
            this.func_149925_e(world, x, y, z);
            return true;
        }
    }
	
	@Override
	/**I Don't Know What number does, hence the useless name, it has the name <strong>p_149915_2_</strong> in the BlockJukebox class*/
	public TileEntity createNewTileEntity(World par1World, int number)
    {
        return new TileEntityGreenRecordPlayer();
    }
	

}
