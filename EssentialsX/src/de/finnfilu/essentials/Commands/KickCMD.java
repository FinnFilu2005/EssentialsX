package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("kick")) {
            if(p.hasPermission("Essentials.kick")) {
                if(sender instanceof Player) {
                    if(args.length == 2) {

                        Bukkit.getPlayer(args[0]).kickPlayer(Data.pre + "§cDu wurdest vom Server gekickt! \n \n §7Ersteller: §e " + p.getName() + "\n§7Grund: §e" + args[1]);
                        p.sendMessage(Data.pre + "§e" + args[0] + " §7wurde gekickt.");

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/kick <Spieler> <Grund>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
