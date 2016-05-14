package net.creepynations.particles;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bouz on 12-May-16.
 */
public class PlayerManager implements Listener
{
    public File userFile;
    public YamlConfiguration configFile;

    private Core plugin;

    public PlayerManager(Core instance) {
        this.plugin = instance;
    }

    public void createConfig(Player p) {
        String fileName = p.getUniqueId().toString();

        userFile = new File(plugin.getDataFolder() + File.separator + "/users/" + fileName + ".yml"); //file path
        configFile = YamlConfiguration.loadConfiguration(userFile);
        configFile.options().header("Player Particle Effect"); // #Title
        configFile.addDefault("player-name", p.getName()); //register players current name
        configFile.addDefault("particles", "Disable");
        configFile.options().copyDefaults(true);

        try {
            configFile.save(userFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onJoinCreate(PlayerJoinEvent e) {
        createConfig(e.getPlayer());
        try {
            configFile.save(userFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}