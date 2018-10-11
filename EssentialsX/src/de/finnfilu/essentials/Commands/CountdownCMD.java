package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import de.finnfilu.essentials.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CountdownCMD implements CommandExecutor {

    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("countdown")) {
            if (p.hasPermission("Essentials.countdown")) {
                if (sender instanceof Player) {
                    if (args.length == 1) {

                        final int count = Integer.parseInt(args[0]);
                        Bukkit.broadcastMessage(Data.pre + "§7Starte §e" + count + " Sekunden §7Countdown...");

                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

                            int count = Integer.parseInt(args[0]);

                            @Override
                            public void run() {


                                switch (count) {

                                    case 60:
                                    case 30:
                                    case 10:
                                    case 5:
                                    case 3:
                                    case 2:
                                        Bukkit.broadcastMessage("§7Der Countdown endet in §e" + count + " Sekunden§7.");
                                        count--;
                                        break;

                                    case 1:
                                        Bukkit.broadcastMessage("§7Der Countdown endet in §eeiner Sekunde§7.");
                                        count--;
                                        break;

                                    case 0:
                                        Bukkit.broadcastMessage("§7Der Countdown ist zuende!");
                                        Bukkit.getScheduler().cancelTask(taskID);
                                        count--;
                                        break;
                                    default:
                                        count--;
                                        break;
                                }

                            }
                        }, 0, 20);


                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/countdown <Sekunden>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
