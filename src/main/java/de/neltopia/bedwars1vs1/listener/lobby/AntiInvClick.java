package de.neltopia.bedwars1vs1.listener.lobby;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AntiInvClick implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        event.setCancelled(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.RESTART));
    }
}
