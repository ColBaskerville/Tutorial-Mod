package mod.colbaskerville.tutorialmod.items;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.init.ModItems;
import mod.colbaskerville.tutorialmod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}


}
