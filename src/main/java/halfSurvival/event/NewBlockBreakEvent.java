package halfSurvival.event;

import doublePlugin.item.ItemBuilder;
import doublePlugin.util.DoubleMath;
import halfSurvival.HalfSurvival;
import halfSurvival.item.enchant.HalfSurvivalEnchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.HashMap;
import java.util.Iterator;

public class NewBlockBreakEvent implements Listener {
    private static final HashMap<Material, FurnaceRecipe> furnaceRecipeMap = new HashMap<>();

    public NewBlockBreakEvent() {
        for (Iterator<Recipe> it = Bukkit.recipeIterator(); it.hasNext(); ) {
            Recipe recipe = it.next();
            if (recipe instanceof FurnaceRecipe) {
                FurnaceRecipe furnaceRecipe = (FurnaceRecipe) recipe;
                furnaceRecipeMap.put(furnaceRecipe.getInput().getType(), furnaceRecipe);
            }
        }
    }


    @EventHandler
    public void newBlockBreakEvent(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        int blastFurnaceLevel = itemStack.getEnchantmentLevel(HalfSurvivalEnchant.BLAST_FURNACE);
        HalfSurvival.sendLog("blastFurnaceLevel: " + blastFurnaceLevel);

        if (blastFurnaceLevel >= 1) {
            HalfSurvival.sendLog("pass");
            for (ItemStack dropItem : block.getDrops()) {
                Material dropType = itemStack.getType();
                HalfSurvival.sendLog("repeat" + dropType.name());

                if (furnaceRecipeMap.containsKey(dropType)) {
                    FurnaceRecipe recipe = furnaceRecipeMap.get(dropType);
                    HalfSurvival.sendLog("repeat2");

                    if (DoubleMath.per(blastFurnaceLevel * 0.33)) {
                        HalfSurvival.sendLog("drop");
                        event.setDropItems(false);
                        HalfSurvival.sendLog("drop1");
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(recipe.getResult()).setAmount(dropItem.getAmount()).make());
                        HalfSurvival.sendLog("success");
                    }
                }
            }
        }


    }
}
