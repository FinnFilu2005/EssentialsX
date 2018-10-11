package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("time")) {
            if (p.hasPermission("Essentials.Time")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {

                        if (args[0].equalsIgnoreCase("day")) {

                            Bukkit.getWorld("world").setTime(6000);
                            p.sendMessage(Data.pre + "§7Setze Zeit auf §eTag§7.");

                        } else if (args[0].equalsIgnoreCase("night")) {

                            Bukkit.getWorld("world").setTime(18000);
                            p.sendMessage(Data.pre + "§7Setze Zeit auf §eNacht§7.");

                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/time <day, night>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }


        return false;
    }
}
