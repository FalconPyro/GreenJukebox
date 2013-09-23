package net.funshinex.greenjukebox.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.funshinex.greenjukebox.tileentity.TileEntityGreenRecordPlayer;
import net.minecraft.block.Block;

public class Blocks {
	
	public static Block greenJukebox;
	
	public static void init() {
		greenJukebox = new BlockGreenJukebox(BlockInfo.GREEN_JUKEBOX_ID);
		GameRegistry.registerBlock(greenJukebox, BlockInfo.GREEN_JUKEBOX_KEY);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(greenJukebox, BlockInfo.GREEN_JUKEBOX_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityGreenRecordPlayer.class, BlockInfo.GREEN_JUKEBOX_TE_KEY);
	}

}
