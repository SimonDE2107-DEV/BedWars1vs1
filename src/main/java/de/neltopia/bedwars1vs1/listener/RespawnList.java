package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.BedManager;
import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.bedwars1vs1.util.StartGame;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class RespawnList implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (GameState.isState(GameState.RUNNING)) {
            if (red.isInTeam(player)) {
                if (new BedManager().hasBed(red)) {
                    event.setRespawnLocation(WarpAPI.warpLocation("RED"));
                } else {
                    event.setRespawnLocation(WarpAPI.warpLocation("LOBBY"));
                }
            } else if (blue.isInTeam(player)) {
                if (new BedManager().hasBed(blue)) {
                    event.setRespawnLocation(WarpAPI.warpLocation("BLUE"));
                } else {
                    event.setRespawnLocation(WarpAPI.warpLocation("LOBBY"));
                }
            }
        }
    }
}
