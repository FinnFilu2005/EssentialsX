package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCMD implements CommandExecutor {

    ArrayList<String> vp = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("vanish")) {
            if (p.hasPermission("Essentials.Fly")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {

                        if (!vp.contains(p.getName())) {
                            vp.add(p.getName());
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.hidePlayer(p);
                            }
                            p.sendMessage(Data.pre + "§7Vanish §aaktiviert§7.");
                            p.setHealth(20);
                            p.setFoodLevel(20);

                        } else if (vp.contains(p.getName())) {
                            vp.remove(p.getName());
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(p);
                            }
                            p.sendMessage(Data.pre + "§7Vanish §cdeaktiviert§7.");
                            p.setHealth(20);
                            p.setFoodLevel(20);

                        }

                    } else if (args.length == 1) {
                        String t = args[0];

                        if (Bukkit.getPlayer(t) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            if (!vp.contains(Bukkit.getPlayer(t).getName())) {
                                vp.add(Bukkit.getPlayer(t).getName());
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.hidePlayer(Bukkit.getPlayer(t));
                                }
                                p.sendMessage(Data.pre + "§e" + Bukkit.getPlayer(t).getName() + "'s §7Vanish §aaktiviert§7.");
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Vanish §aaktiviert§7.");
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);

                            } else if (vp.contains(Bukkit.getPlayer(t).getName())) {
                                vp.remove(Bukkit.getPlayer(t).getName());
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.showPlayer(Bukkit.getPlayer(t));
                                }
                                p.sendMessage(Data.pre + "§e" + Bukkit.getPlayer(t).getName() + "'s §7Vanish §cdeaktiviert§7.");
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Vanish §cdeaktiviert§7.");
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                            }
                        }
                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/v <Spieler>");
                } else
                    p.sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
