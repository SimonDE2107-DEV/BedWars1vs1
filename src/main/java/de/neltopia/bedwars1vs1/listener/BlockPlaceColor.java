package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceColor implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (GameState.isState(GameState.RUNNING)) {
            if (event.getBlock().getType() == Material.WHITE_CONCRETE
                    || event.getBlock().getType() == Material.RED_CONCRETE
                    || event.getBlock().getType() == Material.BLUE_CONCRETE) {
                if (BedWars1vs1.red.isInTeam(player)) {
                    event.getBlock().setType(Material.RED_CONCRETE);
                } else if (BedWars1vs1.blue.isInTeam(player)) {
                    event.getBlock().setType(Material.BLUE_CONCRETE);
                }
            }

        }
    }
}
