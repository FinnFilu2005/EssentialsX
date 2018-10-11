package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("kill")) {
            if(p.hasPermission("Essentials.kill")) {
                if(sender instanceof Player) {
                    if(args.length == 1) {
                        if(Bukkit.getPlayer(args[0]) != null) {

                            Bukkit.getPlayer(args[0]).setHealth(0);
                            p.sendMessage(Data.pre + "§7Töte §e" + Bukkit.getPlayer(args[0]).getName() + "§7.");

                        } else
                            p.sendMessage(Data.pre + Data.noton);

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/kill <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
