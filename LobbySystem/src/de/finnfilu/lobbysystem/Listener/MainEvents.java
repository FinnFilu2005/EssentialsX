package de.finnfilu.lobbysystem.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainEvents implements Listener {

    @EventHandler
    public void onDamage(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        e.setJoinMessage(null);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

    }

    @EventHandler
    public void onHunger(EntityDamageEvent e) {

        e.setCancelled(true);

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        e.setCancelled(true);

    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();

        e.setCancelled(true);
        p.setFoodLevel(20);

    }

}
