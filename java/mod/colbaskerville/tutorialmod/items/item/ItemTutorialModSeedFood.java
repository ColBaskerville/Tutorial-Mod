package mod.colbaskerville.tutorialmod.items.item;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class ItemTutorialModSeedFood extends ItemSeedFood {

    public final float saturation;

    public ItemTutorialModSeedFood(int healAmount, float saturation, Block crops) {
        super(healAmount, saturation, crops, Blocks.FARMLAND);

        this.saturation = saturation;
    }

}
