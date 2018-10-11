package de.finnfilu.coins.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.coins.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class CoinsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("coins")) {

            if (sender instanceof ConsoleCommandSender) {

                if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("add")) {

                        int amount = Integer.parseInt(args[2]);

                        addcoins(Bukkit.getPlayer(args[1]).getName(), amount);
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + " " + amount + " Coins §7hinzugefügt.");

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        int amount = Integer.parseInt(args[2]);

                        removecoins(Bukkit.getPlayer(args[1]).getName(), amount);
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + " " + amount + " Coins §7entfernt.");

                    } else if (args[0].equalsIgnoreCase("set")) {

                        int amount = Integer.parseInt(args[2]);

                        setcoins(Bukkit.getPlayer(args[1]).getName(), amount);
                        Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Kontostand auf §e" + amount + " Coins §7gesetzt");
                    }

                } else if (args.length == 1) {

                    File file = new File("plugins//CoinsSystem//playerdata//" + Bukkit.getPlayer(args[0]).getName() + ".yml");
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            cfg.addDefault("CoinsSystem.Coins", "0");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else if (file.exists()) {

                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                        int amount = cfg.getInt("CoinsSystem.Coins");

                        Bukkit.getConsoleSender().sendMessage("§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Kontostand: §e" + amount);
                    }

                } else
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/coins <add, remove, set> <Spieler> <Zahlenwert>");

                } else if (sender instanceof Player) {
                    final Player p = (Player) sender;

                    if (args.length == 3) {
                        if (args[0].equalsIgnoreCase("add")) {
                            if (p.hasPermission("CoinsSystem.addcoins")) {

                                int amount = Integer.parseInt(args[2]);

                                addcoins(Bukkit.getPlayer(args[1]).getName(), amount);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + " " + amount + " Coins §7hinzugefügt.");

                            } else
                                p.sendMessage(Main.getInstance().getNoperms());
                        } else if (args[0].equalsIgnoreCase("remove")) {
                            if (p.hasPermission("CoinsSystem.removecoins")) {

                                int amount = Integer.parseInt(args[2]);

                                removecoins(Bukkit.getPlayer(args[1]).getName(), amount);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + " " + amount + " Coins §7entfernt.");

                            } else
                                p.sendMessage(Main.getInstance().getNoperms());
                        } else if (args[0].equalsIgnoreCase("set")) {
                            if (p.hasPermission("CoinsSystem.setcoins")) {

                                int amount = Integer.parseInt(args[2]);

                                setcoins(Bukkit.getPlayer(args[1]).getName(), amount);
                                p.sendMessage(Main.getInstance().getPrefix() + "§7Du hast §e" + Bukkit.getPlayer(args[1]).getName() + "'s §7Kontostand auf §e" + amount + " Coins §7gesetzt");
                            } else
                                p.sendMessage(Main.getInstance().getNoperms());
                        }

                    } else if (args.length == 1) {

                        File file = new File("plugins//CoinsSystem//playerdata//" + Bukkit.getPlayer(args[0]).getName() + ".yml");
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                                cfg.addDefault("CoinsSystem.Coins", "0");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else if (file.exists()) {

                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            int amount = cfg.getInt("CoinsSystem.Coins");

                            p.sendMessage(Main.getInstance().getPrefix() + "§e" + Bukkit.getPlayer(args[0]).getName() + "'s §7Kontostand: §e" + amount);
                        }

                    } else if (args.length == 0) {

                        File file = new File("plugins//CoinsSystem//playerdata//" + p.getName() + ".yml");
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                                cfg.addDefault("CoinsSystem.Coins", "0");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else if (file.exists()) {

                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            int amount = cfg.getInt("CoinsSystem.Coins");

                            p.sendMessage(Main.getInstance().getPrefix() + "§7Kontostand: §e" + amount);
                        }

                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/coins <add, remove, set> <Spieler> <Zahlenwert>");

                }


        }

        return false;
    }

    public void addcoins(String p, int amount) {

        File file = new File("plugins//CoinsSystem//playerdata//" + p + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.addDefault("CoinsSystem.Coins", "0");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int currentamout = cfg.getInt("CoinsSystem.Coins");

        int coins = currentamout + amount;

        cfg.set("CoinsSystem.Coins", coins);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setcoins(String p, int amount) {

        File file = new File("plugins//CoinsSystem//playerdata//" + p + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.addDefault("CoinsSystem.Coins", "0");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set("CoinsSystem.Coins", amount);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removecoins(String p, int amount) {

        File file = new File("plugins//CoinsSystem//playerdata//" + p + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.addDefault("CoinsSystem.Coins", "0");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int currentamount = cfg.getInt("CoinsSystem.Coins");

        int coins = currentamount - amount;

        cfg.set("CoinsSystem.Coins", coins);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getcoins(String p) {

        File file = new File("plugins//CoinsSystem//playerdata//" + p + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.addDefault("CoinsSystem.Coins", "0");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int amount = cfg.getInt("CoinsSystem.Coins");
        }
    }


