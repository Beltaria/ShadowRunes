package me.bluedyaishela.shadowrunes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player)sender;
            if (args.length == 0)
            {
                player.sendMessage("§cVous n'avez pas sélectionné d'arguments lors de l'exécution de la commande, ré-essayez.");
                player.sendMessage("§cExemple : /shadowrunes <value>");
            } else {
                String argument = args[0];

                if (argument.equals("damagesword"))
                {
                    player.getInventory().addItem(ItemManager.DamageSword);
                } else if (argument.equals("damagerune")) {
                    player.getInventory().addItem(ItemManager.DamageRunes);
                }
            }
            player.sendMessage("§cCommande réussie.");
        }
        return false;
    }
}
