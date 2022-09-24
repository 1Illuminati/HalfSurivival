package halfSurvival;

import halfSurvival.command.AbstractCommand;
import halfSurvival.command.TestCommand;
import halfSurvival.event.NewBlockBreakEvent;
import halfSurvival.event.NewEnchantEvent;
import halfSurvival.item.enchant.HalfSurvivalEnchant;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HalfSurvival extends JavaPlugin {
    public static final String pluginName = "HalfSurvival-1.19.2";
    private static Plugin plugin;
    private static boolean reload = true;

    @Override
    public void onEnable() {
        HalfSurvival.plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        HalfSurvivalEnchant.BLAST_FURNACE.getName();
        registerCommand();
        registerEvent();
        sendLog("§9§m                              ");
        sendLog("");
        sendLog("§9" + pluginName + " enable");
        sendLog("");
        sendLog("§9§m                              ");
        reload = false;
    }

    @Override
    public void onDisable() {
        reload = true;
        sendLog("§9§m                              ");
        sendLog("");
        sendLog("§9" + pluginName + " disable");
        sendLog("");
        sendLog("§9§m                              ");
    }



    public void setCommand(AbstractCommand command) {
        this.getCommand(command.getCommand()).setExecutor(command);
    }
    public void registerCommand() {
        setCommand(new TestCommand());
    }

    public void registerEvent() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new NewBlockBreakEvent(), this);
        pm.registerEvents(new NewEnchantEvent(), this);
    }

    public static void sendLog(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage("[" + pluginName + "] " + message);
    }

    public static Plugin getPlugin() {
        return HalfSurvival.plugin;
    }

    public static boolean getReload() {
        return HalfSurvival.reload;
    }
}
