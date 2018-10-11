package de.finnfilu.coins.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.coins.Commands.CoinsCMD;
import de.finnfilu.coins.Listener.DefaultData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public static Main instance;

    private final String prefix = this.getConfig().getString("CoinsSystem.Prefix");
    private final String noperms = this.getConfig().getString("CoinsSystem.NoPermissions");
    private final String error = this.getConfig().getString("CoinsSystem.Error");
    private final String notplayer = this.getConfig().getString("CoinsSystem.Error");

    @Override
    public void onEnable() {
        instance = this;

        init();
        register();
        loadConfig();
        loadPlayerdata();


    }

    public void init() {

        Bukkit.getConsoleSender().sendMessage("§aAktiviere CoinsSystem");
        Bukkit.getConsoleSender().sendMessage("§eDie Config.yml wurde geladen");
        Bukkit.getConsoleSender().sendMessage("§aVersion: §e1.0");

    }

    public void register() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new DefaultData(), this);

        getCommand("coins").setExecutor(new CoinsCMD());

    }

    public void loadConfig() {
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);

        this.getConfig().addDefault("CoinsSystem.Prefix", "&7[&5CoinsSystem&7] &8» &r");
        this.getConfig().addDefault("CoinsSystem.NoPermissions", "&cDazu hast du keine Rechte!");
        this.getConfig().addDefault("CoinsSystem.Error", "&cEin Fehler ist aufgetreten!");
        this.getConfig().addDefault("CoinsSystem.NotPlayer", "&cDazu musst du ein Spieler sein!");

        this.saveConfig();
    }

    public void loadPlayerdata() {

        File file = new File("plugins//CoinsSystem//playerdata");

        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }


    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix.replace("&", "§");
    }

    public String getNoperms() {
        return prefix.replace("&", "§") + noperms.replace("&", "§");
    }

    public String getError() {
        return prefix.replace("&", "§") + error.replace("&", "§");
    }

    public String getNotplayer() {
        return prefix.replace("&", "§") + notplayer.replace("&", "§");
    }
}
