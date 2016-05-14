package net.creepynations.particles;

import net.minecraft.server.v1_9_R1.EnumParticle;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Bouz on 12-May-16.
 */
public class Particles implements CommandExecutor, Listener {
    private Core plugin;

    public Particles(Core instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command cannot be executed through console.");
            return true;
        }

        Player p = (Player) sender;

        inventory(p);
        return true;
    }

    public void createStack(Inventory inv, int slot, Material material, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(lore);

        itemMeta.setDisplayName(name);
        itemMeta.setLore(itemLore);

        item.setItemMeta(itemMeta);
        inv.setItem(slot, item);
    }

    public void inventory(Player p) {
        Inventory inv = Bukkit.getServer().createInventory(null, 9*4, "Particle Effects");

        createStack(inv, 0, Material.BLAZE_POWDER, "Flames", "Ever wanted to be on fire?");
        createStack(inv, 1, Material.APPLE, "Hearts", "Feeling the love?");
        createStack(inv, 2, Material.COAL, "Smoke", "Spooky smoke monster!");
        createStack(inv, 3, Material.REDSTONE, "Rainbow", "Weee rainbows & unicorns!");
        createStack(inv, 4, Material.EXP_BOTTLE, "Magic I", "It's magic magic magic!");
        createStack(inv, 5, Material.NETHER_STAR, "Magic II", "Yeaaaah it's magic!");
        createStack(inv, 6, Material.CAKE, "Happy", "I'm happy and you know it!");
        createStack(inv, 7, Material.NOTE_BLOCK, "Musical", "La la la!");
        createStack(inv, 8, Material.SNOW_BALL, "Frosty", "Chilly yet?");
        createStack(inv, 9, Material.ENDER_PEARL, "Purple", "Spooky n stuff");
        createStack(inv, 10, Material.FEATHER, "Sparky", "Can't get more fabulous!");
        createStack(inv, 11, Material.WEB, "Curly", "You keep spinning...");
        createStack(inv, 12, Material.COAL_BLOCK, "Dark", "For those dark ones..");
        createStack(inv, 13, Material.LAVA_BUCKET, "Molten", "Melt out.");
        createStack(inv, 35, Material.BARRIER, "Disable", "Wanna get rid of your particles?");

        p.openInventory(inv);
    }

    @EventHandler
    public void invClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        UUID uuid = e.getWhoClicked().getUniqueId();

        File userFile = new File(plugin.getDataFolder() + File.separator + "/users/" + uuid + ".yml");
        FileConfiguration path = YamlConfiguration.loadConfiguration(userFile);

        String effect = e.getCurrentItem().getItemMeta().getDisplayName();

        if(e.getInventory().getName() != "Particle Effects") {
            return;
        }

        e.setCancelled(true);

        switch(effect) {
            case "Flames":
                path.set("particles", "Flames");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Hearts":
                path.set("particles", "Hearts");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Smoke":
                path.set("particles", "Smoke");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Rainbow":
                path.set("particles", "Rainbow");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Magic I":
                path.set("particles", "Magic I");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Magic II":
                path.set("particles", "Magic II");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Happy":
                path.set("particles", "Happy");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Musical":
                path.set("particles", "Musical");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Frosty":
                path.set("particles", "Frosty");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Purple":
                path.set("particles", "Purple");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Sparky":
                path.set("particles", "Sparky");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Curly":
                path.set("particles", "Curly");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Dark":
                path.set("particles", "Dark");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Molten":
                path.set("particles", "Molten");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Activated '" + effect + "' effect!");
                break;

            case "Disable":
                path.set("particles", "Disable");
                try {
                    path.save(userFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "Disabled effects.");
                break;
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        Location loc = p.getLocation();

        File userFile = new File(plugin.getDataFolder() + File.separator + "/users/" + uuid + ".yml");
        FileConfiguration path = YamlConfiguration.loadConfiguration(userFile);

        String effect = path.getString("particles");

        switch(effect) {
            case "Flames":
                Particle flames = new Particle(
                        EnumParticle.FLAME,
                        loc,
                        true,
                        0.5F,
                        0.5F,
                        0.5F,
                        1,
                        10
                );

                flames.toAll();
                break;

            case "Hearts":
                Particle hearts = new Particle(
                        EnumParticle.HEART,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        6
                );

                hearts.toAll();
                break;

            case "Smoke":
                Particle smoke = new Particle(
                        EnumParticle.SMOKE_NORMAL,
                        loc,
                        true,
                        0.5F,
                        0.5F,
                        0.5F,
                        1,
                        10
                );

                smoke.toAll();
                break;

            case "Rainbow":
                Particle rainbow = new Particle(
                        EnumParticle.REDSTONE,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        25
                );

                rainbow.toAll();
                break;

            case "Magic I":
                Particle magicI = new Particle(
                        EnumParticle.CRIT,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        10
                );

                magicI.toAll();
                break;

            case "Magic II":
                Particle magicII = new Particle(
                        EnumParticle.CRIT_MAGIC,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        10
                );

                magicII.toAll();
                break;

            case "Happy":
                Particle happy = new Particle(
                        EnumParticle.VILLAGER_HAPPY,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        8
                );

                happy.toAll();
                break;

            case "Musical":
                Particle notes = new Particle(
                        EnumParticle.NOTE,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        5
                );

                notes.toAll();
                break;

            case "Frosty":
                Particle frosty = new Particle(
                        EnumParticle.SNOW_SHOVEL,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        3,
                        10
                );

                frosty.toAll();
                break;

            case "Purple":
                Particle purple = new Particle(
                        EnumParticle.DRAGON_BREATH,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        10
                );

                purple.toAll();
                break;

            case "Sparky":
                Particle sparky = new Particle(
                        EnumParticle.FIREWORKS_SPARK,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        10
                );

                sparky.toAll();
                break;

            case "Curly":
                Particle curly = new Particle(
                        EnumParticle.SPELL,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        10
                );

                curly.toAll();
                break;

            case "Dark":
                Particle dark = new Particle(
                        EnumParticle.DAMAGE_INDICATOR,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        10
                );

                dark.toAll();
                break;

            case "Molten":
                Particle molten = new Particle(
                        EnumParticle.LAVA,
                        loc,
                        true,
                        1F,
                        1F,
                        1F,
                        1,
                        5
                );

                molten.toAll();
                break;

            case "Disable":
                break;

            default:
                return;
        }
    }
}
