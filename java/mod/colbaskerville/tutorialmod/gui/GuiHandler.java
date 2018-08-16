package mod.colbaskerville.tutorialmod.gui;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUIID_MARKET = 0;
	public static final int GUIID_SHIPPING_BIN = 1;
	public static final int GUIID_APIARY = 2;
	public static final int GUIID_PRESSER = 3;
	public static final int GUIID_GROUND_TRAP = 4;
	public static final int GUIID_WATER_TRAP = 5;
	public static final int GUIID_WATERFILTER = 6;
	public static final int GUIID_GRINDER = 7;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		
		/*else if (ID == GUIID_SEED_BAG) {
			return new ContainerSeedBag(player, player.inventory, new ItemPamSeedBag(getStack(player)));
		}
		else if (ID == GUIID_CROP_BAG) {
			return new ContainerCropBag(player, player.inventory, new ItemPamCropBag(getStack(player)));
		}
		else if (ID == GUIID_SAPLING_BAG) {
			return new ContainerSaplingBag(player, player.inventory, new ItemPamSaplingBag(getStack(player)));
		}*/
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		return null;
	}
	
	/*static ItemStack getStack(EntityPlayer p) {
        if (p.getHeldItemMainhand() != null
                && p.getHeldItemMainhand().getItem() instanceof Bag) {
            return p.getHeldItemMainhand();
        } else {
            return p.getHeldItemOffhand();
        }
    }*/
}
