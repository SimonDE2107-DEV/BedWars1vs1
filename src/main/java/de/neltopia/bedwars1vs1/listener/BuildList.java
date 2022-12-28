package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class BuildList implements Listener {

    public List<Block> placedBlocks = new ArrayList<>();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (GameState.isState(GameState.RUNNING)) {
            if (event.getBlock().getType().equals(Material.RED_BED)
                    || event.getBlock().getType().equals(Material.BLUE_BED)
                    || event.getBlock().getType().equals(Material.TALL_GRASS)
                    || event.getBlock().getType().equals(Material.GRASS)) {
                event.setCancelled(false);
                event.setDropItems(false);
            } else if (placedBlocks.contains(event.getBlock())) {
                event.setCancelled(false);
                event.setDropItems(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (GameState.isState(GameState.RUNNING)) {
            if (!event.isCancelled()) {
                placedBlocks.add(event.getBlockPlaced());
            }
        }
    }
}
