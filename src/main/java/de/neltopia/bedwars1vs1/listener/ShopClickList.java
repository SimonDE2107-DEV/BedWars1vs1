package de.neltopia.bedwars1vs1.listener;

import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.Shop;
import de.neltopia.bedwars1vs1.util.SpawnerMethods;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class ShopClickList implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().equals(new Shop().name)) {
                    event.setCancelled(true);

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().blocks)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().blocksMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().blocksMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().armor)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().armorMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().armorMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().swords)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().swordsMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().swordsMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().picks)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().picksMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().picksMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().bows)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().bowsMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().bowsMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().food)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().foodMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().foodMenu(blue));
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(new Shop().special)) {
                        if (red.isInTeam(player)) {
                            player.openInventory(new Shop().specialMenu(red));
                        } else if (blue.isInTeam(player)) {
                            player.openInventory(new Shop().specialMenu(blue));
                        }

                        // BLOCKS
                    } else if (event.getCurrentItem().getType().equals(Material.RED_CONCRETE)
                            || event.getCurrentItem().getType().equals(Material.BLUE_CONCRETE)) {
                        buyAndRemoveBronze(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.END_STONE)) {
                        buyAndRemoveBronze(player, 7, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.IRON_BLOCK)) {
                        buyAndRemoveIron(player, 3, event.getView(), event.getCurrentItem());


                        // ARMOR
                    } else if (event.getCurrentItem().getType().equals(Material.LEATHER_HELMET)) {
                        buyAndRemoveBronze(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.LEATHER_LEGGINGS)) {
                        buyAndRemoveBronze(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.LEATHER_BOOTS)) {
                        buyAndRemoveBronze(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel I Brustplatte")) {
                        buyAndRemoveIron(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel II Brustplatte")) {
                        buyAndRemoveIron(player, 3, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.SHIELD)) {
                        buyAndRemoveGold(player, 2, event.getView(), event.getCurrentItem());


                        // SWORDS
                    } else if (event.getCurrentItem().getType().equals(Material.STICK)) {
                        buyAndRemoveBronze(player, 8, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel I Schwert")) {
                        buyAndRemoveIron(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel II Schwert")) {
                        buyAndRemoveIron(player, 3, event.getView(), event.getCurrentItem());


                        // PICKS
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel I Spitzhacke")) {
                        buyAndRemoveBronze(player, 4, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel II Spitzhacke")) {
                        buyAndRemoveIron(player, 2, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel III Spitzhacke")) {
                        buyAndRemoveGold(player, 1, event.getView(), event.getCurrentItem());


                        // BOWS
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel I Bogen")) {
                        buyAndRemoveGold(player, 3, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLevel II Bogen")) {
                        buyAndRemoveGold(player, 7, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.ARROW)) {
                        buyAndRemoveBronze(player, 10, event.getView(), event.getCurrentItem());


                        // FOOD
                    } else if (event.getCurrentItem().getType().equals(Material.APPLE)) {
                        buyAndRemoveBronze(player, 1, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.COOKED_PORKCHOP)) {
                        buyAndRemoveBronze(player, 2, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.GOLDEN_APPLE)) {
                        buyAndRemoveGold(player, 1, event.getView(), event.getCurrentItem());

                        // SPECIAL
                    } else if (event.getCurrentItem().getType().equals(Material.BLAZE_ROD)) {
                        buyAndRemoveGold(player, 3, event.getView(), event.getCurrentItem());
                    } else if (event.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
                        buyAndRemoveGold(player, 13, event.getView(), event.getCurrentItem());
                    }
                }
            }
        }

    private void buyAndRemoveBronze(Player player, int price, InventoryView inventoryView, ItemStack itemToBuy) {
        if (inventoryView != player.getInventory()) {
            if (hasEnoughBronze(player, price)) {
                player.getInventory().removeItem(new SpawnerMethods().bronze(price));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                player.getInventory().addItem(itemToBuy);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3, 3);
                player.closeInventory();
                player.sendMessage(Data.PREFIX + "§4Du benötigst mind. §c" + price + " Bronze, §4um das Item zu kaufen.");
            }
        }
    }

    private void buyAndRemoveIron(Player player, int price, InventoryView inventoryView, ItemStack itemToBuy) {
        if (inventoryView != player.getInventory()) {
            if (hasEnoughIron(player, price)) {
                player.getInventory().removeItem(new SpawnerMethods().iron(price));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                player.getInventory().addItem(itemToBuy);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3, 3);
                player.closeInventory();
                player.sendMessage(Data.PREFIX + "§4Du benötigst mind. §8" + price + " Eisen, §4um das Item zu kaufen.");
            }
        }
    }

    private void buyAndRemoveGold(Player player, int price, InventoryView inventoryView, ItemStack itemToBuy) {
        if (inventoryView != player.getInventory()) {
            if (hasEnoughGold(player, price)) {
                player.getInventory().removeItem(new SpawnerMethods().gold(price));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                player.getInventory().addItem(itemToBuy);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 3, 3);
                player.closeInventory();
                player.sendMessage(Data.PREFIX + "§4Du benötigst mind. §6" + price + " Gold, §4um das Item zu kaufen.");
            }
        }
    }

    private Boolean hasEnoughBronze(Player player, int amount) {
        return player.getInventory().containsAtLeast(new SpawnerMethods().bronze(amount), amount);
    }

    private Boolean hasEnoughIron(Player player, int amount) {
        return player.getInventory().containsAtLeast(new SpawnerMethods().iron(amount), amount);
    }

    private Boolean hasEnoughGold(Player player, int amount) {
        return player.getInventory().containsAtLeast(new SpawnerMethods().gold(amount), amount);
    }
}
