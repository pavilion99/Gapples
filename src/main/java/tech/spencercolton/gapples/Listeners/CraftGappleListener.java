package tech.spencercolton.gapples.Listeners;

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

        if(!Gapples.recipes.contains(r))
            return;

        assert r instanceof ShapelessRecipe;

        ShapelessRecipe sr = (ShapelessRecipe)r;

        List<ItemStack> ingredients = sr.getIngredientList();

        assert ingredients.size() == 2;

        for(ItemStack i : ingredients) {
            if(i.getType() != Material.POTION)
                return;

            Potion p = Potion.fromItemStack(i);

            ItemStack gapple = e.getInventory().getResult();
            gapple.getItemMeta().setLore(Collections.singletonList(p.getType().toString().replace("_" , " ") + " Gapple"));
            GappleManager.addGapple(gapple, p);
            e.getInventory().setResult(gapple);
        }
    }

}
