package halfSurvival.command;

import doublePlugin.entity.player.NewPlayer;
import halfSurvival.item.enchant.HalfSurvivalEnchant;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand extends AbstractCommand {
    @Override
    public String getCommand() {
        return "test";
    }

    @Override
    public void command(CommandSender sender, String label, String[] args) {
        NewPlayer player = NewPlayer.getNewPlayer((Player) sender);
        ItemStack itemStack = player.getItemInHand();
        Bukkit.broadcastMessage("테스트");
        itemStack.addEnchantment(HalfSurvivalEnchant.BLAST_FURNACE, 3);
        Bukkit.broadcastMessage(itemStack.toString());
    }
}
