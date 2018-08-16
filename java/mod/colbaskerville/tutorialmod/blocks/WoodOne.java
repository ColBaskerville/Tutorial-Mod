package mod.colbaskerville.tutorialmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class WoodOne extends BlockBase 
{
	public WoodOne(String name, Material material) {
		super(name, material);
		setHardness(8.0F);
		setResistance(20.0F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("axe", 2);
		//setLightLevel(0);
		//setLightOpacity(0);
		//setBlockUnbreakable();
	}
}
