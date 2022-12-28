package de.neltopia.bedwars1vs1.util.scoreboard;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class LobbyBoard {

    // TODO: Voting System if Gold should be enabled or disabled. Same with statistics.
    public static void applyLobbyBoard(Player player) {
        String map_name = "§a► §6Gold: §a✔";
        if (map_name.length() > 16) {
            map_name = map_name.substring(0, 16);
        }
        String online = "§a► §bStats: §c✖";
        if (online.length() > 16) {
            online = online.substring(0, 16);
        }
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");
        obj.setDisplayName("§b♦ BedWars ♦");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score one = obj.getScore(map_name);
        Score zero = obj.getScore(online);
        one.setScore(1);
        zero.setScore(0);
        player.setScoreboard(board);
    }

    public static void removeLobbyBoard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    public static void updateLobbyBoard() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(BedWars1vs1.plugin, new Runnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    applyLobbyBoard(all);
                }
            }
        }, 20L);
    }
}
