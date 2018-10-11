package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecCMD implements CommandExecutor {

    public static ArrayList<String> sp = new ArrayList<>();
    public static HashMap<String, ItemStack[]> oldinv = new HashMap<>();
    public static HashMap<String, Location> oldloc = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("spectate")) {
            if (p.hasPermission("Essentials.spectate")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Data.pre + Data.noton);
                        } else {

                            if (!sp.contains(p.getName())) {
                                sp.add(p.getName());

                                ItemStack b = new ItemStack(Material.BARRIER);
                                ItemMeta bm = b.getItemMeta();
                                bm.setDisplayName("§4§lBEENDEN");
                                b.setItemMeta(bm);

                                oldinv.put(p.getName(), p.getInventory().getContents());
                                oldloc.put(p.getName(), p.getLocation());

                                p.getInventory().clear();
                                p.getInventory().setItem(3, b);
                                p.getInventory().setItem(4, b);
                                p.getInventory().setItem(5, b);

                                p.setGameMode(GameMode.CREATIVE);
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.hidePlayer(p);
                                }

                                p.teleport(Bukkit.getPlayer(args[0]).getLocation());
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                                p.sendMessage(Data.pre + "§7Beobachte §e" + Bukkit.getPlayer(args[0]).getName() + "§7...");
                                p.sendMessage(Data.pre + "§7Nutze: §e/spec <Spieler> §7um zurückzukehren");

                            } else if (sp.contains(p.getName())) {
                                sp.remove(p.getName());

                                p.getInventory().clear();

                                ItemStack[] getoldinv = oldinv.get(p.getName());
                                Location getoldloc = oldloc.get(p.getName());

                                p.setGameMode(GameMode.SURVIVAL);
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.showPlayer(p);
                                }
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                                p.sendMessage(Data.pre + "§7Beende Beobachten...");
                                p.getInventory().setContents(getoldinv);
                                p.teleport(getoldloc);

                            }
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/spec <Spieler>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }

}
