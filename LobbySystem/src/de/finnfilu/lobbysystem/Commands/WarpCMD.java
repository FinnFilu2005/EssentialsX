package de.finnfilu.lobbysystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.lobbysystem.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WarpCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        File file = new File("plugins//LobbySystem//warps.yml");
        if (!file.exists()) {
            p.sendMessage(Main.getInstance().getPrefix() + "§cDieser Warp existiert nicht.");
        } else {

            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            if (cmd.getName().equalsIgnoreCase("warp")) {
                if (!(sender instanceof Player)) {
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getNotplayer());
                } else {
                    if (args.length == 1) {

                        if (args[0].equalsIgnoreCase("Spawn")) {

                            String world = cfg.getString("Spawn.World");
                            int x = cfg.getInt("Spawn.X");
                            int y = cfg.getInt("Spawn.Y");
                            int z = cfg.getInt("Spawn.Z");
                            double yaw = cfg.getDouble("Spawn.Yaw");
                            double pitch = cfg.getDouble("Spawn.Pitch");

                            Location loc = p.getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            p.teleport(loc);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("Warp1")) {

                            String world = cfg.getString("Spawn.World");
                            int x = cfg.getInt("Warp1.X");
                            int y = cfg.getInt("Warp1.Y");
                            int z = cfg.getInt("Warp1.Z");
                            double yaw = cfg.getDouble("Warp1.Yaw");
                            double pitch = cfg.getDouble("Warp1.Pitch");

                            Location loc = p.getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            p.teleport(loc);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("Warp2")) {

                            String world = cfg.getString("Warp2.World");
                            int x = cfg.getInt("Warp2.X");
                            int y = cfg.getInt("Warp2.Y");
                            int z = cfg.getInt("Warp2.Z");
                            double yaw = cfg.getDouble("Warp2.Yaw");
                            double pitch = cfg.getDouble("Warp2.Pitch");

                            Location loc = p.getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            p.teleport(loc);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("Warp3")) {

                            String world = cfg.getString("Warp3.World");
                            int x = cfg.getInt("Warp3.X");
                            int y = cfg.getInt("Warp3.Y");
                            int z = cfg.getInt("Warp3.Z");
                            double yaw = cfg.getDouble("Warp3.Yaw");
                            double pitch = cfg.getDouble("Warp3.Pitch");

                            Location loc = p.getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            p.teleport(loc);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                        } else if (args[0].equalsIgnoreCase("Warp4")) {

                            String world = cfg.getString("Warp4.World");
                            int x = cfg.getInt("Warp4.X");
                            int y = cfg.getInt("Warp4.Y");
                            int z = cfg.getInt("Warp4.Z");
                            double yaw = cfg.getDouble("Warp4.Yaw");
                            double pitch = cfg.getDouble("Warp4.Pitch");

                            Location loc = p.getLocation();
                            loc.setX(x);
                            loc.setY(y);
                            loc.setZ(z);
                            loc.setYaw((float) yaw);
                            loc.setPitch((float) pitch);

                            p.teleport(loc);
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
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/warp <Warp>");
                }
            }
        }
        return false;
    }
}
