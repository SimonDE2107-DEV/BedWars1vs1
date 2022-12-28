package de.neltopia.bedwars1vs1.command.setup;

import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.GameState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setupMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Data.ONLY_INGAME);
            return true;
        }
        Player player = (Player) sender;

        if (player.hasPermission("bedwars1vs1.setup")) {

            if (args.length == 0) {
                if (GameState.isState(GameState.SETUP)) {
                    Bukkit.shutdown();
                } else {
                    if (!GameState.isState(GameState.SETUP)) {
                        GameState.setState(GameState.SETUP);
                        player.sendMessage(Data.PREFIX + "§aDer Server befindet sich jetzt im §eEinrichtungsmodus.");
                    }
                }
            } else {
                player.sendMessage(Data.USAGE + "/setupmode");
            }
        } else {
            player.sendMessage(Data.NO_PERMISSIONS + "bedwars1vs1.setup");
        }

        return true;
    }
}
