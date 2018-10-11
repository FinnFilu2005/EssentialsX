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

public class TpHereCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tphere")) {
            if (p.hasPermission("Essentials.tphere")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            Bukkit.getPlayer(args[0]).teleport(p.getLocation());
                            Bukkit.getPlayer(args[0]).playSound(Bukkit.getPlayer(args[0]).getLocation(), Sound.LEVEL_UP, 1, 1);
                            Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Teleportiere...");
                            p.sendMessage(Data.pre + "§7Teleportiere §e" + Bukkit.getPlayer(args[0]).getName() + "§7...");
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/tphere <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
