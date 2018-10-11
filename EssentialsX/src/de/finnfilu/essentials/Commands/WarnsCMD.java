package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WarnsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("warns")) {
            if (sender instanceof Player) {
                if (args.length == 0) {

                    File file = new File("plugins//Essentials//playerdata//" + p.getName() + ".yml");
                    if (!file.exists()) {
                        p.sendMessage(Data.pre + "§7Aktuelle Warns: §e0");
                    } else {

                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                        String warns = cfg.getString("warns");
                        p.sendMessage(Data.pre + "§7Aktuelle Warns: §e" + warns);

                    }
                } else
                    p.sendMessage(Data.pre + "§cBitte benutze: §e/warns");
            } else
                Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
        }

        return false;
    }
}