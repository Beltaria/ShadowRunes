package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ItemManager;
import me.bluedyaishela.shadowrunes.ShadowRunes;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Damage implements Listener {

    private final ShadowRunes main;

    public Damage(ShadowRunes plugin)
    {
        this.main = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        // Vérifie qu'il s'agit bien d'un joueur qui a déclenché l'évènement
        if (!(event.getWhoClicked() instanceof Player))
        {
            return;
        }

        // On récupère le joueur qui a cliqué et l'objet actuellement sélectionné
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem(); // La hache en diamant

        if (clickedItem != null && clickedItem.getType() == Material.DIAMOND_AXE)
        {
            ItemMeta clickedMeta = clickedItem.getItemMeta(); // Meta de la hache en diamant
            ItemStack selectedItem = player.getItemOnCursor(); // Etoile du nether
            if (selectedItem != null && selectedItem.getType() == Material.NETHER_STAR)
            {
                ItemMeta selectedItemMeta = selectedItem.getItemMeta(); // Meta de l'étoile du nether
                if (selectedItemMeta.getLore() != null && selectedItemMeta.getLore().contains("damage"))
                {
                    event.setCancelled(true);
                    player.sendMessage("Rune appliquée avec succès !");
                    clickedMeta.setLore(Collections.singletonList("bonus damage"));
                    clickedItem.setItemMeta(clickedMeta);

                    // Permet de supprimer l'étoile du nether
                    if (selectedItem.getAmount() > 1) {
                        selectedItem.setAmount(selectedItem.getAmount() - 1);
                    } else {
                        // Faire le code qui permet de supprimer l'étoile lorsqu'il n'y en a qu'une
                        player.sendMessage(String.valueOf(selectedItem.getAmount()));
                    }
                }
            }
        }




//        player.sendMessage("1");
//        if (clickedItem != null && clickedItem.getType() == Material.DIAMOND_AXE)
//        {
//            player.sendMessage("2");
//            ItemMeta clickedMeta = clickedItem.getItemMeta(); // Le meta de la hache en diamant
////            if (clickedMeta != null && clickedMeta.getLore() != null && clickedMeta.getLore().contains("damage"))
////            {
////                player.sendMessage("3");
//                ItemStack selectedItem = player.getItemOnCursor();
//                if (selectedItem != null && selectedItem.getType() == Material.NETHER_STAR)
//                {
//                    player.sendMessage("4");
//                    ItemMeta selectedMeta = selectedItem.getItemMeta();
//                    if (selectedMeta != null) {
//                        clickedMeta.setLore(Collections.singletonList("bonus damage"));
//                        selectedItem.setItemMeta(selectedMeta);
//                        player.sendMessage("5");
//                        if (clickedItem.getAmount() > 1) {
//                            clickedItem.setAmount(clickedItem.getAmount() - 1);
//                        } else {
//                            clickedItem.setAmount(0);
////                            player.getInventory().remove(clickedItem);
//                        }
//                    }
//                }
////            }
//        }




//        player.sendMessage("Stade 1 : " + clickedItem);
//        // On vérifie que l'item est bien une étoile du nether
//        if (clickedItem != null && clickedItem.getType() == Material.NETHER_STAR)
//        {
//            // On vérifie ensuite que le lore est valide
//            ItemMeta itemMeta = clickedItem.getItemMeta();
//            player.sendMessage("Stade 2 : " + itemMeta);
//            if (itemMeta != null && itemMeta.getLore() != null && itemMeta.getLore().contains("damage"))
//            {
//                // On récupère ensuite l'objet dans l'inventaire au dépôt de l'étoile et on vérifie que ce n'est pas vide.
//                ItemStack weapon = player.getItemOnCursor();
//                player.sendMessage("Stade 3 : " + weapon);
//                if (weapon != null && weapon.getType() == Material.DIAMOND_AXE)
//                {
//                    ItemMeta weaponMeta = weapon.getItemMeta();
//                    player.sendMessage("Stade 4 : " + weaponMeta);
//                    if (weaponMeta != null) {
//                        weaponMeta.setLore(Collections.singletonList("bonus damage"));
//                        weapon.setItemMeta(weaponMeta);
//                        if (clickedItem.getAmount() > 1) {
//                            clickedItem.setAmount(clickedItem.getAmount() - 1);
//                        } else {
//                            clickedItem.setAmount(0);
////                            player.getInventory().remove(clickedItem);
//                        }
//                    }
//                }
//            }
//        }

    }
    @EventHandler
    public void onDamage()
    {

    }


}
