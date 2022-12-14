package halfSurvival.event;

import doublePlugin.util.DoubleMath;
import halfSurvival.HalfSurvival;
import halfSurvival.item.enchant.CustomEnchant;
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
        int size = enchantMap.size();
        int costLevel = event.getExpLevelCost();
        enchantMap.clear();

        double per = 100;
        while (DoubleMath.per(per)) {

            int infiniteCheck = 0;
            while (true) {
                Enchantment[] enchantments = Enchantment.values();
                Enchantment enchantment = enchantments[DoubleMath.rand(enchantments.length)];

                if (enchantment.canEnchantItem(event.getItem())) {

                    if (itemStack.getEnchantmentLevel(enchantment) <= 0) {

                        if (!enchantMap.containsKey(enchantment)) {

                            if (!enchantment.isCursed()) {
                                int enchantmentMaxLevel = enchantment.getMaxLevel();
                                int enchantmentLevel = DoubleMath.rand(enchantmentMaxLevel) + 1;

                                if (enchantmentLevel != enchantmentMaxLevel) {
                                    if (DoubleMath.per(costLevel * 0.03)) {
                                        enchantmentLevel++;
                                    }
                                }

                                if (enchantment instanceof CustomEnchant) {
                                    CustomEnchant customEnchant = (CustomEnchant) enchantment;
                                    customEnchant.unSafeEnchantItem(itemStack, enchantmentLevel);
                                    HalfSurvival.sendLog("CustomEnchant - " + customEnchant.getName() + " : " + enchantmentLevel);
                                } else {
                                    itemStack.addUnsafeEnchantment(enchantment, enchantmentLevel);
                                    HalfSurvival.sendLog("Enchant - " + enchantment.getName() + " : " + enchantmentLevel);
                                }
                                break;
                            }
                        }
                    }
                }

                if (++infiniteCheck >= 300) {
                    break;
                }
            }

            per -= 20 * (7 - (costLevel * 0.2));
        }
    }
}
