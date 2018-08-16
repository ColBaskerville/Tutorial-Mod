package mod.colbaskerville.tutorialmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Table extends BlockBase {

	public static final AxisAlignedBB TABLE_AABB = new AxisAlignedBB(0.0625D, 0, 0.0625D, 0.9375D, 0.25D, 0.9375D);

	public Table(String name) {
		super(name, Material.WOOD);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return TABLE_AABB;
	}
	
}
