package halfSurvival.entity.player;

import doublePlugin.entity.player.NewPlayer;
import doublePlugin.util.scoreBoard.ScoreBoardHelper;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class HalfPlayer extends HalfPlayerEx {
    private static final HashMap<UUID, HalfPlayer> halfPlayerMap = new HashMap<>();
    private static final String INV_SAVE_COUNT = "invSaveCount";

    public static HalfPlayer getHalfPlayer(Player player) {
        return getHalfPlayer(NewPlayer.getNewPlayer(player));
    }

    public static HalfPlayer getHalfPlayer(NewPlayer player) {
        UUID uuid = player.getUniqueId();
        if(!halfPlayerMap.containsKey(uuid)) {
            halfPlayerMap.put(uuid, new HalfPlayer(player));
        }

        return halfPlayerMap.get(uuid);
    }

    private HalfPlayer(NewPlayer player) {
        super(player);
        ScoreBoardHelper scoreBoard = super.getScoreBoardHelper();
        scoreBoard.setTitle("§f[Name] Server");
        scoreBoard.setSlot(5, "§f§m                          ");
        scoreBoard.setSlot(4, "§7Player§f: " + player.getName());
        scoreBoard.setSlot(3, "§dLevel§f: 1");
        scoreBoard.setSlot(2, "§2Exp§f: 0/0");
        scoreBoard.setSlot(1, "§f§m                          ");
    }

    public void setInvSaveCount(int count) {
        super.setIntegerValue(INV_SAVE_COUNT, count);
    }

    public int getInvSaveCount() {
        return super.getIntegerValue(INV_SAVE_COUNT);
    }

    public void addInvSaveCount(int count) {
        this.addIntegerValue(INV_SAVE_COUNT, count);
    }
}
