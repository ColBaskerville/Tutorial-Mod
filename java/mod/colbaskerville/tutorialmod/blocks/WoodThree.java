package mod.colbaskerville.tutorialmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class WoodThree extends BlockBase {

	public WoodThree(String name, Material material) {
		super(name, material);
		setHardness(4.0F);
		setResistance(4.0F);
		setHarvestLevel("axe", 2);
		setSoundType(SoundType.WOOD);
		//setLightLevel(0);
		//setLightOpacity(0);
		//setBlockUnbreakable();
	}
}
