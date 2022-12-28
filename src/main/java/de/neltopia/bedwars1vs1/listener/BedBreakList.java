package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.util.BedManager;
import de.neltopia.bedwars1vs1.util.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BedBreakList implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (event.getBlock().getType().equals(Material.RED_BED)) {
            if (BedWars1vs1.red.isInTeam(player)) {
                event.setCancelled(true);
                player.sendMessage(Data.PREFIX + "§cDu kannst dein eigenes Bett nicht zerstören!");
            } else if (BedWars1vs1.blue.isInTeam(player)) {
                event.setCancelled(false);
                new BedManager().breakBed(player, BedWars1vs1.red);
                event.setDropItems(false);
            }
        } else if (event.getBlock().getType().equals(Material.BLUE_BED)) {
            if (BedWars1vs1.blue.isInTeam(player)) {
                event.setCancelled(true);
                player.sendMessage(Data.PREFIX + "§cDu kannst dein eigenes Bett nicht zerstören!");
            } else if (BedWars1vs1.red.isInTeam(player)) {
                event.setCancelled(false);
                new BedManager().breakBed(player, BedWars1vs1.blue);
                event.setDropItems(false);
            }
        }
    }
}
