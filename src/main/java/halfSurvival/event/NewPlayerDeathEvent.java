package halfSurvival.event;

import halfSurvival.entity.player.HalfPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class NewPlayerDeathEvent implements Listener {

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event) {
        HalfPlayer player = HalfPlayer.getHalfPlayer(event.getEntity());

        if (player.getInvSaveCount() > 0) {
            player.addInvSaveCount(-1);
            player.sendMessage("§f인벤토리 보호권을 사용하여 아이템을 잃지 않았습니다!");
            player.sendMessage("§f남은 인벤토리 보호권 : " + player.getInvSaveCount());
            event.setKeepInventory(true);
        }
    }
}
