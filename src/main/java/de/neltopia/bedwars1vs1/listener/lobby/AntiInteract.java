package de.neltopia.bedwars1vs1.listener.lobby;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        event.setCancelled(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.RESTART));
    }
}
