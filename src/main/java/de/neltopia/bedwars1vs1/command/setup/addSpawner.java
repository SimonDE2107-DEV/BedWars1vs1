package de.neltopia.bedwars1vs1.command.setup;

import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addSpawner implements CommandExecutor {

    int bronzeID;
    int ironID;
    int goldID;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Data.ONLY_INGAME);
            return true;
        }
        Player player = (Player) sender;

        if (player.hasPermission("bedwars1vs1.setup")) {
            if (GameState.isState(GameState.SETUP)) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("BRONZE")) {
                        bronzeID++;
                        if (bronzeID <= 2) {
                            WarpAPI.createWarp(player, "BRONZE"+bronzeID);
                            player.sendMessage(Data.PREFIX + "§e" + bronzeID + "§8/§c2");
                        } else {
                            player.sendMessage("§4Du hast das Limit an §cBronze-Spawners §eerreicht. §8(§e2§8)");
                        }
                    } else if (args[0].equalsIgnoreCase("IRON")) {
                        ironID++;
                        if (ironID <= 4) {
                            WarpAPI.createWarp(player, "IRON"+ironID);
                            player.sendMessage(Data.PREFIX + "§e" + ironID + "§8/§c4");
                        } else {
                            player.sendMessage("§4Du hast das Limit an §7Eisen-Spawners §eerreicht. §8(§e4§8)");
                        }
                    } else if (args[0].equalsIgnoreCase("GOLD")) {
                        goldID++;
                        if (goldID <= 2) {
                            WarpAPI.createWarp(player, "GOLD"+goldID);
                            player.sendMessage(Data.PREFIX + "§e" + goldID + "§8/§c2");
                        } else {
                            player.sendMessage("§4Du hast das Limit an §6Gold-Spawners §eerreicht. §8(§e2§8)");
                        }
                    } else {
                        player.sendMessage(Data.USAGE + "/addspawner [BRONZE|IRON|GOLD]");
                    }
                } else {
                    player.sendMessage(Data.USAGE + "/addspawner [BRONZE|IRON|GOLD]");
                }
            } else {
                player.sendMessage(Data.PREFIX + "§cDer Server befindet sich nicht im §eEinrichtungsmodus. §9/setupmode");
            }
        } else {
            player.sendMessage(Data.NO_PERMISSIONS + "bedwars1vs1.setup");
        }
        return true;
    }
}
