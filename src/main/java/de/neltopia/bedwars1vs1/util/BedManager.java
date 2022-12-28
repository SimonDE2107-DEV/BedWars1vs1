package de.neltopia.bedwars1vs1.util;

import de.neltopia.bedwars1vs1.util.scoreboard.GameBoard;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BedManager {

    public static ArrayList<TeamHandler> hasBed = new ArrayList<>();

    public boolean hasBed(TeamHandler team) {
        return hasBed.contains(team);
    }
    public void breakBed(Player breaker, TeamHandler team) {
        hasBed.remove(team);
        GameBoard.updateGameBoard();
        Bukkit.broadcastMessage(Data.PREFIX + "§cDas Bett von Team " + team.getTeamPrefix() + " §cwurde von §e" + breaker.getName() + " §4zerstört.");

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.playSound(all.getLocation(),Sound.ENTITY_ENDER_DRAGON_GROWL, 3,3);
        }
    }
}
