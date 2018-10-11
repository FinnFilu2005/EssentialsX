package de.finnfilu.bedwars.Gamestates;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.bedwars.Main.Data;
import org.bukkit.Bukkit;

public class IngameState extends GameState {


    @Override
    public void start() {

        Bukkit.getConsoleSender().sendMessage(Data.pre + "§7Der IngameState beginnt nun.");
        Bukkit.broadcastMessage(Data.pre + "§7Du wirst in kürze teleportiert...");

    }

    @Override
    public void stop() {

    }
}
