package de.neltopia.bedwars1vs1.command.setup;

import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import de.neltopia.warpsystem.WarpAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setTeam implements CommandExecutor {
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
                    if (args[0].equalsIgnoreCase("BLUE")) {
                        WarpAPI.createWarp(player, "BLUE");
                    } else if (args[0].equalsIgnoreCase("RED")) {
                        WarpAPI.createWarp(player, "RED");
                    } else {
                        player.sendMessage(Data.USAGE + "/setteam [BLUE|RED]");
                    }
                } else {
                    player.sendMessage(Data.USAGE + "/setteam [BLUE|RED]");
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
