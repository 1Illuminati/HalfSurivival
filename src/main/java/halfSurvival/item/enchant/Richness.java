package halfSurvival.item.enchant;

import doublePlugin.item.ItemFunc;
import halfSurvival.HalfSurvival;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Richness extends CustomEnchant {
    public Richness() {
        super(new NamespacedKey(HalfSurvival.getPlugin(), "Richness"));
    }

    @Override
    public String getName() {
        return "RICHNESS";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 0;
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
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return ItemFunc.checkHoe(item.getType());
    }
}
