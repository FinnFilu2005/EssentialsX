package de.finnfilu.reportsystem.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("spec")) {
            if(p.hasPermission("ReportSystem.Spectate")) {
                if(sender instanceof Player) {
                    if(args.length == 1) {



                    }
                }
            }
        }

        return false;
    }
}