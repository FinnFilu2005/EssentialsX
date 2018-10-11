package de.finnfilu.bedwars.Gamestates;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!
;
import de.finnfilu.bedwars.Main.Data;
import org.bukkit.Bukkit;

public class LobbyState extends GameState {

    public static final int MIN_PLAYERS = 1;
    public static final int MAX_PLAYERS = 1;

    @Override
    public void start() {

        Bukkit.getConsoleSender().sendMessage(Data.pre + "§7Der LobbyState beginnt nun.");

    }

    @Override
    public void stop() {

    }

}
