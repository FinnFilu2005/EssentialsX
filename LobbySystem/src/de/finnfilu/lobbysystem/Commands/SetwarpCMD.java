package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetwarpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        File file = new File("plugins//LobbySystem//warps.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                p.sendMessage(Main.getInstance().getError());
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            if (p.hasPermission("LobbySystem.Setspawn")) {
                if (!(sender instanceof Player)) {
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotplayer());
                } else {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("spawn"))  {

                            cfg.set("Spawn.World", p.getLocation().getWorld().getName());
                            cfg.set("Spawn.X", p.getLocation().getX());
                            cfg.set("Spawn.Y", p.getLocation().getY());
                            cfg.set("Spawn.Z", p.getLocation().getZ());
                            cfg.set("Spawn.Yaw", p.getLocation().getYaw());
                            cfg.set("Spawn.Pitch", p.getLocation().getPitch());

                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                p.sendMessage(Main.getInstance().getError());
                            }

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast den §eSpawn §7gesetzt.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("warp1")) {

                            cfg.set("Warp1.World", p.getLocation().getWorld().getName());
                            cfg.set("Warp1.X", p.getLocation().getX());
                            cfg.set("Warp1.Y", p.getLocation().getY());
                            cfg.set("Warp1.Z", p.getLocation().getZ());
                            cfg.set("Warp1.Yaw", p.getLocation().getYaw());
                            cfg.set("Warp1.Pitch", p.getLocation().getPitch());

                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                p.sendMessage(Main.getInstance().getError());
                            }

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast den ersten §eWarp §7gesetzt.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("warp2")) {

                                cfg.set("Warp2.World", p.getLocation().getWorld().getName());
                                cfg.set("Warp2.X", p.getLocation().getX());
                                cfg.set("Warp2.Y", p.getLocation().getY());
                            cfg.set("Warp2.Z", p.getLocation().getZ());
                            cfg.set("Warp2.Yaw", p.getLocation().getYaw());
                            cfg.set("Warp2.Pitch", p.getLocation().getPitch());

                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                p.sendMessage(Main.getInstance().getError());
                            }

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast den zweiten §eWarp §7gesetzt.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("warp3")) {

                            cfg.set("Warp3.World", p.getLocation().getWorld().getName());
                            cfg.set("Warp3.X", p.getLocation().getX());
                            cfg.set("Warp3.Y", p.getLocation().getY());
                            cfg.set("Warp3.Z", p.getLocation().getZ());
                            cfg.set("Warp3.Yaw", p.getLocation().getYaw());
                            cfg.set("Warp3.Pitch", p.getLocation().getPitch());

                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                p.sendMessage(Main.getInstance().getError());
                            }

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast den dritten §eWarp §7gesetzt.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("warp4")) {

                            cfg.set("Warp4.World", p.getLocation().getWorld().getName());
                            cfg.set("Warp4.X", p.getLocation().getX());
                            cfg.set("Warp4.Y", p.getLocation().getY());
                            cfg.set("Warp4.Z", p.getLocation().getZ());
                            cfg.set("Warp4.Yaw", p.getLocation().getYaw());
                            cfg.set("Warp4.Pitch", p.getLocation().getPitch());

                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                p.sendMessage(Main.getInstance().getError());
                            }

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast den vierten §eWarp §7gesetzt.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        }

                    } else if (args.length == 0) {

                        p.sendMessage(Main.getInstance().getPrefix() + "§7--- §cMögliche Warps §7---");
                        p.sendMessage(Main.getInstance().getPrefix() + "               §bSpawn");
                        p.sendMessage(Main.getInstance().getPrefix() + "               §bWarp1");
                        p.sendMessage(Main.getInstance().getPrefix() + "               §bWarp2");
                        p.sendMessage(Main.getInstance().getPrefix() + "               §bWarp3");
                        p.sendMessage(Main.getInstance().getPrefix() + "               §bWarp4");
                        p.sendMessage(Main.getInstance().getPrefix() + "§7--- §cMögliche Warps §7---");

                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/setwarp <Warp>");
                }
            } else
                p.sendMessage(Main.getInstance().getNoperms());
        }
        return false;
    }
}
