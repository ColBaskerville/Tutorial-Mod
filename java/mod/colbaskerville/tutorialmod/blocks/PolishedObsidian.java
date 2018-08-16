package mod.colbaskerville.tutorialmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PolishedObsidian extends BlockBase 
{
	public PolishedObsidian(String name, Material material) {
		super(name, material);
		setHardness(8.0F);
		setResistance(20.0F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 4);
		//setLightLevel(0);
		//setLightOpacity(0);
		//setBlockUnbreakable();
	}
}
