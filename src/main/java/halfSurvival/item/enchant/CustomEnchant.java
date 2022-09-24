package halfSurvival.item.enchant;

import halfSurvival.HalfSurvival;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;

public abstract class CustomEnchant extends Enchantment {

    public CustomEnchant(NamespacedKey key) {
        super(key);
        register();
    }

    private void register() {
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
