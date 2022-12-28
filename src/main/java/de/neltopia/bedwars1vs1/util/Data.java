package de.neltopia.bedwars1vs1.util;

import de.neltopia.warpsystem.WarpAPI;

public class Data {


    public static String PREFIX = "§9Bed§bWars§61§evs§61 §8✘ §7";
    public static String USAGE = PREFIX + "§cUsage: §e";
    public static String NO_PERMISSIONS = PREFIX + "§cYou don't have enough permission to perform this command. §9Missing Node: §e";
    public static String ONLY_INGAME = PREFIX + "§cThis command only works in-game";

    public static String lobbyWorldName = WarpAPI.warpLocation("LOBBY").getWorld().getName();
    public static String mapWorldName = WarpAPI.warpLocation("SPEC").getWorld().getName();



    public static int waitingTimeInLobbyCountDown = 30;
    public static int restartCountdown = 15;
    public static String map = "Herbst";
    public static String builder = "Snix3517";






}
