package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BurnCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("burn")) {
            if(p.hasPermission("Essentials.burn")) {
                if(sender instanceof Player) {
                    if(args.length == 2) {

                        Bukkit.getPlayer(args[0]).setFireTicks(Integer.parseInt(args[1]) * 20);
                        p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 angebrannt!");

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/burn <Spieler> <Zeitangabe>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
