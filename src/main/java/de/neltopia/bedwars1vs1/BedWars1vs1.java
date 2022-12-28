package de.neltopia.bedwars1vs1;

import de.neltopia.bedwars1vs1.command.setup.addSpawner;
import de.neltopia.bedwars1vs1.command.setup.setLoc;
import de.neltopia.bedwars1vs1.command.setup.setTeam;
import de.neltopia.bedwars1vs1.command.setup.setupMode;
import de.neltopia.bedwars1vs1.command.startCommand;
import de.neltopia.bedwars1vs1.listener.*;
import de.neltopia.bedwars1vs1.listener.feature.SafetyPlatform;
import de.neltopia.bedwars1vs1.listener.lobby.*;
import de.neltopia.bedwars1vs1.util.BedManager;
import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.bedwars1vs1.util.StartGame;
import de.neltopia.bedwars1vs1.util.TeamHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedWars1vs1 extends JavaPlugin {

    public static TeamHandler red, blue, spectator;
    public static BedWars1vs1 plugin;

    @Override
    public void onEnable() {
        initTeams();
        plugin = this;
        GameState.setState(GameState.LOBBY);

        registerCommand();
        registerListener(this,
                new SafetyPlatform(), new AntiBuild(), new AntiDrop(), new AntiEntDamage(), new AntiHunger(),
                new AntiInteract(), new AntiInvClick(), new InteractListener(), new NoFallToVoid(), new AntiBedEnter(),
                new AntiCrafting(), new AntiKillVillager(), new AntiMobSpawn(), new AntiWeather(), new AsyncPlayerChat(),
                new BedBreakList(), new BlockPlaceColor(), new BuildList(), new DeathMessages(), new JoinLeaveListener(),
                new MotdList(), new NoItemDropOnDeath(), new RespawnList(), new RightClickVillager(), new ShopClickList());
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    void initTeams() {
        red = new TeamHandler("Rot", "§4Rot");
        blue = new TeamHandler("Blau", "§1Blau");
        spectator = new TeamHandler("Spec", "§5Spec");
        BedManager.hasBed.add(red);
        BedManager.hasBed.add(blue);
    }


    void registerCommand() {
        getCommand("addspawner").setExecutor(new addSpawner());
        getCommand("setloc").setExecutor(new setLoc());
        getCommand("setteam").setExecutor(new setTeam());
        getCommand("setupmode").setExecutor(new setupMode());
        getCommand("start").setExecutor(new startCommand());
    }

    void registerListener(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
        }
    }
}
