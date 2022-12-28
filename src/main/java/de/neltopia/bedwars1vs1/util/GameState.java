package de.neltopia.bedwars1vs1.util;

public enum GameState {

    SETUP, LOBBY, RUNNING, RESTART;
    private static GameState state;

    public static boolean isState(GameState gameState) {
        return GameState.state == gameState;
    }

    public static void setState(GameState gameState) {
        GameState.state = gameState;
    }
}