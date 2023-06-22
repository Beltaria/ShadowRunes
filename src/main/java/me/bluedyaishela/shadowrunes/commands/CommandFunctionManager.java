package me.bluedyaishela.shadowrunes.commands;

import me.bluedyaishela.shadowrunes.ItemManager;
import me.bluedyaishela.shadowrunes.utils.Armors;
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
import java.util.Random;

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

        Armors armors = new Armors();

        /*
            Vérification des prérequis
         */

        if (player.getItemInHand() == null) return false;

        ItemStack itemInHand = player.getItemInHand();

        if (itemInHand == null || !armors.getArmors().contains(itemInHand.getType())) return false;

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

        Random random = new Random();

        int randomUn = random.nextInt(2);
        int randomDeux = random.nextInt(2);
        int randomTrois = random.nextInt(2);

        System.out.println(randomUn + " " + randomDeux + " " + randomTrois);

        List<String> lore = new ArrayList<>();

        if (randomUn == 1) lore.add("§aSpeed " + RandomNumberGenerator.getRandom() + "%");
        if (randomDeux == 1) lore.add("§aResistance " + RandomNumberGenerator.getRandom() + "%");
        if (randomTrois == 1) lore.add("§aHealth " + RandomNumberGenerator.getRandom() + "%");

        if (lore.size() == 0)
        {
            int randomSwitch = random.nextInt(3);

            switch (randomSwitch) {
                case 0: lore.add("§aSpeed " + RandomNumberGenerator.getRandom() + "%");
                case 1: lore.add("§aResistance " + RandomNumberGenerator.getRandom() + "%");
                case 2: lore.add("§aHealth " + RandomNumberGenerator.getRandom() + "%");
            }
        }

        lore.add("");
        lore.add("§eDépose cette rune sur ton armure pour l'améliorer !");

        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§6Rune d'amélioration");
        itemStack.setItemMeta(itemMeta);

        player.setItemInHand(itemStack);
        player.sendMessage("§aOrbe obtenue avec succès !");

        return true;
    }
}
