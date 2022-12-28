package de.neltopia.bedwars1vs1.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class TeamHandler {


    private final String name;
    private final String prefix;
    private final ArrayList<String> teamMembers;
    private final int maxPlayersInOneTeam;

    public TeamHandler(String name, String prefix) {
        this.name = name;
        this.maxPlayersInOneTeam = 1;
        this.prefix = prefix;
        this.teamMembers = new ArrayList<>();
    }


    public int getMaxPlayers() {
        return maxPlayersInOneTeam;
    }

    public String getTeamName() {
        return name;
    }

    public String getTeamPrefix() {
        return prefix;
    }

    public ArrayList<String> getPlayersInTeam() {
        return teamMembers;
    }

    public boolean isInTeam(Player player) {
        return teamMembers.contains(player.getName());
    }

    public static void setRandomTeam(Player player) {
        if (!blue.isInTeam(player) || !red.isInTeam(player)) {
            if (!teamIsFull(red)) {
                red.getPlayersInTeam().add(player.getName());
                player.setPlayerListName(red.getTeamPrefix()+" §8| §4"+player.getName());
            } else if (!teamIsFull(blue)) {
                blue.getPlayersInTeam().add(player.getName());
                player.setPlayerListName(blue.getTeamPrefix()+" §8| §1"+player.getName());
            }
        }
    }


    private static boolean teamIsFull(TeamHandler team) {
        return (team.getPlayersInTeam().size() == team.getMaxPlayers());
    }
}
