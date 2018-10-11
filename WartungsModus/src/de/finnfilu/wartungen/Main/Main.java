package de.finnfilu.wartungen.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.wartungen.Commands.WartungsCMD;
import de.finnfilu.wartungen.Listener.WartungsListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    private final String prefix = this.getConfig().getString("Wartungen.Prefix");
    private final String noperms = this.getConfig().getString("Wartungen.NoPermissions");
    private final String error = this.getConfig().getString("Wartungen.Error");
    private final String noplayer = this.getConfig().getString("Wartungen.NoPlayer");

    @Override
    public void onEnable() {
        instance = this;

        init();
        loadConfig();
        register();

    }

    @Override
    public void onDisable() {



    }

    public static Main getInstance() {
        return instance;
    }

    public void init() {

        Bukkit.getConsoleSender().sendMessage("§aAktiviere WartungsModus.");
        Bukkit.getConsoleSender().sendMessage("§eDie Config.yml wurde geladen.");
        Bukkit.getConsoleSender().sendMessage("§aVersion: §c1.0");

    }

    public void register() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new WartungsListener(), this);

        getCommand("wartungen").setExecutor(new WartungsCMD());

    }

    public void loadConfig() {
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);

        this.getConfig().addDefault("Wartungen.Prefix", "&7[&bWartungen&7] &8» &r");
        this.getConfig().addDefault("Wartungen.NoPermissions", "&cDazu hast du keine Rechte!");
        this.getConfig().addDefault("Wartungen.Error", "&cEs ist ein Fehler aufgetreten. Bitte kontaktiere ein Teammitglied!");
        this.getConfig().addDefault("Wartungen.NoPlayer", "&cDazu musst du ein Spieler sein!");

        this.saveConfig();
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

    public String getNoplayer() {
        return noplayer;
    }
}
