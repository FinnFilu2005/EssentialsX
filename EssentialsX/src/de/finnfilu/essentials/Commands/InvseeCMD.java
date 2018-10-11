package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("invsee")) {
            if (p.hasPermission("Essentials.invsee")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            p.openInventory(Bukkit.getPlayer(args[0]).getInventory());
                            p.sendMessage(Data.pre + "§7Öffne Inventar von §e" + Bukkit.getPlayer(args[0]).getName() + "§7.");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/invsee <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
