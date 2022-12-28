package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.BedManager;
import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.StartGame;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class DeathMessages implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();

        event.setDeathMessage(Data.PREFIX + player.getDisplayName() + " §7ist §cgestorben.");

        if (killer != null) {
            if (killer != player) {
                event.setDeathMessage(Data.PREFIX + player.getDisplayName() + " §7wurde von §a" + killer.getDisplayName() + " §cgetötet.");
                killer.playSound(killer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);

                if (red.isInTeam(player)) {
                    if (!new BedManager().hasBed(red)) {
                        new StartGame().winAndEndGame(killer);
                    }
                } else if (blue.isInTeam(player)) {
                    if (!new BedManager().hasBed(blue)) {
                        new StartGame().winAndEndGame(killer);
                    }
                }
            }
        }
    }
}
