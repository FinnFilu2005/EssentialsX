package de.finnfilu.chatmanager.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.chatmanager.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MuteCMD implements CommandExecutor {

    public static ArrayList<String> playerstatus = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("pmute")) {
            if (p.hasPermission("ChatManager.pmute")) {
                if (sender instanceof Player) {
                    if (args.length == 2) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {
                            p.sendMessage(Data.pre + "§7Du hast§e" + args[0] + " §7wegen §e" + " §7gemuted.");
                            Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Du wurdest wegen §e" + args[1] + " §7gemuted.");
                            playerstatus.add(Bukkit.getPlayer(args[0]).getName());
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/pmute <Spieler> <Grund>");
                } else
                    sender.sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
