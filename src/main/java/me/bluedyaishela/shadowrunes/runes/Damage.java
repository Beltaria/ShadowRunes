package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ItemManager;
import me.bluedyaishela.shadowrunes.ShadowRunes;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
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

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.getType() == Material.DIAMOND_AXE) {
            ItemMeta clickedMeta = clickedItem.getItemMeta();

            List<String> lore = new ArrayList<>();
            lore.add("Bonus");
            clickedMeta.setLore(lore);
            clickedItem.setItemMeta(clickedMeta);
        }

    }
    @EventHandler
    public void onDamage()
    {

    }


}
