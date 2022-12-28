package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.bedwars1vs1.util.ItemBuilder;
import de.neltopia.bedwars1vs1.util.StartGame;
import de.neltopia.bedwars1vs1.util.scoreboard.LobbyBoard;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    public void applyGameRules() {
        World lobby = Bukkit.getWorld(Data.lobbyWorldName);
        World map = Bukkit.getWorld(Data.mapWorldName);

        lobby.setThundering(false);
        lobby.setTime(6000);
        lobby.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        lobby.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        lobby.setGameRule(GameRule.DO_WEATHER_CYCLE, false);

        map.setThundering(false);
        map.setTime(6000);
        map.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        map.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        map.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        applyGameRules();

        LobbyBoard.applyLobbyBoard(player);


        if (GameState.isState(GameState.LOBBY)) {
            if (Bukkit.getOnlinePlayers().size() >= 2) {
                new StartGame().startLobbyCooldown();
            }

            event.setJoinMessage(Data.PREFIX + "§e" + player.getDisplayName() + " §7hat §9Bed§bWars§61§evs§61 §abetreten. §7(§a" + Bukkit.getOnlinePlayers().size() + "§7/§c2§7)");
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().setArmorContents(null);
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.setFireTicks(0);
            player.setLevel(0);
            player.setExp(0.0f);

            player.getInventory().clear();
            player.getInventory().setItem(4, new ItemBuilder(Material.BARRIER, 1, "§8✘ §aZurück zur §6L§eo§6b§eb§6y").build());

            WarpAPI.teleportToWarp(player, "LOBBY");
        } else {
            if (GameState.isState(GameState.RESTART)) {
                event.setJoinMessage(null);
                player.kickPlayer("§cDas Spiel ist bereits zu Ende!");
            } else {
                if (GameState.isState(GameState.RUNNING)) {
                    event.setJoinMessage(null);
                    player.setGameMode(GameMode.SPECTATOR);
                    WarpAPI.teleportToWarp(player, "SPEC");

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(player);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (GameState.isState(GameState.RESTART)) {
            event.setQuitMessage(null);
        }
        if (GameState.isState(GameState.LOBBY)) {
            event.setQuitMessage(Data.PREFIX + "§e" + player.getDisplayName() + " §7hat §9Bed§bWars§61§evs§61 §cverlassen. §7(§a" + 1 + "§7/§c2§7)");
        } else if (GameState.isState(GameState.RUNNING)) {
            if (!BedWars1vs1.spectator.isInTeam(player)) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    if (BedWars1vs1.red.isInTeam(online) || BedWars1vs1.blue.isInTeam(online)) {
                        event.setQuitMessage(Data.PREFIX + "§e" + player.getDisplayName() + " §7hat §9Bed§bWars§61§evs§61 §cverlassen.");
                        new StartGame().winAndEndGame(online);
                    }
                }
            } else {
                if (BedWars1vs1.spectator.isInTeam(player)) {
                    event.setQuitMessage(null);
                }
            }
        }
    }
}
