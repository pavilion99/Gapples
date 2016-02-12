package tech.spencercolton.gapples.Util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;

import java.util.HashMap;

/**
 * @author Spencer Colton
 */
public class GappleManager {

    private static HashMap<ItemStack, Potion> gapples = new HashMap<>();

    public static void addGapple(ItemStack i, Potion p) {
        if(i.getType() != Material.GOLDEN_APPLE || i.getDurability() != (short)1)
            return;

        gapples.put(i, p);
    }

    public static Potion getGappleEffect(ItemStack i) {
        if(i.getType() != Material.GOLDEN_APPLE || i.getDurability() != (short)1)
            return null;

        return gapples.get(i);
    }

}
