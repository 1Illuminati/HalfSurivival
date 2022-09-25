package halfSurvival.item.enchant;

import halfSurvival.HalfSurvival;

public class HalfSurvivalEnchant {
    public static final BlastFurnace BLAST_FURNACE = new BlastFurnace();
    public static final Bleeding BLEEDING = new Bleeding();
    public static final Richness RICHNESS = new Richness();
    public static final ForFun FOR_FUN = new ForFun();

    public static void load() {
        HalfSurvival.sendLog("Enchant load");
    }
}
