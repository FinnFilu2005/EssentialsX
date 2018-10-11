package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("unmute")) {
            if (p.hasPermission("Essentials.unmute")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {
                            if(PMuteCMD.playerstatus.contains(p.getName())) {

                                PMuteCMD.playerstatus.remove(Bukkit.getPlayer(args[0]).getName());
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Du wurdest von §e" + p.getName() + " §7enmuted.");
                                p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 entmuted.");
                                PMuteCMD.playerstatus.remove(p.getName());

                            } else
                                p.sendMessage(Data.pre + "§cDieser Spieler ist nicht gemuted.");
                        }
                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/unmute <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
