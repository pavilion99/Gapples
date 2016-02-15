package tech.spencercolton.gapples;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import tech.spencercolton.gapples.Listeners.CraftGappleListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Spencer Colton
 */
public class Gapples extends JavaPlugin {

    public static boolean craftingAllowed = true;
    public static List<Recipe> recipes = new ArrayList<>();

    public static boolean debug;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        debug = this.getConfig().getBoolean("debug");

        addRecipes();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }

    private static void addRecipes() {
        List<ItemStack> potions = new ArrayList<>();

        for(int i = 8193; i <= 8206; i++) {
            if(i == 8199)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        for(int i = 8225; i <= 8238; i++) {
            if(i == 8231)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        for(int i = 8257; i <= 8270; i++) {
            if(i == 8263)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        for(int i = 16385; i <= 16398; i++) {
            if(i == 16391)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        for(int i = 16417; i <= 16430; i++) {
            if(i == 16423)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        for(int i = 16499; i <= 16462; i++) {
            if(i == 16455)
                continue;

            potions.add(new ItemStack(Material.POTION, 1, (short)i));
        }

        ItemStack i = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);

        for(ItemStack it : potions) {
            ShapelessRecipe sr = new ShapelessRecipe(i);

            sr.addIngredient(1, it.getData());

            sr.addIngredient(1, i.getData());

            recipes.add(sr);

            if(debug) {
                Bukkit.getLogger().info("Added recipe for " + Potion.fromItemStack(it).getType().toString() + " gapple.");
                Bukkit.getLogger().info("Items: " + it.getType().toString() + ":" + it.getDurability() + " and " + i.getType().toString() + ":" + i.getDurability());
            }
        }

        recipes.stream().forEach(Bukkit::addRecipe);
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new CraftGappleListener(), this);
    }

}
