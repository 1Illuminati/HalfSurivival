package halfSurvival.item;

import doublePlugin.item.ItemBuilder;
import doublePlugin.item.MakeItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum SpecialOre {
    UPGRADE_IRON(new ItemBuilder(Material.IRON_INGOT).setDisplayName("§f강철").setCustomModelData(1).make()), //철재련
    SILVER(new ItemBuilder(Material.IRON_INGOT).setDisplayName("§f은").setCustomModelData(2).make()), //철확률
    WHITE_GOLD(new ItemBuilder(Material.IRON_INGOT).setDisplayName("§f백금").setCustomModelData(3).make()), //금확률
    RED_DIAMOND(new ItemBuilder(Material.IRON_INGOT).setDisplayName("§f").setCustomModelData(4).make()), //다이아확률
    NULL(MakeItem.getAir());
    private final ItemStack itemStack;
    SpecialOre(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItem() {
        return this.itemStack;
    }
}
