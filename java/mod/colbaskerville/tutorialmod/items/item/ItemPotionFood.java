package mod.colbaskerville.tutorialmod.items.item;

import java.util.List;

import mod.colbaskerville.tutorialmod.Main;
import mod.colbaskerville.tutorialmod.util.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLLog;

public class ItemPotionFood extends ItemFood {

    public final float saturation;


    public ItemPotionFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(CreativeTabs.FOOD);

        this.saturation = saturation;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    public ItemPotionFood addDefaultSpeedPotionEffect() {
        setAlwaysEdible();

        final Potion potion = Potion.getPotionFromResourceLocation("speed");
        if (potion == null) {
            FMLLog.bigWarning("Could not set potion effect.");
            return this;
        }
        setPotionEffect(new PotionEffect(potion, 600, 0), 0.8F);

        return this;
    }

}
