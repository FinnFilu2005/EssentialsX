package de.finnfilu.essentials.Listener;

// Plugin geschrieben von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Commands.FlyCMD;
import de.finnfilu.essentials.Main.Data;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(p.hasPermission("Essentials.safelogin")) {

            FlyCMD.fp.add(p.getName());
            p.setGameMode(GameMode.CREATIVE);
            p.setAllowFlight(true);

        }

        File file = new File("plugins//Essentials//playerdata//" + p.getName() + ".yml");
        if (file.exists()) {
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            if (cfg.getString("warns").equals("3")) {
                p.kickPlayer("§4Du wurdest vom Server gebannt! \n \n §7Grund: §eMaximale Warns erreicht \n §7Dauer: §ePermanent");
            } else {
                e.setJoinMessage("§7[§a+§7] " + p.getName());
            }
        } else {
            e.setJoinMessage("§7[§a+§7] " + p.getName());
        }
    }

}
