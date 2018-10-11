package de.finnfilu.essentials.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Entity p = e.getEntity();

        if(p instanceof Player) {

            e.setDeathMessage(null);

        }
    }

}
