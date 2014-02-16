package net.funshinex.greenjukebox;

import net.funshinex.greenjukebox.block.GJ_Blocks;
import net.funshinex.greenjukebox.config.ConfigHandler;
import net.funshinex.greenjukebox.proxy.CommonProxy;
import net.funshinex.greenjukebox.recipes.Crafting;
import net.funshinex.greenjukebox.tabs.GJ_Tab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ModInformation.ID, name=ModInformation.NAME, version=ModInformation.VERSION)
public class GreenJukebox {
	
	@Instance(ModInformation.ID)
	public static GreenJukebox instance;
	
	@SidedProxy(clientSide="net.funshinex.greenjukebox.proxy.ClientProxy", serverSide="net.funshinex.greenjukebox.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		GJ_Blocks.init();
		GJ_Tab tab = new GJ_Tab("greenJukebox.Tab");
		GJ_Blocks.greenJukebox.setCreativeTab(tab);
		GJ_Blocks.greenNote.setCreativeTab(tab);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		GJ_Blocks.registerTileEntities();
		Crafting.AddBlockRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
