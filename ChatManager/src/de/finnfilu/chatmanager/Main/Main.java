package de.finnfilu.chatmanager.Main;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!

import de.finnfilu.chatmanager.Commands.ChatclearCommand;
import de.finnfilu.chatmanager.Commands.MuteCMD;
import de.finnfilu.chatmanager.Commands.SlowchatCMD;
import de.finnfilu.chatmanager.Listener.SlowchatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        registerCommands();
        registerEvents();
        loadConfig();

        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lChatManager§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("           Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("        Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§a    Das Plugin wurde aktiviert!");
        Bukkit.getConsoleSender().sendMessage("§e    Die Dateien wurden geladen!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §a§lChatmanager§r §7----------");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lChatManager§r §7----------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("           Version: 1.0");
        Bukkit.getConsoleSender().sendMessage("        Ersteller: FinnFilu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§c   Das Plugin wurde deaktiviert!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7---------- §c§lChatManager§r §7----------");

    }

    public Main getPlugin() {
        return plugin;
    }

    public void registerCommands() {

        getCommand("chatclear").setExecutor(new ChatclearCommand());
        getCommand("slowchat").setExecutor(new SlowchatCMD());
        getCommand("pmute").setExecutor(new MuteCMD());

    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new SlowchatListener(), this);

    }

    public void loadConfig() {
        this.reloadConfig();
        this.getConfig().options().copyDefaults(true);

        this.getConfig().addDefault("ChatManager.Prefix", "§7[§cChatManager§7] §8» §r");

    }

}
