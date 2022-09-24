package halfSurvival.event;

import doublePlugin.util.DoubleMath;
import halfSurvival.item.enchant.HalfSurvivalEnchant;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class NewEnchantEvent implements Listener {
    @EventHandler
    public void newPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {
        event.getOffers()[0] = new EnchantmentOffer(HalfSurvivalEnchant.FOR_FUN, 1, event.getOffers()[0].getCost());
        event.getOffers()[1] = new EnchantmentOffer(HalfSurvivalEnchant.FOR_FUN, 2, event.getOffers()[1].getCost());
        event.getOffers()[2] = new EnchantmentOffer(HalfSurvivalEnchant.FOR_FUN, 3, event.getOffers()[2].getCost());
    }

    @EventHandler
    public void newEnchantEvent(EnchantItemEvent event) {
        Map<Enchantment, Integer> enchantMap = event.getEnchantsToAdd();
        ItemStack itemStack = event.getItem();
        int costLevel = event.getExpLevelCost();
        enchantMap.clear();

        double per = 1;
        int num = 0;
        while (!DoubleMath.per(per)) {

            while (true) {
                Enchantment[] enchantments = Enchantment.values();
                Enchantment enchantment = enchantments[DoubleMath.rand(enchantments.length)];

                if (enchantment.canEnchantItem(event.getItem())) {
                    if (itemStack.getEnchantmentLevel(enchantment) <= 0) {
                        int enchantmentMaxLevel = enchantment.getMaxLevel();
                        int enchantmentLevel = DoubleMath.rand(enchantmentMaxLevel) + 1;

                        if (enchantmentLevel != enchantmentMaxLevel) {
                            if (DoubleMath.per(costLevel * 0.03)) {
                                enchantmentLevel++;
                            }
                        }

                        enchantMap.put(enchantment, enchantmentLevel);
                        break;
                    }
                }
            }

            per -= 0.03 * (30 - costLevel);
            num++;
        }

    }
}
