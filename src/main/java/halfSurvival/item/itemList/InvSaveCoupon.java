package halfSurvival.item.itemList;

import doublePlugin.entity.player.NewPlayer;
import doublePlugin.item.ItemBuilder;
import doublePlugin.item.ItemEvent;
import halfSurvival.entity.player.HalfPlayer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class InvSaveCoupon extends ItemEvent {
    public static final ItemStack itemStack = new ItemBuilder(Material.PAPER).setDisplayName("§f인벤토리 보호권").setLore(Arrays.asList("§f사망시 인벤토리를 1회 보호해줍니다")).make();
    @Override
    public String getCode() {
        return "invSaveCoupon";
    }

    @Override
    public boolean leftClick(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean rightClick(NewPlayer newPlayer) {
        ItemStack itemStack = newPlayer.getInventory().getItemInMainHand();
        itemStack.setAmount(itemStack.getAmount() - 1);
        HalfPlayer.getHalfPlayer(newPlayer).addInvSaveCount(1);
        return true;
    }

    @Override
    public boolean swapHand(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean dropItem(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean shiftLeftClick(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean shiftRightClick(NewPlayer newPlayer) {
        ItemStack itemStack = newPlayer.getInventory().getItemInMainHand();
        HalfPlayer.getHalfPlayer(newPlayer).addInvSaveCount(itemStack.getAmount());
        itemStack.setAmount(0);
        return true;
    }

    @Override
    public boolean shiftSwapHand(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean shiftDropItem(NewPlayer newPlayer) {
        return false;
    }

    @Override
    public boolean checkItem(ItemStack itemStack) {
        return itemStack.equals(InvSaveCoupon.itemStack);
    }
}
