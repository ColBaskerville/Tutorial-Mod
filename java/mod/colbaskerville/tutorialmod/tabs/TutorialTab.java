package mod.colbaskerville.tutorialmod.tabs;

import mod.colbaskerville.tutorialmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs 
{
	public TutorialTab(String label)
	{
		super("tutorialtab");
		this.setBackgroundImageName("tutorial.png");
	}
	
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.RUBY);
	}
}
