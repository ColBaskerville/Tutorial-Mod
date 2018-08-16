package mod.colbaskerville.tutorialmod;

import mod.colbaskerville.tutorialmod.proxy.CommonProxy;
import mod.colbaskerville.tutorialmod.tabs.TutorialTab;
import mod.colbaskerville.tutorialmod.util.Reference;
import mod.colbaskerville.tutorialmod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static final CreativeTabs tutorialtab = new TutorialTab("tutorialtab");
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.otherRegistries();
		}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {

		}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}

}
