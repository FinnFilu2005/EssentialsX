package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PMuteCMD implements CommandExecutor {

    public static ArrayList<String> playerstatus = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("pmute")) {
            if(p.hasPermission("Essentials.pmute")) {
                if(sender instanceof Player) {
                    if(args.length == 2) {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {
                            if(!playerstatus.contains(p.getName())) {

                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Du wurdest wegen §e" + args[1] + " §7gemuted.");
                                p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 wegen §e" + args[1] + "§7 gemuted.");
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                                playerstatus.add(p.getName());

                            } else
                                p.sendMessage(Data.pre + "§cDieser Spieler ist bereits gemuted.");
                        }
                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/pmute <Spieler> <Grund>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
