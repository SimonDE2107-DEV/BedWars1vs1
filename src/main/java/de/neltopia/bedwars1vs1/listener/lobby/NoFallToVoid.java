package de.neltopia.bedwars1vs1.listener.lobby;

import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NoFallToVoid implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (GameState.isState(GameState.LOBBY) || GameState.isState(GameState.RESTART)) {
            if (player.getLocation().getY() <= 50) {
                WarpAPI.teleportToWarp(player,"LOBBY");
            }
        }
    }
}
