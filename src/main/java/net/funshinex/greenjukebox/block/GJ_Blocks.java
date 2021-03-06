package net.funshinex.greenjukebox.block;

import net.funshinex.greenjukebox.tileentity.TileEntityGreenRecordPlayer;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class GJ_Blocks {
	
	public static Block greenJukebox;
	public static Block greenNote;
	
	public static void init() {
		greenJukebox = new BlockGreenJukebox(BlockInfo.GREEN_JUKEBOX_ID);
		GameRegistry.registerBlock(greenJukebox, BlockInfo.GREEN_JUKEBOX_KEY);
		
		greenNote = new BlockGreenNote(BlockInfo.GREEN_NOTE_ID);
		GameRegistry.registerBlock(greenNote, BlockInfo.GREEN_NOTE_KEY);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityGreenRecordPlayer.class, BlockInfo.GREEN_JUKEBOX_TE_KEY);
	}

}
