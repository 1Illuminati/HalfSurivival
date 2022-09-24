package halfSurvival.item.enchant;

import halfSurvival.HalfSurvival;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class ArmorDestruction extends CustomEnchant {

    public ArmorDestruction() {
        super(new NamespacedKey(HalfSurvival.getPlugin(), "ArmorDestruction"));
    }

    @Override
    public String getName() {
        return "ARMOR_DESTRUCTION";
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
        return EnchantmentTarget.WEARABLE;
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
        return true;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }
}
