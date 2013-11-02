package net.funshinex.greenjukebox.config;

import java.io.File;

import net.funshinex.greenjukebox.block.BlockInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.GREEN_JUKEBOX_ID = config.getBlock(BlockInfo.GREEN_JUKEBOX_KEY,  BlockInfo.GREEN_JUKEBOX_DEFAULT).getInt();
		BlockInfo.GROWTH_TIME = config.get("General", BlockInfo.GROWTH_TIME_KEY, BlockInfo.GROWTH_TIME_DEFAULT).getInt();
		BlockInfo.GROWTH_RANGE = config.get("General", BlockInfo.GROWTH_RANGE_KEY, BlockInfo.GROWTH_RANGE_DEFAULT).getInt();
		
		BlockInfo.LIMIT_GROWTH_TO_VANILLA = config.get("General", BlockInfo.LIMIT_GROWTH_KEY, BlockInfo.LIMIT_GROWTH_DEFULT).getBoolean(true);
		
		config.save();
	}

}
