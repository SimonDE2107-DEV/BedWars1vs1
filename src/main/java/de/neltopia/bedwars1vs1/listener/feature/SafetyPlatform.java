package de.neltopia.bedwars1vs1.listener.feature;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.bedwars1vs1.listener.BuildList;
import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class SafetyPlatform implements Listener {

    ArrayList<Player> coolDown = new ArrayList<Player>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (GameState.isState(GameState.RUNNING)) {
            if (player.getItemInHand().getType() == Material.BLAZE_ROD && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                if (!coolDown.contains(player)) {
                    addToCoolDown(player);
                    if (player.getItemInHand().getAmount() == 1)
                        player.getInventory().remove(player.getItemInHand());
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                    Location loc1 = player.getLocation().add(0.0D, -3.0D, 1.0D);
                    Location loc2 = player.getLocation().add(0.0D, -3.0D, 0.0D);
                    Location loc3 = player.getLocation().add(0.0D, -3.0D, -1.0D);
                    Location loc4 = player.getLocation().add(1.0D, -3.0D, 0.0D);
                    Location loc5 = player.getLocation().add(-1.0D, -3.0D, 0.0D);
                    Location loc6 = player.getLocation().add(1.0D, -3.0D, -1.0D);
                    Location loc7 = player.getLocation().add(-1.0D, -3.0D, -1.0D);
                    Location loc8 = player.getLocation().add(-1.0D, -3.0D, 1.0D);
                    Location loc9 = player.getLocation().add(1.0D, -3.0D, 1.0D);

                    if (BedWars1vs1.red.isInTeam(player)) {
                        if (loc1.getBlock().getType() == Material.AIR) {
                            loc1.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc1.getBlock());
                        }
                        if (loc2.getBlock().getType() == Material.AIR) {
                            loc2.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc2.getBlock());
                        }
                        if (loc3.getBlock().getType() == Material.AIR) {
                            loc3.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc3.getBlock());
                        }
                        if (loc4.getBlock().getType() == Material.AIR) {
                            loc4.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc4.getBlock());
                        }
                        if (loc5.getBlock().getType() == Material.AIR) {
                            loc5.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc5.getBlock());
                        }
                        if (loc6.getBlock().getType() == Material.AIR) {
                            loc6.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc6.getBlock());
                        }
                        if (loc7.getBlock().getType() == Material.AIR) {
                            loc7.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc7.getBlock());
                        }
                        if (loc8.getBlock().getType() == Material.AIR) {
                            loc8.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc8.getBlock());
                        }
                        if (loc9.getBlock().getType() == Material.AIR) {
                            loc9.getBlock().setType(Material.RED_CONCRETE);
                            new BuildList().placedBlocks.add(loc9.getBlock());
                        }
                    } else if (BedWars1vs1.blue.isInTeam(player)) {
                        if (loc1.getBlock().getType() == Material.AIR) {
                            loc1.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc1.getBlock());
                        }
                        if (loc2.getBlock().getType() == Material.AIR) {
                            loc2.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc2.getBlock());
                        }
                        if (loc3.getBlock().getType() == Material.AIR) {
                            loc3.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc3.getBlock());
                        }
                        if (loc4.getBlock().getType() == Material.AIR) {
                            loc4.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc4.getBlock());
                        }
                        if (loc5.getBlock().getType() == Material.AIR) {
                            loc5.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc5.getBlock());
                        }
                        if (loc6.getBlock().getType() == Material.AIR) {
                            loc6.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc6.getBlock());
                        }
                        if (loc7.getBlock().getType() == Material.AIR) {
                            loc7.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc7.getBlock());
                        }
                        if (loc8.getBlock().getType() == Material.AIR) {
                            loc8.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc8.getBlock());
                        }
                        if (loc9.getBlock().getType() == Material.AIR) {
                            loc9.getBlock().setType(Material.BLUE_CONCRETE);
                            new BuildList().placedBlocks.add(loc9.getBlock());
                        }
                    }
                } else if (coolDown.contains(player)) {
                    player.sendMessage(Data.PREFIX + "§cBitte warte einen Moment..");
                }
            }
        }
    }

    void addToCoolDown(Player player) {
        coolDown.add(player);

        Bukkit.getScheduler().runTaskLater(BedWars1vs1.plugin, () -> coolDown.remove(player), 2 * 20);
    }
}