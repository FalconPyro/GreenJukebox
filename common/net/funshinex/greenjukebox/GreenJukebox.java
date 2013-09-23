package net.funshinex.greenjukebox;

import net.funshinex.greenjukebox.block.Blocks;
import net.funshinex.greenjukebox.config.ConfigHandler;
import net.funshinex.greenjukebox.network.PacketHandler;
import net.funshinex.greenjukebox.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ModInformation.ID, name=ModInformation.NAME, version=ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired=true, serverSideRequired=false, packetHandler=PacketHandler.class)
public class GreenJukebox {
	
	@Instance(ModInformation.ID)
	public static GreenJukebox instance;
	
	@SidedProxy(clientSide="net.funshinex.greenjukebox.proxy.ClientProxy", serverSide="net.funshinex.greenjukebox.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		Blocks.init();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Blocks.addNames();
		
		Blocks.registerTileEntities();
		
		GameRegistry.addRecipe(new ItemStack(Blocks.greenJukebox), 
				new Object[] { "sss",
							   "cjp",
							   "ddd",
							   's', new ItemStack(Block.sapling) , 
							   'c', new ItemStack(Item.carrot),
							   'j', new ItemStack(Block.jukebox),
							   'p', new ItemStack(Item.potato),
							   'd', new ItemStack(Item.seeds)
		
		});
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
