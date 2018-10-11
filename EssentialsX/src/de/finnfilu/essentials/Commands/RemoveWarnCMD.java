package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RemoveWarnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("removewarn")) {
            if (p.hasPermission("Essentials.removewarn")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            File file = new File("plugins//Essentials//playerdata//" + Bukkit.getPlayer(args[0]).getName() + ".yml");
                            if(!file.exists()) {
                                p.sendMessage(Data.pre + "§cDieser Spieler hat keine Warns§7.");
                            }

                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                            if(cfg.getString("warns").equals("0")) {
                                p.sendMessage(Data.pre + "§cDieser Spieler hat keine Warns§7.");
                            } else if(cfg.getString("warns").equals("1")) {

                                cfg.set("warns", "0");
                                p.sendMessage(Data.pre + "§7Entferne Warn von §e" + Bukkit.getPlayer(args[0]).getName() + "§7.");
                                p.sendMessage(Data.pre + "§7Aktuelle Warns: §e0§7.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Entferne §eeinen §7Warn.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Aktuelle Warns: §e0§7.");

                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            } else if(cfg.getString("warns").equals("2")) {

                                cfg.set("warns", "1");
                                p.sendMessage(Data.pre + "§7Entferne Warn von §e" + Bukkit.getPlayer(args[0]).getName() + "§7.");
                                p.sendMessage(Data.pre + "§7Aktuelle Warns: §e1§7.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Entferne §eeinen §7Warn.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Aktuelle Warns: §e1§7.");

                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            } else if(cfg.getString("warns").equals("3")) {

                                cfg.set("warns", "2");
                                p.sendMessage(Data.pre + "§7Entferne Warn von §e" + Bukkit.getPlayer(args[0]).getName() + "§7.");
                                p.sendMessage(Data.pre + "§7Aktuelle Warns: §e2§7.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Entferne §eeinen §7Warn.");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§7Aktuelle Warns: §e2§7.");

                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/removewarn <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}