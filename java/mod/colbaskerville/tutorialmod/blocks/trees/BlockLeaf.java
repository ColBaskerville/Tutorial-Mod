package mod.colbaskerville.tutorialmod.blocks.trees;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.blocks.item.ItemBlockVariants;
import mod.colbaskerville.tutorialmod.init.ModBlocks;
import mod.colbaskerville.tutorialmod.init.ModItems;
import mod.colbaskerville.tutorialmod.util.interfaces.IHasModel;
import mod.colbaskerville.tutorialmod.util.interfaces.IMetaName;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaf extends BlockLeaves implements IHasModel, IMetaName 
{
	public static final PropertyEnum<BlockPlank.EnumType> VARIANT = PropertyEnum.<BlockPlank.EnumType>create("variant", BlockPlank.EnumType.class, new Predicate<BlockPlank.EnumType>()
	{
		public boolean apply(@Nullable BlockPlank.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
	
	public BlockLeaf(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setCreativeTab(Main.tutorialtab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockPlank.EnumType.APPLE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
	
		this.leavesFancy = true;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockPlank.EnumType.byMetadata(meta % 2));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = ((BlockPlank.EnumType)state.getValue(VARIANT)).getMeta();
		
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 2;
		}
		
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 4;
		}
		
		return i;
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(BlockPlank.EnumType customblockplanks$enumtype : BlockPlank.EnumType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlank.EnumType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((BlockPlank.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return BlockPlank.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}
	
	@Override
	protected int getSaplingDropChance(IBlockState state) {return 30;}
	
	@Override
	public net.minecraft.block.BlockPlanks.EnumType getWoodType(int meta) {return null;}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}	
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < BlockPlank.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(ModBlocks.LEAVES), i, "leaves_" + BlockPlank.EnumType.values()[i].getName(), "inventory");
		}
	}
}