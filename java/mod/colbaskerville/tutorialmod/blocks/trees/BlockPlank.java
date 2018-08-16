package mod.colbaskerville.tutorialmod.blocks.trees;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.blocks.item.ItemBlockVariants;
import mod.colbaskerville.tutorialmod.init.ModBlocks;
import mod.colbaskerville.tutorialmod.init.ModItems;
import mod.colbaskerville.tutorialmod.util.interfaces.IHasModel;
import mod.colbaskerville.tutorialmod.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockPlank extends Block implements IHasModel, IMetaName 
{
public static final PropertyEnum<BlockPlank.EnumType> VARIANT = PropertyEnum.<BlockPlank.EnumType>create("variant", BlockPlank.EnumType.class);
	
	public BlockPlank(String name, float hardness, float resistance) 
	{
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(SoundType.WOOD);
		setCreativeTab(Main.tutorialtab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockPlank.EnumType.APPLE));
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	

	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((BlockPlank.EnumType)state.getValue(VARIANT)).getMeta();
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
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, BlockPlank.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((BlockPlank.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static enum EnumType implements IStringSerializable
	{
		APPLE(0, "apple");
		
		private static final BlockPlank.EnumType[] META_LOOKUP = new BlockPlank.EnumType[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumType(int meta, String name) 
		{
			this(meta, name, name);
		}
		
		private EnumType(int meta, String name, String unlocializedName) 
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public int getMeta() 
		{
			return this.meta;
		}
		
		public String getUnlocializedName() 
		{
			return this.unlocializedName;
		}
		
		@Override
		public String toString() 
		{
			return this.name;
		}
		
		public static BlockPlank.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			for(BlockPlank.EnumType customblockplanks$enumtype : values())
			{
				META_LOOKUP[customblockplanks$enumtype.getMeta()] = customblockplanks$enumtype;
			}
		}
		
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < BlockPlank.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(ModBlocks.PLANKS), i, "planks_" + BlockPlank.EnumType.values()[i].getName(), "inventory");
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return BlockPlank.EnumType.values()[stack.getItemDamage()].getName();
	}

}
