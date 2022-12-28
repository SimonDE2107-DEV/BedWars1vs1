package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class AntiCrafting implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        event.setCancelled(!GameState.isState(GameState.SETUP));
    }
}
