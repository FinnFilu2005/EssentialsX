package de.finnfilu.reportsystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.reportsystem.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("report")) {
            if (sender instanceof Player) {
                if (args.length == 2) {

                    p.sendMessage(Data.pre + "§7Du hast §e" + args[0] + "§7 wegen §e" + args[1] + " §7reported.");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("ReportSystem.getreports")) {
                            all.sendMessage(Data.pre + "§e" + args[0] + " §8» §c" + args[1]);
                            all.sendMessage(Data.pre + "§7Nutze §e/spec <Spieler>");
                        }

                    }

                } else
                    p.sendMessage(Data.pre + "§cBitte benutze: §e/report <Spieler> <Grund>");
            } else
                Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
        }

        return false;
    }
}
