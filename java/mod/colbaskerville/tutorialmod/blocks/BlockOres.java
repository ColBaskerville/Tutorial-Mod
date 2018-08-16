package mod.colbaskerville.tutorialmod.blocks;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.blocks.item.ItemBlockVariants;
import mod.colbaskerville.tutorialmod.init.ModBlocks;
import mod.colbaskerville.tutorialmod.init.ModItems;
import mod.colbaskerville.tutorialmod.util.handlers.EnumHandler;
import mod.colbaskerville.tutorialmod.util.handlers.EnumHandler.EnumType;
import mod.colbaskerville.tutorialmod.util.interfaces.IHasModel;
import mod.colbaskerville.tutorialmod.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class BlockOres extends Block implements IHasModel, IMetaName
{
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);

	private String name, dimension;
	
	public BlockOres(String name, String dimension) 
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(4.0F);
		setResistance(6.0F);
		setHarvestLevel("pickaxe", 2, getStateFromMeta(EnumType.RUBY.getMeta()));
		setCreativeTab(Main.tutorialtab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.RUBY));
		
		this.name = name;
		this.dimension = dimension;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}

	
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetaData(meta));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for(EnumHandler.EnumType variant : EnumHandler.EnumType.values())
		{
			items.add(new ItemStack (this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public String getSpecialName(ItemStack stack)
	{
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels()
	{
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + this.dimension + "_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}



	public void getHarvestLevel() {
		// TODO Auto-generated method stub
		
	}
}
