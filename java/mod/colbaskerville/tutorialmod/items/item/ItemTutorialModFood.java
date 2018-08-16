package mod.colbaskerville.tutorialmod.items.item;

import java.util.List;

import mod.colbaskerville.tutorialmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemTutorialModFood extends ItemFood {

    public final float saturation;

    public ItemTutorialModFood(int healAmount, float saturation) {
        super(healAmount, saturation, false);

        this.saturation = saturation;
    }

}
