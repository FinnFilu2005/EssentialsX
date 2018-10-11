package de.finnfilu.coins.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class DefaultData implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        File file = new File("plugins//CoinsSystem//playerdata//" + p.getName() + ".yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("CoinsSystem.Coins", "0");
                cfg.save(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }


}
