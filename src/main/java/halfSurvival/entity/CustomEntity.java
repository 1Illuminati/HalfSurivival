package halfSurvival.entity;

import doublePlugin.util.DoubleMath;
import halfSurvival.HalfSurvival;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomEntity {
    private static final String MOB_TYPE = "mobType";
    public void setData(LivingEntity livingEntity) {
        if(livingEntity instanceof Player) {
            return;
        }

        EntityType type = livingEntity.getType();
        int level = getLevel(livingEntity);
        MobType mobType = getMobType(type);
        Location loc = livingEntity.getLocation();
        livingEntity.setMetadata(MOB_TYPE, mobType.fixedMetadataValue);
        livingEntity.setMaxHealth((level - 1) * 3 * mobType.healthAmplifier + livingEntity.getMaxHealth());
        livingEntity.setHealth(livingEntity.getMaxHealth());
        livingEntity.setCustomNameVisible(true);
        livingEntity.setCustomName("§" + mobType.color + " Lv : " + level + " " + livingEntity.getType());

        if (mobType == MobType.MINI_BOSS) {
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1));
            Bukkit.broadcastMessage("§c§m          §c 미니보스 스폰! §c§m          ");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§c" + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ() + " 에 미니보스가 스폰되었습니다！");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§c§m          §c 미니보스 스폰! §c§m          ");
        }
    }

    private MobType getMobType(EntityType entityType) {
        switch(entityType) {
            case ENDER_DRAGON, WITHER, WARDEN -> {
                return MobType.BOSS;
            }
            case ELDER_GUARDIAN, RAVAGER, IRON_GOLEM -> {
                return MobType.MIDDLE_BOSS;
            }
            default -> {
                if(DoubleMath.per(0.2)) {
                    return MobType.MINI_BOSS;
                } else {
                    return MobType.NORMAL;
                }
            }
        }
    }

    private int getLevel(LivingEntity livingEntity) {
        Location loc = livingEntity.getLocation();
        int result = getBiomeLevel(loc.getWorld().getBiome(loc));

        if (loc.getY() <= 48) {
            result = (int) (DoubleMath.rand(3) + 50 + (10 * (loc.getY() / -16)));
        }

        if (livingEntity instanceof Animals || livingEntity instanceof Villager) {
            if(!(livingEntity instanceof Hoglin)) {
                result =  DoubleMath.rand(5) + 1;
            }
        } else if (livingEntity instanceof Fish) {
            result =  DoubleMath.rand(5) + 1;
        }

        switch (livingEntity.getType()) {
            case WITHER -> result = 80;
            case ENDER_DRAGON -> result = 100;
            case WARDEN -> result = 120;
            case ELDER_GUARDIAN -> result = 60;
            case RAVAGER, IRON_GOLEM -> result = 40;
        }

        return result;
    }

    public int getBiomeLevel(Biome biome) {
        switch (biome) {
            case BAMBOO_JUNGLE :
            case BASALT_DELTAS :
            case BEACH :
            case BIRCH_FOREST :
            case CRIMSON_FOREST :
            case CUSTOM :
            case DARK_FOREST :
            case DEEP_COLD_OCEAN :
            case DEEP_DARK :
            case DEEP_FROZEN_OCEAN :
            case DEEP_LUKEWARM_OCEAN :
            case DEEP_OCEAN :
            case COLD_OCEAN :
            case FROZEN_OCEAN :
            case DESERT :
            case DRIPSTONE_CAVES :
            case END_BARRENS :
            case END_HIGHLANDS :
            case END_MIDLANDS :
            case FLOWER_FOREST :
            case FOREST :
            case FROZEN_PEAKS :
            case FROZEN_RIVER :
            case GROVE :
            case ICE_SPIKES :
            case JAGGED_PEAKS :
            case JUNGLE :
            case LUKEWARM_OCEAN :
            case LUSH_CAVES :
            case MANGROVE_SWAMP :
            case MEADOW :
            case MUSHROOM_FIELDS :
            case NETHER_WASTES :
            case OCEAN :
            case OLD_GROWTH_BIRCH_FOREST :
            case OLD_GROWTH_PINE_TAIGA :
            case OLD_GROWTH_SPRUCE_TAIGA :
            case PLAINS :
            case RIVER :
            case SAVANNA :
            case SAVANNA_PLATEAU :
            case SMALL_END_ISLANDS :
            case SNOWY_BEACH :
            case SNOWY_PLAINS :
            case SNOWY_SLOPES :
            case SNOWY_TAIGA :
            case SOUL_SAND_VALLEY :
            case SPARSE_JUNGLE :
            case STONY_PEAKS :
            case STONY_SHORE :
            case SUNFLOWER_PLAINS :
            case SWAMP :
            case TAIGA :
            case THE_END :
            case THE_VOID :
            case WARM_OCEAN :
            case WARPED_FOREST :
            case WINDSWEPT_FOREST :
            case WINDSWEPT_GRAVELLY_HILLS :
            case WINDSWEPT_HILLS :
            case WINDSWEPT_SAVANNA :
            case ERODED_BADLANDS :
            case BADLANDS :
            case WOODED_BADLANDS : return 10;
            default :
                throw new IllegalStateException("Unexpected value: " + biome);
        }
    }

    public enum MobType {
        NORMAL(1, 1, 'f'), MINI_BOSS(3, 2, 'a'), MIDDLE_BOSS(5, 3, '9'), BOSS(10, 5, '4');

        public final FixedMetadataValue fixedMetadataValue = new FixedMetadataValue(HalfSurvival.getPlugin(), this);
        public final int healthAmplifier;
        public final int attackAmplifier;
        public final char color;

        MobType(int healthAmplifier, int attackAmplifier, char color) {
            this.healthAmplifier = healthAmplifier;
            this.attackAmplifier = attackAmplifier;
            this.color = color;
        }
        public static MobType getMobType(LivingEntity livingEntity) {
            if(livingEntity.hasMetadata(MOB_TYPE)) {
                return (MobType) livingEntity.getMetadata(MOB_TYPE).get(0).value();
            } else {
                return null;
            }
        }
    }
}
