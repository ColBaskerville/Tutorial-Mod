package mod.colbaskerville.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import mod.colbaskerville.tutorialmod.blocks.BlockOres;
import mod.colbaskerville.tutorialmod.blocks.BlockRicePlant;
import mod.colbaskerville.tutorialmod.blocks.PolishedObsidian;
import mod.colbaskerville.tutorialmod.blocks.RubyBlock;
import mod.colbaskerville.tutorialmod.blocks.StoneBasin;
import mod.colbaskerville.tutorialmod.blocks.Table;
import mod.colbaskerville.tutorialmod.blocks.WoodOne;
import mod.colbaskerville.tutorialmod.blocks.WoodThree;
import mod.colbaskerville.tutorialmod.blocks.WoodTwo;
import mod.colbaskerville.tutorialmod.blocks.machines.sinterer.SinteringFurnace;
import mod.colbaskerville.tutorialmod.blocks.trees.BlockLeaf;
import mod.colbaskerville.tutorialmod.blocks.trees.BlockLogs;
import mod.colbaskerville.tutorialmod.blocks.trees.BlockPlank;
import mod.colbaskerville.tutorialmod.blocks.trees.BlockSaplings;
import mod.colbaskerville.tutorialmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ModBlocks {

	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);

	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");

	public static final Block STONE_BASIN = new StoneBasin("stone_basin");
	
	public static final Block POLISHED_OBSIDIAN = new PolishedObsidian("polished_obsidian", Material.IRON);
	
	
	public static final Block TABLE = new Table("table");
	
	public static final Block SINTERING_FURNACE = new SinteringFurnace("sintering_furnace");
	
	
	//Axe Based
	
	public static final Block PLANKS = new BlockPlank("planks", 2.0F, 2.5F);
	public static final Block LOG = new BlockLogs("log");
	public static final Block LEAVES = new BlockLeaf("leaves");
	public static final Block SAPLING = new BlockSaplings("sapling");
	

	
	public static final Block WoodOne = new WoodOne("wood_one", Material.WOOD);
	public static final Block WoodTwo = new WoodTwo("wood_two", Material.WOOD);
	public static final Block WoodThree = new WoodThree("wood_three", Material.WOOD);
	

	
	//Fluids
	
	//Others

	
	//Crops
	public static final Block RICE_PLANT = new BlockRicePlant("rice_plant");

	//Trees (Variants)
	
	

	//Block Instances


	//ItemBlock Instances

}

