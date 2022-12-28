package de.neltopia.bedwars1vs1.util;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.listener.JoinLeaveListener;
import de.neltopia.bedwars1vs1.util.scoreboard.GameBoard;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static de.neltopia.bedwars1vs1.BedWars1vs1.*;

public class StartGame {

    int cooldownSched;
    int restartSched;
    SpawnerMethods spawnerMethods = new SpawnerMethods();

    public void startLobbyCooldown() {
        cooldownSched = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars1vs1.plugin, () -> {
            --Data.waitingTimeInLobbyCountDown;
            for (final Player all : Bukkit.getOnlinePlayers()) {
                all.setLevel(Data.waitingTimeInLobbyCountDown);
            }
            if (Data.waitingTimeInLobbyCountDown == 30 ||
                    Data.waitingTimeInLobbyCountDown == 20 ||
                    Data.waitingTimeInLobbyCountDown == 15 ||
                    Data.waitingTimeInLobbyCountDown == 10 ||
                    Data.waitingTimeInLobbyCountDown <= 5) {
                Bukkit.broadcastMessage(Data.PREFIX + "§aDas §eSpiel §astartet in §e" + Data.waitingTimeInLobbyCountDown + " §7Sekunden!");
            }
            if (Data.waitingTimeInLobbyCountDown <= 5) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                }
            }

            if (Data.waitingTimeInLobbyCountDown == 2) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    TeamHandler.setRandomTeam(all);
                }
            }
            if (Data.waitingTimeInLobbyCountDown == 1) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 3);
                }
            }
            if (Data.waitingTimeInLobbyCountDown == 10) {
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.closeInventory();
                }
                Bukkit.broadcastMessage(Data.PREFIX + "Gespielt wird: §e" + Data.map);
                Bukkit.broadcastMessage(Data.PREFIX + "Map gebaut von: §e" + Data.builder);
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.sendTitle("§aGespielt wird: §e" + Data.map, "§aGebaut von: §e" + Data.builder);
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(BedWars1vs1.plugin, () -> {
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.resetTitle();
                    }
                }, 60L);
            }
            if (Data.waitingTimeInLobbyCountDown <= 25 && Bukkit.getOnlinePlayers().size() < 2) {
                Bukkit.broadcastMessage(Data.PREFIX + "§cEs müssen mindestens 2 Spieler online sein, damt die Runde startet!");
                Data.waitingTimeInLobbyCountDown = 30;
            }

            if (Data.waitingTimeInLobbyCountDown == 0) {
                Bukkit.getScheduler().cancelTask(cooldownSched);
                Bukkit.getScheduler().cancelTask(cooldownSched);
                startGameInstantly();
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException ex) {
                }
            }
        }, 0L, 20L);
    }

    public void startRestartSched() {
        restartSched = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars1vs1.plugin, () -> {
            --Data.restartCountdown;
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.setLevel(Data.restartCountdown);
            }
            if (Data.restartCountdown == 15 || Data.restartCountdown == 10 || Data.restartCountdown <= 5) {
                Bukkit.broadcastMessage(Data.PREFIX + "§cDer Server startet in §e" + Data.restartCountdown + " §7Sekunden §9neu!");
            }
            if (Data.restartCountdown == 0) {
                Bukkit.getScheduler().cancelTask(restartSched);
                Bukkit.shutdown();
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException ex) {
                }
            }
        }, 0L, 20L);
    }


    public void winAndEndGame(Player winner) {
        startRestartSched();
        winner.sendMessage(Data.PREFIX + "§7Du hast das Spiel §agewonnen! HGW! :)");
        GameState.setState(GameState.RESTART);
        for (Player all : Bukkit.getOnlinePlayers()) {
            WarpAPI.teleportToWarp(all, "LOBBY");
            all.setGameMode(GameMode.SURVIVAL);
            all.getInventory().setArmorContents(null);
            all.getInventory().clear();
            all.setHealth(20.0);
            all.setFoodLevel(20);
            all.setFireTicks(0);
            all.setLevel(0);
            all.setExp(0.0f);
            all.getInventory().setItem(4, new ItemBuilder(Material.BARRIER, 1, "§8✘ §aZurück zur §6L§eo§6b§eb§6y").build());

            WarpAPI.teleportToWarp(all, "LOBBY");
        }
    }

    public void startGameInstantly() {
        GameState.setState(GameState.RUNNING);
        Bukkit.broadcastMessage(Data.PREFIX + "§eDas Spiel hat nun §abegonnen! §aViel Glück! :)");

        for (Player all : Bukkit.getOnlinePlayers()) {
            GameBoard.applyGameBoard(all);
            all.setGameMode(GameMode.SURVIVAL);
            all.getInventory().setArmorContents(null);
            all.getInventory().clear();
            all.setHealth(20.0);
            all.setFoodLevel(20);
            all.setFireTicks(0);
            all.setLevel(0);
            all.setExp(0.0f);

            if (red.isInTeam(all)) {
                WarpAPI.teleportToWarp(all, "RED");
                all.setDisplayName(red.getTeamPrefix() + " §8| §4" + all.getName());
            } else if (blue.isInTeam(all)) {
                WarpAPI.teleportToWarp(all, "BLUE");
                all.setDisplayName(blue.getTeamPrefix() + " §8| §1" + all.getName());
            }
        }
        new JoinLeaveListener().applyGameRules();
        spawnerMethods.runBronzeSpawners();
        spawnerMethods.runIronSpawners();
        spawnerMethods.runGoldSpawners();
    }
}
