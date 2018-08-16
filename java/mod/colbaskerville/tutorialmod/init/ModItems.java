package mod.colbaskerville.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import mod.colbaskerville.tutorialmod.items.ItemBase;
import mod.colbaskerville.tutorialmod.items.armor.ArmorBase;
import mod.colbaskerville.tutorialmod.items.food.ItemCustomFood;
import mod.colbaskerville.tutorialmod.items.food.ItemRice;
import mod.colbaskerville.tutorialmod.items.tools.RubyHatchet;
import mod.colbaskerville.tutorialmod.items.tools.ToolAxe;
import mod.colbaskerville.tutorialmod.items.tools.ToolHoe;
import mod.colbaskerville.tutorialmod.items.tools.ToolPickaxe;
import mod.colbaskerville.tutorialmod.items.tools.ToolSpade;
import mod.colbaskerville.tutorialmod.items.tools.ToolSword;
import mod.colbaskerville.tutorialmod.items.tools.RubyWarAxe;
import mod.colbaskerville.tutorialmod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 250, 8.0F, 3.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 14,
			new int[] {2, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	public static final ToolMaterial RUBY_WAR_AXE_MATERIAL = EnumHelper.addToolMaterial("ruby_war_axe_material", 2, 350, 9.0F, 2.8F, 50);
	public static final ToolMaterial RUBY_HATCHET_MATERIAL = EnumHelper.addToolMaterial("ruby_hatchet_material", 5, 280, 8.5F, 1.8F, 10);
	
	//Items
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item OBSIDIAN_INGOT = new ItemBase("obsidian_ingot");
	
	//Tools
	public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
	public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
	public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
	
	public static final ItemAxe RUBY_WAR_AXE = new RubyWarAxe("ruby_war_axe", RUBY_WAR_AXE_MATERIAL);
	public static final RubyHatchet RUBY_HATCHET = new RubyHatchet("ruby_hatchet", RUBY_HATCHET_MATERIAL);
	
	//Armor
		public static final Item RUBY_HELMET = new ArmorBase("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
		public static final Item RUBY_CHESTPLATE = new ArmorBase("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
		public static final Item RUBY_LEGGINGS = new ArmorBase("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
		public static final Item RUBY_BOOTS = new ArmorBase("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

	//Food
		public static final Item RICE_BOWL = new ItemCustomFood("rice_bowl", 8, false);
		public static final Item RICE = new ItemRice("rice", 1, false);
}
