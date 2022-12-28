package de.neltopia.bedwars1vs1.command;

import de.neltopia.bedwars1vs1.util.Data;
import de.neltopia.bedwars1vs1.util.StartGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class startCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Data.ONLY_INGAME);
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("bedwars1vs1.start")) {
            if (args.length == 0) {
                if (Bukkit.getOnlinePlayers().size() >= 2) {
                    if (Data.waitingTimeInLobbyCountDown >= 12) {
                        Data.waitingTimeInLobbyCountDown = 11;
                        player.sendMessage(Data.PREFIX + "§aDu hast den §eTimer §aauf §e10 §7Sekunden §averkürzt.");
                    } else {
                        player.sendMessage(Data.PREFIX + "§cGeduld bitte! Das Spiel startet bereits in §e" + Data.waitingTimeInLobbyCountDown + " §7Sekunden.");
                    }
                } else {
                    player.sendMessage(Data.PREFIX + "§cEs müssen mindestens 2 Spieler online sein, um den Countdown zu reduzieren.");
                }
            } else {
                player.sendMessage(Data.USAGE + "/start");
            }
        } else {
            player.sendMessage(Data.NO_PERMISSIONS+"bedwars1vs1.start");
        }
        return true;
    }
}
