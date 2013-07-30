package TheElectronicsMod;

import TheElectronicsMod.config.ConfigHandler;
import TheElectronicsMod.network.PacketHandler;
import TheElectronicsMod.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="TheElectronicsMod", name ="The Electronics Mod", version="0.0.1")
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class TheElectronicsMod {
	
	
    @Instance(ModInformation.ID)
    public static TheElectronicsMod instance;
    
    @SidedProxy(clientSide = "TheElectronicsMod.proxies.ClientProxy", serverSide = "TheElectronicsMod.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		System.out.println(ConfigHandler.SOME_TEXT_VALUE);
		proxy.initSounds();
		proxy.initRenderers();
	}
    
    @EventHandler
    public void load(FMLInitializationEvent event){
    	
    }

    @EventHandler
    public void post(FMLPostInitializationEvent event){
    	
    }
}
