package me.bluedyaishela.shadowrunes.commands;

import me.bluedyaishela.shadowrunes.ItemManager;
import me.bluedyaishela.shadowrunes.utils.UtilsPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFunctionManager {

    private UtilsPlayer utilsPlayer = new UtilsPlayer();

    public boolean helpCommand(CommandSender sender, String[] args)
    {
        // Code complet à effectuer
        sender.sendMessage("Menu d'aide");
        return true;
    }

    public boolean reloadCommand(CommandSender sender)
    {
        if(!sender.hasPermission("op"))
        {
            sender.sendMessage("Vous ne disposez pas des permissions nécessaires pour exécuter cette commande.");
            return false;
        }
        // Code à effectuer
        return true;
    }

    public boolean giveCommand(CommandSender sender, String[] args)
    {
        if(!sender.hasPermission("op"))
        {
            sender.sendMessage("Vous ne disposez pas des permissions nécessaires pour exécuter cette commande.");
            return false;
        }

        if (args.length < 2)
        {
            sender.sendMessage("Vous devez spécifier un joueur, exemple : /shadowrunes give <player> [object]");
            return false;
        }

        String pseudo = args[1];

        if (!utilsPlayer.isPlayerOnline(pseudo))
        {
            sender.sendMessage("Le joueur n'est pas connecté ou n'existe pas.");
            return false;
        }

        Player player = Bukkit.getPlayer(pseudo);

        if (args.length < 3)
        {
            sender.sendMessage("Vous devez spécifier un objet à vous donner, exemple : /shadowrunes give <player> [object]");
            return false;
        }

        switch (args[2]) {
            case "damagesword":
                player.getInventory().addItem(ItemManager.DamageSword);
                player.sendMessage("Arme obtenue avec succès.");
                return true;
        }

        sender.sendMessage("L'objet recherché n'existe pas");
        return false;
    }
}
