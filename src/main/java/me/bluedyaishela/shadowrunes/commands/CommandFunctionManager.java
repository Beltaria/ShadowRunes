package me.bluedyaishela.shadowrunes.commands;

import me.bluedyaishela.shadowrunes.ItemManager;
import me.bluedyaishela.shadowrunes.utils.RandomNumberGenerator;
import me.bluedyaishela.shadowrunes.utils.UtilsPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

        // Problème sur le pseudo à régler
        if (!utilsPlayer.isPlayerOnline(pseudo))
        {
            sender.sendMessage("Le joueur n'est pas connecté");
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

    public boolean generateCommand(CommandSender sender)
    {
        String senderName = sender.getName();
        Player player = Bukkit.getPlayer(senderName);

        /*
            Vérification des prérequis
         */

        ItemStack itemInHand = player.getItemInHand();

        if (itemInHand == null) return false;

        ItemMeta itemMetaInHand = itemInHand.getItemMeta();

        if (!itemMetaInHand.hasEnchants()) return false;
        if (!itemMetaInHand.hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)) return false;

        int protectionLevel = itemMetaInHand.getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);

        if (protectionLevel != 4) return false;

        /*
            Génération de l'item
         */

        ItemStack itemStack = new ItemStack(Material.DOUBLE_PLANT);
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> lore = new ArrayList<>();
        lore.add("§aSpeed " + RandomNumberGenerator.getRandom() + "%");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

//        player.getInventory().addItem(itemStack);
        player.setItemInHand(itemStack);
        player.sendMessage("§aOrbe obtenue avec succès !");

        return true;
    }
}
