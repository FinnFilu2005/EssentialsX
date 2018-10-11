package de.finnfilu.essentials.Listener;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Commands.FlyCMD;
import de.finnfilu.essentials.Main.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage("§7[§c-§7] " + p.getName());

        FlyCMD.fp.remove(p.getName());
        p.setGameMode(GameMode.SURVIVAL);
        p.setAllowFlight(false);

    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();

        e.setLeaveMessage("§7[§c-§7] " + p.getName());
    }

}
