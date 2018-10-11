package de.finnfilu.bedwars.Gamestates;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


public abstract class GameState {

    public static final int LOBBY_STATE = 0,
                            INGAME_STATE = 1,
                            ENDING_STATE = 2;


    public abstract void start();
    public abstract void stop();

}
