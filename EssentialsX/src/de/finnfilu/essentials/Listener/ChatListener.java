package de.finnfilu.essentials.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        String message = e.getMessage().replace("%", "%%");

        if(p.hasPermission("Essentials.colorwrite")) {
            message = ChatColor.translateAlternateColorCodes('&', message);
            e.setMessage(message);
        }

    }

}
