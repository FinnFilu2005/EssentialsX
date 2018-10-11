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
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SaveInvCMD implements CommandExecutor {
    HashMap<String, ItemStack[]> inv = new HashMap<>();
    HashMap<String, ItemStack[]> armor = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("inv")) {
            if(p.hasPermission("Essentials.inventory")) {
                if(sender instanceof Player) {
                    if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("save")) {
                            if(!inv.containsKey(p.getName())) {

                                inv.put(p.getName(), p.getInventory().getContents());
                                armor.put(p.getName(), p.getInventory().getArmorContents());
                                p.getInventory().clear();
                                p.sendMessage(Data.pre + "§7Dein Inventar wurde gesichert.");
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                            } else
                                p.sendMessage(Data.pre + "§cDein Inventar wurde bereits gespeichert!");
                        } else if(args[0].equalsIgnoreCase("get")) {
                            if(inv.containsKey(p.getName())) {

                                ItemStack[] oldinv = inv.get(p.getName());
                                ItemStack[] oldarmor = armor.get(p.getName());

                                inv.remove(p.getName());
                                armor.remove(p.getName());

                                p.getInventory().setContents(oldinv);
                                p.getInventory().setArmorContents(oldarmor);
                                p.sendMessage(Data.pre + "§7Inventar wurde geladen.");
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

                            } else
                                p.sendMessage(Data.pre + "§cDein Inventar ist nicht gespeichert!");
                        }
                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/inv <save, get>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
