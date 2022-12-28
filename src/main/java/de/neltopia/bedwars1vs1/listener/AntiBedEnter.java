package de.neltopia.bedwars1vs1.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class AntiBedEnter implements Listener {

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
            event.setCancelled(true);
    }
}
