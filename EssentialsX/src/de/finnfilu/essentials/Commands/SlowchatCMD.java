package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Main.Data;
import de.finnfilu.essentials.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlowchatCMD implements CommandExecutor {

    public static boolean direction = false;
    int time = 60 * 20;
    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("slowchat")) {
            if(p.hasPermission("essentials.slowchat")) {
                if(sender instanceof Player) {
                    if(args.length == 0) {
                        if(direction == false) {
                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

                                @Override
                                public void run() {

                                    switch(time) {

                                        case 60:
                                        case 45:
                                        case 30:
                                        case 15:
                                        case 10:
                                        case 5:
                                        case 3:
                                        case 2:
                                            Bukkit.broadcastMessage("§c§lDer Chat wird in §e" + time + " Sekunden§7 deaktiviert§7.");
                                            time--;
                                            break;

                                        case 1:
                                            Bukkit.broadcastMessage("§c§lDer Chat wird in §eeiner Sekunde§7 deaktiviert§7.");
                                            time--;
                                            break;

                                        case 0:
                                            Bukkit.broadcastMessage("§c§lDer Chat wurde deaktiviert!");
                                            for(Player all : Bukkit.getOnlinePlayers()) {
                                                all.playSound(p.getLocation(), Sound.LEVEL_UP, 2, 2);
                                            }
                                            direction = true;
                                            Bukkit.getScheduler().cancelTask(taskID);
                                            time--;
                                            break;

                                        default:
                                            time--;
                                            break;
                                    }
                                }
                            },0 ,60 * 20);

                        } else if(direction == true) {
                            direction = false;
                            Bukkit.broadcastMessage(Data.pre + "§a§lDer Chat wurde aktiviert§7.");
                        }

                    }
                }
            }
        }

        return false;
    }
}