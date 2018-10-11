package de.finnfilu.wartungen.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.wartungen.Commands.WartungsCMD;
import de.finnfilu.wartungen.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class WartungsListener implements Listener {

    @EventHandler
    public void onJoin(PlayerPreLoginEvent e) {

        if(WartungsCMD.WartungsMode == true) {

            e.disallow(PlayerPreLoginEvent.Result.KICK_FULL, Main.getInstance().getPrefix() + "\n \n§cDie Wartungen wurden aktiviert \n§eVersuche es später erneut!");

        }

    }

}
