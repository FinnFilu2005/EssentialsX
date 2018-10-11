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

public class FlyCMD implements CommandExecutor {

    public static ArrayList<String> fp = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (p.hasPermission("Essentials.Fly")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {

                        if (!fp.contains(p.getName())) {

                            fp.add(p.getName());
                            p.setAllowFlight(true);
                            p.sendMessage(Data.pre + "§7Flugmodus §aaktiviert§7.");
                            p.setHealth(20);
                            p.setFoodLevel(20);

                        } else if (fp.contains(p.getName())) {

                            fp.remove(p.getName());
                            p.setAllowFlight(false);
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(Data.pre + "§7Flugmodus §cdeaktiviert§7.");

                        }
                    } else if (args.length == 1) {
                        String t = args[0];

                        if (Bukkit.getPlayer(t) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            if (!fp.contains(Bukkit.getPlayer(t).getName())) {

                                fp.add(Bukkit.getPlayer(t).getName());
                                Bukkit.getPlayer(t).setAllowFlight(true);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Flugmodus §aaktiviert§7.");
                                p.sendMessage(Data.pre + "§e" + Bukkit.getPlayer(t).getName() + "'s §7Flugmodus §aaktiviert§7.");

                            } else if (fp.contains(Bukkit.getPlayer(t).getName())) {

                                fp.remove(Bukkit.getPlayer(t).getName());
                                Bukkit.getPlayer(t).setAllowFlight(false);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Flugmodus §cdeaktiviert§7.");
                                p.sendMessage(Data.pre + "§e" + Bukkit.getPlayer(t).getName() + "'s §7Flugmodus §cdeaktiviert§7.");
                            }

                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/fly <Spieler>");

                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        } else
            p.sendMessage(Data.pre + Data.noperms);

        return false;
    }


}

