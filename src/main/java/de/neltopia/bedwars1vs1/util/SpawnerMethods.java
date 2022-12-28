package de.neltopia.bedwars1vs1.util;

import de.neltopia.bedwars1vs1.BedWars1vs1;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SpawnerMethods {

    public String bronzeName = "§cBronze";
    public String ironName = "§8Eisen";
    public String goldName = "§6Gold";

    public ItemStack bronze(int amount) {
        return new ItemBuilder(Material.LEGACY_CLAY_BRICK, amount, bronzeName).build();
    }

    public ItemStack iron(int amount) {
        return new ItemBuilder(Material.IRON_INGOT, amount, ironName).build();
    }

    public ItemStack gold(int amount) {
        return new ItemBuilder(Material.GOLD_INGOT, amount, goldName).build();
    }

    public void runBronzeSpawners() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars1vs1.plugin, () -> {
            try {
                if (WarpAPI.warpExists("BRONZE1")) {
                    WarpAPI.warpLocation("BRONZE1").getWorld().dropItemNaturally(WarpAPI.warpLocation("BRONZE1"), bronze(1));
                }

                if (WarpAPI.warpExists("BRONZE2")) {
                    WarpAPI.warpLocation("BRONZE2").getWorld().dropItemNaturally(WarpAPI.warpLocation("BRONZE2"), bronze(1));
                }
            } catch (Exception ex) {
            }
        }, 0L, 1 * 20);
    }

    public void runIronSpawners() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars1vs1.plugin, () -> {
            try {
                if (WarpAPI.warpExists("IRON1")) {
                    WarpAPI.warpLocation("IRON1").getWorld().dropItemNaturally(WarpAPI.warpLocation("IRON1"), iron(1));
                }
                if (WarpAPI.warpExists("IRON2")) {
                    WarpAPI.warpLocation("IRON2").getWorld().dropItemNaturally(WarpAPI.warpLocation("IRON2"), iron(1));
                }

                if (WarpAPI.warpExists("IRON3")) {
                    WarpAPI.warpLocation("IRON3").getWorld().dropItemNaturally(WarpAPI.warpLocation("IRON3"), iron(1));
                }
                if (WarpAPI.warpExists("IRON4")) {
                    WarpAPI.warpLocation("IRON4").getWorld().dropItemNaturally(WarpAPI.warpLocation("IRON4"), iron(1));
                }
            } catch (Exception ex) {
            }
        }, 0L, 35 * 20);
    }

    public void runGoldSpawners() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars1vs1.plugin, () -> {
            try {
                if (WarpAPI.warpExists("GOLD1")) {
                    WarpAPI.warpLocation("GOLD1").getWorld().dropItemNaturally(WarpAPI.warpLocation("GOLD1"), gold(1));
                }
                if (WarpAPI.warpExists("GOLD2")) {
                    WarpAPI.warpLocation("GOLD2").getWorld().dropItemNaturally(WarpAPI.warpLocation("GOLD2"), gold(1));
                }
            } catch (Exception ex) {
            }
        }, 0L, 60 * 20);
    }
}
