package mod.colbaskerville.tutorialmod.items.food;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.init.ModItems;
import mod.colbaskerville.tutorialmod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood implements IHasModel
{
	public ItemCustomFood(String name, int amount, boolean isWolfFood)
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tutorialtab);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}



}
