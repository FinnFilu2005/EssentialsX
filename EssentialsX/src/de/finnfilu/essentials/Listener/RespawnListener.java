package de.finnfilu.essentials.Listener;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.io.File;

public class RespawnListener implements Listener {

    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        File file = new File("plugins//Essentials//spawn.yml");
        if(!file.exists()) {
            p.setHealth(20);
        } else {
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
            double x = cfg.getDouble("Spawn.X");
            double y = cfg.getDouble("Spawn.Y");
            double z = cfg.getDouble("Spawn.Z");
            float yaw = (float) cfg.getDouble("Spawn.Yaw");
            float pitch = (float) cfg.getDouble("Spawn.Pitch");

            Location loc = p.getLocation();
            loc.setWorld(world);
            loc.setX(x);
            loc.setY(y);
            loc.setZ(z);
            loc.setYaw(yaw);
            loc.setPitch(pitch);

            e.setRespawnLocation(loc);
        }
    }

}
