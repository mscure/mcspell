package plugin.mcspell; //pc에 따라 build.gradle 확인할 것

import org.bukkit.plugin.java.JavaPlugin;
import plugin.mcspell.command.GUIopen;
import plugin.mcspell.command.help;
import plugin.mcspell.command.givedia;
import plugin.mcspell.event.breakevent;
import plugin.mcspell.event.InvClickEvent;
import plugin.mcspell.event.JoinEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;

public final class Mcspell extends JavaPlugin {
    public static String prefix = ChatColor.GRAY+"["+ChatColor.YELLOW+"테스트"+ChatColor.GRAY+"]";

    private static Mcspell plugin;
    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin Enabled");
        getServer().getPluginManager().registerEvents(new breakevent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginCommand("mcspell-help").setExecutor(new help());
        getServer().getPluginCommand("givedia").setExecutor(new givedia());
        getServer().getPluginCommand("openinv").setExecutor(new GUIopen());


        config.addDefault("display-message", true);
        config.addDefault("message", "hello!");
        config.options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin Disabled");
        saveDefaultConfig();
    }

    public static Mcspell getPlugin() {
      return plugin;
    }
}
