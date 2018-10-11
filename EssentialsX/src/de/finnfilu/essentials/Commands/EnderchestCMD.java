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

public class EnderchestCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("enderchest")) {
            if(p.hasPermission("Essentials.enderchest")) {
                if(sender instanceof Player) {
                    if(args.length == 0) {

                        p.openInventory(p.getEnderChest());
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                    } else if(args.length == 1) {

                        p.openInventory(Bukkit.getPlayer(args[0]).getEnderChest());
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/ec <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
