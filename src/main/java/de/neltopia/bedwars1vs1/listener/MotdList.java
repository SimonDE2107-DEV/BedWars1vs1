package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdList implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        if (GameState.isState(GameState.LOBBY)) {
            event.setMaxPlayers(2);
            if (Bukkit.getOnlinePlayers().size() >= 2) {
                event.setMotd("§0[§6Lobby§0]");
            } else {
                if (Bukkit.getOnlinePlayers().size() == 1) {
                    event.setMotd("§0[§aLobby§0]");
                } else {
                    if (Bukkit.getOnlinePlayers().size() == 0) {
                        event.setMotd("§0[§fLobby§0]");
                    }
                }
            }
        }
        if (GameState.isState(GameState.RUNNING)) {
            event.setMotd("§0[§5Spec§0]");
            event.setMaxPlayers(20);
        }
        if (GameState.isState(GameState.RESTART)) {
            event.setMotd("§0[§4ENDE§0]");
        }
    }
}
