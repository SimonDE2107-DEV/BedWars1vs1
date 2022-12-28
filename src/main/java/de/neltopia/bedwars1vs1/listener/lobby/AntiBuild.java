package de.neltopia.bedwars1vs1.listener.lobby;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiBuild implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.RESTART));
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.setCancelled(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.RESTART));
    }
}
