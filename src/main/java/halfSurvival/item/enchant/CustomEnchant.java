package halfSurvival.item.enchant;

import halfSurvival.HalfSurvival;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomEnchant extends Enchantment {

    public CustomEnchant(NamespacedKey key) {
        super(key);
        register();
    }

    public void enchantItem(ItemStack itemStack, int level) {
        if (!this.canEnchantItem(itemStack)) {
            throw new IllegalArgumentException("Cannot enchant " + itemStack.getType().name() + " with " + this.getName());
        }

        this.unSafeEnchantItem(itemStack, level);
    }

    public void unSafeEnchantItem(ItemStack itemStack, int level) {
        itemStack.addUnsafeEnchantment(this, level);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = itemMeta.getLore();

        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(ChatColor.GRAY + this.getName() + " " + ((level <= 10) ? getLomeNum(level) : "enchantment.level." + level));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
    }

    private String getLomeNum(int num) {
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                throw new IllegalArgumentException("You can use only 10 under number");
        }
    }

    private void register() {
        if (Enchantment.getByKey(this.getKey()) != null) {
            return;
        }

        try {
            Field acceptingNew = Enchantment.class.getDeclaredField("acceptingNew");
            acceptingNew.setAccessible(true);
            acceptingNew.set(null, true);
            Enchantment.registerEnchantment(this);
            HalfSurvival.sendLog(this.getName() + " Enchantment Register");
            Enchantment.stopAcceptingRegistrations();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
