package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.Shop;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class RightClickVillager implements Listener {

    @EventHandler
    public void onEntClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked() instanceof Villager) {
            if (red.isInTeam(player)) {
                player.openInventory(new Shop().categoriesMenu(red));
            } else  if (blue.isInTeam(player)) {
                player.openInventory(new Shop().categoriesMenu(blue));
            }
        }
    }
}
