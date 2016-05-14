package net.creepynations.particles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Bouz on 14-May-16.
 */
public class Core extends JavaPlugin {

    public void onEnable() {
        registerCommands();
        registerListeners();
    }

    public void onDisable() {

    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Particles(this), this);
        pm.registerEvents(new PlayerManager(this), this);
    }

    public void registerCommands() {
        getCommand("particles").setExecutor(new Particles(this));
    }

    public String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
