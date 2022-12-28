package de.neltopia.bedwars1vs1.util.scoreboard;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.util.BedManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class GameBoard {

    public static void applyGameBoard(Player player) {
        String redStr;
        if (new BedManager().hasBed(red)) {
            redStr = "§c§l♥ §4Rot";
        } else {
            redStr = "§8§l♥ §4Rot";
        }
        if (redStr.length() > 16) {
            redStr = redStr.substring(0, 16);
        }
        String blueStr;
        if (new BedManager().hasBed(blue)) {
            blueStr = "§c§l♥ §1Blau";
        } else {
            blueStr = "§8§l♥ §1Blau";
        }
        if (blueStr.length() > 16) {
            blueStr = blueStr.substring(0, 16);
        }
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");
        obj.setDisplayName("§b♦ BedWars ♦");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score one = obj.getScore(redStr);
        Score zero = obj.getScore(blueStr);
        one.setScore(1);
        zero.setScore(1);
        player.setScoreboard(board);
    }

    public static void removeGameBoard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    public static void updateGameBoard() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(BedWars1vs1.plugin, () -> {
            for (Player all : Bukkit.getOnlinePlayers()) {
                applyGameBoard(all);
            }
        }, 20L);
    }

}
