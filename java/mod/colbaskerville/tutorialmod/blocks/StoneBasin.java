package mod.colbaskerville.tutorialmod.blocks;

import javax.vecmath.AxisAngle4d;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class StoneBasin extends BlockBase 
{
	
	public static final AxisAlignedBB STONE_BASIN_AABB = new AxisAlignedBB(0.125D, 0, 0.125D, 0.875D, 0.1875D, 0.875D);
	
	
	public StoneBasin (String name)
	{
		super(name, Material.ROCK);
		
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return STONE_BASIN_AABB;
	}

	
	
	
}
