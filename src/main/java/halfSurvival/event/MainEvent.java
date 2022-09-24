package halfSurvival.event;

import halfSurvival.entity.CustomEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.world.ChunkLoadEvent;

public class MainEvent implements Listener {
    private final CustomEntity customEntity = new CustomEntity();
    private final NewPlayerEvent newPlayerEvent = new NewPlayerEvent();

    @EventHandler
    public void entitySpawnEvent(EntitySpawnEvent event) {
        if(event.getEntity() instanceof LivingEntity && !(event.getEntity() instanceof Player)) {
            customEntity.setData((LivingEntity) event.getEntity());
        }
    }

    @EventHandler
    public void chunkLoadEvent(ChunkLoadEvent event) {
        for(Entity entity : event.getChunk().getEntities()) {
            if(entity instanceof LivingEntity && !(entity instanceof Player)) {
                customEntity.setData((LivingEntity) entity);
            }
        }
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event) {
        newPlayerEvent.newPlayerDeathEvent(event);
    }
}
