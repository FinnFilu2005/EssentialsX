package de.finnfilu.wartungen.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.wartungen.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class WartungsCMD implements CommandExecutor {

    public static boolean WartungsMode = false;
    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("wartungen")) {
            if (sender instanceof ConsoleCommandSender) {

                if (args.length == 0) {

                    if (WartungsMode == false) {

                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                            private int countdown = 60;

                            @Override
                            public void run() {

                                switch (countdown) {

                                    case 60:
                                    case 30:
                                    case 10:
                                    case 5:
                                    case 3:
                                    case 2:
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen werden in §e" + countdown + " Sekunden §caktiviert.");
                                        countdown--;
                                        break;
                                    case 1:
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen werden in §eeiner Sekunde §caktiviert.");
                                        countdown--;
                                        break;
                                    case 0:
                                        WartungsMode = true;
                                        Bukkit.getScheduler().cancelTask(taskID);
                                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen wurden aktiviert.");
                                        for (Player all : Bukkit.getOnlinePlayers()) {

                                            if (!all.hasPermission("Wartungen.ignorekick")) {
                                                all.kickPlayer(Main.getInstance().getPrefix() + "§cDie Wartungen wurden aktiviert \n§7Versuche es später erneut!");
                                            }
                                        }
                                        break;

                                    default:
                                        countdown--;
                                }

                            }
                        }, 0,  20);

                    } else if (WartungsMode == true) {

                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen wurden deaktiviert.");
                        WartungsMode = false;

                    }

                } else
                    Bukkit.getConsoleSender().sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/wartungen");

            } else if (sender instanceof Player) {
                final Player p = (Player) sender;

                if (p.hasPermission("Wartungen.activate")) {
                    if (args.length == 0) {

                        if (WartungsMode == false) {

                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                                private int countdown = 60;

                                @Override
                                public void run() {

                                    switch (countdown) {

                                        case 60:
                                        case 30:
                                        case 10:
                                        case 5:
                                        case 3:
                                        case 2:
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen werden in §e" + countdown + " Sekunden §caktiviert.");
                                            countdown--;
                                            break;
                                        case 1:
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen werden in §eeiner Sekunde §caktiviert.");
                                            countdown--;
                                            break;
                                        case 0:
                                            WartungsMode = true;
                                            Bukkit.getScheduler().cancelTask(taskID);
                                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen wurden aktiviert.");
                                            for (Player all : Bukkit.getOnlinePlayers()) {

                                                if (!all.hasPermission("Wartungen.ignorekick")) {
                                                    all.kickPlayer(Main.getInstance().getPrefix() + "§cDie Wartungen wurden aktiviert \n§7Versuche es später erneut!");
                                                }
                                            }
                                            break;

                                        default:
                                            countdown--;
                                    }

                                }
                            }, 0, 20);

                        } else if (WartungsMode == true) {

                            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cDie Wartungen wurden deaktiviert.");
                            WartungsMode = false;

                        }

                    } else
                        p.sendMessage(Main.getInstance().getPrefix() + "§cBitte benutze: §e/wartungen");
                } else
                    p.sendMessage(Main.getInstance().getNoperms());
            }
        }

        return false;
    }
}
