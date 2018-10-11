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

public class ChatclearCommand implements CommandExecutor {
    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("chatclear")) {
            if (p.hasPermission("ChatManager.chatclear")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {

                        Bukkit.broadcastMessage(Data.pre + "§7§lLeere Chat in 5 Sekunden!");

                        taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 56; i++) {
                                    Bukkit.broadcastMessage(" ");
                                }
                                Bukkit.broadcastMessage(Data.pre + "§7§lDer Chat wurde geleert!");
                            }
                        }, 100);

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/chatclear");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }
        return false;
    }
}
