package de.neltopia.bedwars1vs1.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiKillVillager implements Listener {

    @EventHandler
    public void onEntDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity().getType() == EntityType.VILLAGER)
            event.setCancelled(true);
    }
}
