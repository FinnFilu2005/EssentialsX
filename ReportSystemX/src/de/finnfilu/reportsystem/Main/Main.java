package de.finnfilu.reportsystem.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.reportsystem.Commands.ReportCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerCommands();
        registerEvents();

    }

    public void onDisable() {

    }

    public static Main getPlugin() {
        return plugin;
    }

    public void registerCommands() {

        getCommand("report").setExecutor(new ReportCMD());

    }

    public void registerEvents() {


    }

}
