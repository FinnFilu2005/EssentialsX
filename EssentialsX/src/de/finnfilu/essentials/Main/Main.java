package de.finnfilu.essentials.Main;

// Plugin geschrieben von: FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.essentials.Commands.*;
import de.finnfilu.essentials.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommands();
        getEvents();
        loadPlayerData();

        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lEssentialsX§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("           Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("        Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§a    Das Plugin wurde aktiviert!");
        Bukkit.getConsoleSender().sendMessage("§e    Die Dateien wurden geladen!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lEssentialsX§r §7----------");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lEssentialsX§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("           Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("        Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§c   Das Plugin wurde deaktiviert!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lEssentialsX§r §7----------");

    }

    public void getCommands() {

        getCommand("gm").setExecutor(new GamemodeCMD());
        getCommand("time").setExecutor(new TimeCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("vanish").setExecutor(new VanishCMD());
        getCommand("weather").setExecutor(new WeatherCMD());
        getCommand("invsee").setExecutor(new InvseeCMD());
        getCommand("heal").setExecutor(new HealCMD());
        getCommand("teleport").setExecutor(new TeleportCMD());
        getCommand("tphere").setExecutor(new TpHereCMD());
        getCommand("countdown").setExecutor(new CountdownCMD());
        getCommand("chatclear").setExecutor(new ChatclearCMD());
        getCommand("kill").setExecutor(new KillCMD());
        getCommand("spectate").setExecutor(new SpecCMD());
        getCommand("clear").setExecutor(new ClearCMD());
        getCommand("difficulty").setExecutor(new DífficultyCMD());
        getCommand("warn").setExecutor(new WarnCMD());
        getCommand("warns").setExecutor(new WarnsCMD());
        getCommand("removewarn").setExecutor(new RemoveWarnCMD());
        getCommand("kick").setExecutor(new KickCMD());
        getCommand("enderchest").setExecutor(new EnderchestCMD());
        getCommand("burn").setExecutor(new BurnCMD());
        getCommand("slowchat").setExecutor(new SlowchatCMD());
        getCommand("pmute").setExecutor(new PMuteCMD());
        getCommand("unmute").setExecutor(new UnmuteCMD());
        getCommand("inv").setExecutor(new SaveInvCMD());

    }

    public void getEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new RespawnListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new SpecListener(), this);
        pm.registerEvents(new SlowchatListener(), this);
        pm.registerEvents(new MuteListener(), this);
        pm.registerEvents(new ChatListener(), this);

    }

    public static Main getPlugin() {
        return plugin;
    }

    public void loadPlayerData() {

        File file = new File("plugins//Essentials//playerdata");
        if(!file.isDirectory()) {
            file.mkdirs();

        }

    }

}