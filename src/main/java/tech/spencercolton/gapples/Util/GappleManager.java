package tech.spencercolton.gapples.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import tech.spencercolton.gapples.Gapples;

import java.util.HashMap;

/**
 * @author Spencer Colton
 */
public class GappleManager {

    private static HashMap<ItemStack, Potion> gapples = new HashMap<>();

    public static void addGapple(ItemStack i, Potion p) {
        if(i.getType() != Material.GOLDEN_APPLE || i.getDurability() != (short)1) {
            if(Gapples.debug)
                Bukkit.getLogger().info("Tried to register an item with the system that wasn't an enchanted Golden Apple.");
            return;
        }

        gapples.put(i, p);
    }

    public static Potion getGappleEffect(ItemStack i) {
        if(i.getType() != Material.GOLDEN_APPLE || i.getDurability() != (short)1) {
            if(Gapples.debug)
                Bukkit.getLogger().info("Tried to read the effect of an item that wasn't an enchanted Golden Apple");
            return null;
        }

        if(Gapples.debug) {
            String effects = "";
            for(PotionEffect pe : gapples.get(i).getEffects()) {
                effects += pe.toString();
            }
            effects = effects.substring(0, effects.length() - 1);
            Bukkit.getLogger().info("Found " + effects + " as the effect for passed item.");
        }
        return gapples.get(i);
    }

}
