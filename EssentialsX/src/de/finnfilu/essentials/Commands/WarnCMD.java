package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WarnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("warn")) {
            if (p.hasPermission("Essentials.warn")) {
                if (sender instanceof Player) {
                    if (args.length == 2) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            File file = new File("plugins//Essentials//playerdata//" + Bukkit.getPlayer(args[0]).getName() + ".yml");
                            if(!file.exists()) {
                                try {
                                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                                    file.createNewFile();
                                    cfg.set("warns", "0");
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                            if(cfg.getString("warns").equals("0") || cfg.getString("warns").equals(null)) {

                                p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 verwarnt." );
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cDu wurdest verwarnt!");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cGrund: §e" + args[1]);
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cAktuelle Warns: §e1");
                                cfg.set("warns", "1");
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            } else if(cfg.getString("warns").equals("1")) {

                                p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 verwarnt." );
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cDu wurdest verwarnt!");
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cGrund: §e" + args[1]);
                                Bukkit.getPlayer(args[0]).sendMessage(Data.pre + "§cAktuelle Warns: §e2");
                                cfg.set("warns", "2");
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            } else if(cfg.getString("warns").equals("2")) {

                                p.sendMessage(Data.pre + "§7Du hast §e" + Bukkit.getPlayer(args[0]).getName() + "§7 verwarnt." );

                                Bukkit.getPlayer(args[0]).kickPlayer(Data.pre + "§4Du wurdest vom Server gebannt! \n \n §7Grund: §eMaximale Warns erreicht \n §7Dauer: §ePermanent");
                                cfg.set("warns", "3");
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/warn <Spieler> <Grund>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }
        return false;
    }
}