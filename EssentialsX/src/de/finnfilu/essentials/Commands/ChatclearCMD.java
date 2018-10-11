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

public class ChatclearCMD implements CommandExecutor {

    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("chatclear")) {
            if (p.hasPermission("Essentials.chatclear")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {

                        p.sendMessage(Data.pre + "§7Leere Chat...");

                        taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 56; i++) {
                                    Bukkit.broadcastMessage(" ");
                                }
                                Bukkit.broadcastMessage(Data.pre + "§7Der Chat wurde geleert.");
                            }
                        }, 50);

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

