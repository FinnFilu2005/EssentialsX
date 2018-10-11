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
import org.bukkit.potion.PotionEffect;

public class HealCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("heal")) {
            if(p.hasPermission("Essentials.heal")) {
                if(sender instanceof Player) {
                    if(args.length == 0) {


                        p.setHealth(20);
                        p.setFoodLevel(20);
                        p.setFireTicks(0);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                        p.sendMessage(Data.pre + "§7Du wurdest geheilt.");

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/heal");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
