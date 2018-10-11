package de.finnfilu.bedwars.Listener;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.bedwars.Gamestates.GameStateManager;
import de.finnfilu.bedwars.Gamestates.LobbyState;
import de.finnfilu.bedwars.Main.Data;
import de.finnfilu.bedwars.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private final int RESET_SECONDS = 60;
    private final int IDLE_SECONDS = 20;

    private GameStateManager gameStateManager;
    public PlayerConnectionListener(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            Main.getPlugin().getPlayers().add(p);
            LobbyState lobbyState = (LobbyState) gameStateManager.getCurrentGameState();

            e.setJoinMessage(Data.pre + "§7[§a+§7] §7" + p.getName() + "§7 [§e" + Main.getPlugin().getPlayers().size() + "§7/§e" + LobbyState.MAX_PLAYERS + "§7]");

            if(Main.getPlugin().getPlayers().size() >= LobbyState.MIN_PLAYERS) {



            }
        }

    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if(gameStateManager.getCurrentGameState() instanceof LobbyState) {
            Main.getPlugin().getPlayers().remove(p);

            e.setQuitMessage(Data.pre + "§7[§c-§7] §7" + p.getName() + "§7 [§e" + Main.getPlugin().getPlayers().size() + "§7/§e" + LobbyState.MAX_PLAYERS + "§7]");

            if(Main.getPlugin().getPlayers().size() < LobbyState.MIN_PLAYERS) {
                Bukkit.broadcastMessage(Data.pre + "§7Der Countdown wurde abgebrochen.");
            }

        }

    }

}
