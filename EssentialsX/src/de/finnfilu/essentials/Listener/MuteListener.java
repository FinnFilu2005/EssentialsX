package de.finnfilu.essentials.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Commands.PMuteCMD;
import de.finnfilu.essentials.Main.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(PMuteCMD.playerstatus.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(Data.pre + "§cDu bist zurzeit gemuted!");
        } else if(!PMuteCMD.playerstatus.contains(p.getName())) {
            e.setCancelled(false);
        }

    }

}
