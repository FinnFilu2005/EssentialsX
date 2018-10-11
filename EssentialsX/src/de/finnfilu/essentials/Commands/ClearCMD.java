package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("clear")) {
            if (p.hasPermission("Essentials. clear")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {

                        p.getInventory().clear();
                        p.sendMessage(Data.pre + "§7Leere Inventar...");

                    } else if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            Bukkit.getPlayer(args[0]).getInventory().clear();
                            Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Leere Inventar...");
                            p.sendMessage(Data.pre + "§7Leere §e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Inventar...");
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/clear <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}