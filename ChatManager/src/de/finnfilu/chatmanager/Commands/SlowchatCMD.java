package de.finnfilu.chatmanager.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.chatmanager.Main.Data;
import de.finnfilu.chatmanager.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlowchatCMD implements CommandExecutor {
    private int taskID;
    public static boolean chatmode;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("slowchat")) {
            if(sender.hasPermission("ChatManager.slowchat")) {
                if(sender instanceof Player) {
                    if(args.length == 0) {
                        if(chatmode == false) {
                            Bukkit.broadcastMessage(Data.pre + "§7Deaktiviere Chat in 10 Sekunden.");

                            taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                @Override
                                public void run() {

                                    chatmode = true;
                                    Bukkit.broadcastMessage(Data.pre + "§7§lDer Chat wird deaktiviert!");

                                }
                            }, 20 * 10);
                        } else if(chatmode == true) {
                            Bukkit.broadcastMessage(Data.pre + "§7§lDer Chat wird aktiviert!");
                            chatmode = false;
                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/slowchat");
                } else
                    sender.sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}
