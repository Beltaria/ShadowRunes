package me.bluedyaishela.shadowrunes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("op"))
            {
//                if (command.getName().equalsIgnoreCase("givedamagesword")) {
//                    player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.DamageSword);
//                }
            }
            else
            {
                commandSender.sendMessage("You are not allowed to use this command.");
            }
            return true;
        }
        else {
            commandSender.sendMessage("Only players can use that command.");
            return true;
        }
    }
}
