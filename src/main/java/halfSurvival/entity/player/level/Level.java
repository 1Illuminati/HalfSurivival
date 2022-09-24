package halfSurvival.entity.player.level;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    BATTLE(20, 5, 5, 5, 5, 5),
    FARMING(20, 5, 5, 5, 5, 5),
    FISHING(20, 5, 5, 5, 5, 5),
    MINING(20, 5, 5, 5, 5, 5),
    NULL(20, 5, 1, 1, 1, 1);

    private final List<Integer> maxExpList = new ArrayList<>();
    Level(int a, int b, int c, int d, int e, int f) {
        int level = 1;
        maxExpList.add(0);
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                maxExpList.add(c * level * d);
                c+=e;
                level++;
            }
            c+=f;
        }
    }

    public int getMaxExp(int level) {
        return maxExpList.get(level);
    }
}
