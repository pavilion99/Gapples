package tech.spencercolton.gapples.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.potion.Potion;
import tech.spencercolton.gapples.Gapples;
import tech.spencercolton.gapples.Util.GappleManager;

import java.util.Collections;
import java.util.List;

/**
 * @author Spencer Colton
 */
public class CraftGappleListener implements Listener {

    @EventHandler
    @SuppressWarnings("unused")
    public void onEvent(CraftItemEvent e) {
        Recipe r = e.getRecipe();

        if(!Gapples.recipes.contains(r)) {
            if (Gapples.debug)
                Bukkit.getLogger().info("A player crafted something, but it wasn't a custom Gapple.");
            return;
        }

        assert r instanceof ShapelessRecipe;

        ShapelessRecipe sr = (ShapelessRecipe)r;

        List<ItemStack> ingredients = sr.getIngredientList();

        assert ingredients.size() == 2;

        for(ItemStack i : ingredients) {
            if(i.getType() != Material.POTION)
                return;

            Potion p = Potion.fromItemStack(i);

            if(Gapples.debug) {
                Bukkit.getLogger().info("Potion in crafting bench is of type " + p.getType().toString() + ".");
            }

            ItemStack gapple = e.getInventory().getResult();

            gapple.getItemMeta().setLore(Collections.singletonList(p.getType().toString().replace("_" , " ") + " Gapple"));

            if(Gapples.debug)
                Bukkit.getLogger().info("Lore of new gapple was set to " + p.getType().toString().replace("_" , " ") + " Gapple");

            GappleManager.addGapple(gapple, p);

            if(Gapples.debug)
                Bukkit.getLogger().info("Called GappleManager to add the effects to this gapple when it is eaten");

            e.getInventory().setResult(gapple);

            if(Gapples.debug)
                Bukkit.getLogger().info("Update CraftingBench with custom Gapple.");
        }
    }

}
