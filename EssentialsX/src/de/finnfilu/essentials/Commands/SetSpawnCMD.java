package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetSpawnCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setspawn")) {
            if(p.hasPermission("Essentials.Setspawn")) {
                if(sender instanceof Player) {
                    if(args.length == 0) {

                        File file = new File("plugins//Essentials//spawn.yml");
                        if(!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                        cfg.set("Spawn.World", p.getLocation().getWorld().getName());
                        cfg.set("Spawn.X", p.getLocation().getX());
                        cfg.set("Spawn.Y", p.getLocation().getY());
                        cfg.set("Spawn.Z", p.getLocation().getZ());
                        cfg.set("Spawn.Yaw", p.getLocation().getYaw());
                        cfg.set("Spawn.Pitch", p.getLocation().getPitch());

                        p.sendMessage(Data.pre + "§7Du hast den Spawn gesetzt.");

                        try {
                            cfg.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/setspawn");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
