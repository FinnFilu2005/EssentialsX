package de.finnfilu.bedwars.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.bedwars.Gamestates.GameState;
import de.finnfilu.bedwars.Gamestates.GameStateManager;
import de.finnfilu.bedwars.Listener.PlayerConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main plugin;
    private ArrayList<Player> players;

    private GameStateManager gameStateManager;

    public void onEnable() {
        plugin = this;
        gameStateManager = new GameStateManager();
        players = new ArrayList<>();
        gameStateManager.setGameState(GameState.LOBBY_STATE);

        getCommands();
        getListener();

        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lBedwarsX§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("         Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("      Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§a  Das Plugin wurde aktiviert!");
        Bukkit.getConsoleSender().sendMessage("§e  Die Dateien wurden geladen!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lBedwarsX§r §7----------");

    }

    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lBedwarsX§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("         Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("      Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§c Das Plugin wurde deaktiviert!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lBedwarsX§r §7----------");

    }

    public void getCommands() {



    }

    public void getListener() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerConnectionListener(gameStateManager), this);
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
