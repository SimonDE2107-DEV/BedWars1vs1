package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        player.setDisplayName(player.getName());

        if (BedWars1vs1.red.isInTeam(player)) {
            event.setFormat(BedWars1vs1.red.getTeamPrefix()+" §8| §4"+player.getName() + "§8: §b§l" + event.getMessage());
        } else if (BedWars1vs1.blue.isInTeam(player)) {
            event.setFormat(BedWars1vs1.blue.getTeamPrefix()+" §8| §1"+player.getName() + "§8: §b§l" + event.getMessage());
        }

        if (BedWars1vs1.spectator.isInTeam(player)) {
            if (GameState.isState(GameState.RUNNING)) {
                event.setCancelled(true);
                player.sendMessage(Data.PREFIX + "§cAls §bSpectator §ckannst du nicht §eschreiben.");
            } else {
                if (GameState.isState(GameState.RESTART)) {
                    event.setCancelled(false);
                    event.setFormat(BedWars1vs1.spectator.getTeamPrefix()+" §8| §5"+player.getName() + "§8: §b§l" + event.getMessage());
                }
            }
        }
    }
}
