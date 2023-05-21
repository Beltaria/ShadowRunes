package me.bluedyaishela.shadowrunes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack DamageSword;
    public static ItemStack DamageRunes;

    public static void init() {
        createDamageSword();
        createDamageRunes();
    }

    private static void createDamageSword() {
        // Crée l'épée qui possède des dégâts supplémentaires (lore)
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§cHache de dégâts");

        List<String> lore = new ArrayList<>();
        lore.add("§f» Bonus de dégâts : §c+50%");
        lore.add("§f» §cObjet Opérateur");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        item.setItemMeta(meta);
        DamageSword = item;
    }
    private static void createDamageRunes() {
        // Crée une rune pouvant être ajoutée sur une épée
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§5Altaïr Céleste");

        List<String> lore = new ArrayList<>();
        lore.add("§f» Bonus de dégâts : §c+5%");
        lore.add("§f» §cObjet Opérateur");
        meta.setLore(lore);

        item.setItemMeta(meta);
        DamageRunes = item;
    }
}
