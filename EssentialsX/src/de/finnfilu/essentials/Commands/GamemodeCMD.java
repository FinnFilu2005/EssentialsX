package de.finnfilu.essentials.Commands;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import de.finnfilu.essentials.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (p.hasPermission("Essentials.Gamemode")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        if (args[0].equalsIgnoreCase("0")) {

                            p.setGameMode(GameMode.SURVIVAL);
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(Data.pre + "§7Setze Spielmodus auf §eÜberleben§7.");

                        } else if (args[0].equalsIgnoreCase("1")) {

                            p.setGameMode(GameMode.CREATIVE);
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(Data.pre + "§7Setze Spielmodus auf §eKreativ§7.");

                        } else if (args[0].equalsIgnoreCase("2")) {

                            p.setGameMode(GameMode.ADVENTURE);
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(Data.pre + "§7Setze Spielmodus auf §eAbenteuer§7.");

                        } else if (args[0].equalsIgnoreCase("3")) {

                            p.setGameMode(GameMode.SPECTATOR);
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(Data.pre + "§7Setze Spielmodus auf §eZuschauer§7.");
                        }

                    } else
                        Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
                } else if (args.length == 2) {
                    if (sender instanceof Player) {
                        String t = args[1];

                        if (Bukkit.getPlayer(args[1]) != null) {
                            if (args[0].equalsIgnoreCase("0")) {

                                Bukkit.getPlayer(t).setGameMode(GameMode.SURVIVAL);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Setze Spielmodus auf §eÜberleben§7.");
                                p.sendMessage(Data.pre + "§7Setze §e" + Bukkit.getPlayer(t).getDisplayName() + "'s §7Spielmodus auf §eÜberleben§7.");

                            } else if (args[0].equalsIgnoreCase("1")) {

                                Bukkit.getPlayer(t).setGameMode(GameMode.CREATIVE);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Setze Spielmodus auf §eKreativ§7.");
                                p.sendMessage(Data.pre + "§7Setze §e" + Bukkit.getPlayer(t).getDisplayName() + "'s §7Spielmodus auf §eKreativ§7.");

                            } else if (args[0].equalsIgnoreCase("2")) {

                                Bukkit.getPlayer(t).setGameMode(GameMode.ADVENTURE);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Setze Spielmodus auf §eAbenteuer§7.");
                                p.sendMessage(Data.pre + "§7Setze §e" + Bukkit.getPlayer(t).getDisplayName() + "'s §7Spielmodus auf §eAbenteuer§7.");

                            } else if (args[0].equalsIgnoreCase("3")) {

                                Bukkit.getPlayer(t).setGameMode(GameMode.SPECTATOR);
                                Bukkit.getPlayer(t).setHealth(20);
                                Bukkit.getPlayer(t).setFoodLevel(20);
                                Bukkit.getPlayer(t).sendMessage(Data.pre + "§7Setze Spielmodus auf §eZuschauer§7.");
                                p.sendMessage(Data.pre + "§7Setze §e" + Bukkit.getPlayer(t).getDisplayName() + "'s §7Spielmodus auf §eZuschauer§7.");

                            }


                        } else
                            p.sendMessage(Data.pre + Data.noton);

                    } else
                        Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
                } else
                    p.sendMessage("§cBitte benutze: §e/gm <Modus> <Spieler>");
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
