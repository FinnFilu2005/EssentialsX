package de.finnfilu.essentials.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Commands.SlowchatCMD;
import de.finnfilu.essentials.Main.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SlowchatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(SlowchatCMD.direction == true) {
            e.setCancelled(true);
            p.sendMessage(Data.pre + "§cDer Chat ist zurzeit deaktiviert.");
        } else if(SlowchatCMD.direction == false) {
            e.setCancelled(false);
        }

    }

}
