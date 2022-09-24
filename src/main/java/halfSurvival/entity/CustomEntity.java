package halfSurvival.entity;

import doublePlugin.util.DoubleMath;
import halfSurvival.HalfSurvival;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Random;

public class CustomEntity {
    public final FixedMetadataValue BOSS_METADATA = new FixedMetadataValue(HalfSurvival.getPlugin(), MobType.BOSS);
    public final FixedMetadataValue MIDDLE_BOSS_METADATA = new FixedMetadataValue(HalfSurvival.getPlugin(), MobType.MIDDLE_BOSS);
    public final FixedMetadataValue MINI_BOSS_METADATA = new FixedMetadataValue(HalfSurvival.getPlugin(), MobType.MINI_BOSS);
    public final FixedMetadataValue NORMAL_METADATA = new FixedMetadataValue(HalfSurvival.getPlugin(), MobType.NORMAL);
    private final Random rand = new Random();
    public void setData(LivingEntity livingEntity) {
        if(livingEntity instanceof Player) {
            return;
        }

        EntityType type = livingEntity.getType();
        int atkAmp = 1;
        int healthAmp = 1;
        switch(type) {
            case ENDER_DRAGON:
            case WITHER:
            case WARDEN:
                livingEntity.setMetadata("MobType", BOSS_METADATA);
            break;
            case ELDER_GUARDIAN:
            case RAVAGER:
            case IRON_GOLEM:
                atkAmp = 3;
                healthAmp = 5;
                livingEntity.setMetadata("MobType", MIDDLE_BOSS_METADATA);
            break;
            default :
                if(DoubleMath.per(0.2)) {
                    atkAmp = 2;
                    healthAmp = 3;
                    livingEntity.setMetadata("MobType", MINI_BOSS_METADATA);

                } else {
                    livingEntity.setMetadata("MobType", NORMAL_METADATA);
                }
        }

        int level = getLevel(livingEntity);
        double maxHealth = livingEntity.getMaxHealth();
        livingEntity.setMaxHealth((level - 1) * 5 * healthAmp + maxHealth);
        livingEntity.setHealth(livingEntity.getMaxHealth());
        AttributeInstance atkInstance = livingEntity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        atkInstance.setBaseValue(atkInstance.getBaseValue() + ((level - 1) * atkAmp));
    }

    private int getLevel(LivingEntity livingEntity) {
        Location loc = livingEntity.getLocation();
        Biome biome = loc.getWorld().getBiome(loc);
        int result = 0;

        if(livingEntity instanceof Animals || livingEntity instanceof Villager) {
            if(!(livingEntity instanceof Hoglin)) {
                return rand.nextInt(5) + 1;
            }
        } else if(livingEntity instanceof Fish) {
            return DoubleMath.rand(5) + 1;
        }

        if(loc.getY() < 60) {
            return DoubleMath.rand(10) + 10;
        }

        switch(biome) {
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
            case WOODED_BADLANDS : result += 10; break;
            default :
                throw new IllegalStateException("Unexpected value: " + biome);
        }

        return result;
    }

    public enum MobType {
        NORMAL, MINI_BOSS, MIDDLE_BOSS, BOSS;
    }
}
