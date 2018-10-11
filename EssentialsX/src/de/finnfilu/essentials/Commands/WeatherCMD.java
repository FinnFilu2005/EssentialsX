package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("weather")) {
            if(p.hasPermission("Essentials.Weather")) {
                if(sender instanceof Player) {
                    if(args.length == 1) {

                        if(args[0].equalsIgnoreCase("sun")) {

                            Bukkit.getWorld("world").setStorm(false);
                            p.sendMessage(Data.pre + "§7Setze Wetter auf §eSonnig§7.");

                        } else if(args[0].equalsIgnoreCase("rain")) {

                            Bukkit.getWorld("world").setStorm(true);
                            p.sendMessage(Data.pre + "§7Setze Wetter auf §eRegen§7.");

                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/weather <sun, rain>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
