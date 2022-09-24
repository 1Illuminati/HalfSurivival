package halfSurvival.item.enchant;

import doublePlugin.item.ItemFunc;
import halfSurvival.HalfSurvival;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class BlastFurnace extends CustomEnchant {
    public BlastFurnace() {
        super(new NamespacedKey(HalfSurvival.getPlugin(), "blast_furnace"));
    }

    @Override
    public String getName() {
        return "blast_furnace";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TOOL;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return other != Enchantment.SILK_TOUCH && other != Enchantment.LUCK;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return ItemFunc.checkPickaxe(item.getType());
    }
}
