package de.finnfilu.chatmanager.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.chatmanager.Commands.MuteCMD;
import de.finnfilu.chatmanager.Commands.SlowchatCMD;
import de.finnfilu.chatmanager.Main.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SlowchatListener implements Listener {



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(SlowchatCMD.chatmode == true) {
            e.setCancelled(true);
            p.sendMessage(Data.pre + "§cDer Chat ist zurzeit verlangsamt!");
        } else if(SlowchatCMD.chatmode == false) {
            e.setCancelled(false);
        }

        if(MuteCMD.playerstatus.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(Data.pre + "§cDu bist zurzeit gemuted!");
        } else if(!MuteCMD.playerstatus.contains(p.getName())) {
            e.setCancelled(false);
        }

    }


}
