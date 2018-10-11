package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SpawnCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                if (args.length == 0) {

                    File file = new File("plugins//Essentials//spawn.yml");
                    if (!file.exists()) {
                        p.sendMessage(Data.pre + "§cDer Spawn existiert nicht!");

                    } else {

                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                        World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
                        double x = cfg.getDouble("Spawn.X");
                        double y = cfg.getDouble("Spawn.Y");
                        double z = cfg.getDouble("Spawn.Z");
                        float yaw = (float) cfg.getDouble("Spawn.Yaw");
                        float pitch = (float) cfg.getDouble("Spawn.Pitch");

                        Location loc = p.getLocation();
                        loc.setWorld(world);
                        loc.setX(x);
                        loc.setY(y);
                        loc.setZ(z);
                        loc.setYaw(yaw);
                        loc.setPitch(pitch);


                        p.teleport(loc);
                        p.sendMessage(Data.pre + "§7Teleportiere...");
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    }
                }

            } else
                p.sendMessage("§cBitte benutze: §e/spawn");
        } else
            Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);

        return false;
    }


}



