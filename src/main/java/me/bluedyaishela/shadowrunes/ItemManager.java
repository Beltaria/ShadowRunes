package me.bluedyaishela.shadowrunes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemManager {

    public static ItemStack DamageSword;
    public static ItemStack DamageRunes;
    public static ItemStack HighRune;
    public static ItemStack RandomRuneSpeed;

    public static void init() {
        createDamageSword();
        createDamageRunes();
        createHighRune();
        createRandomRuneSpeed();
    }

    public void getDamageRune()
    {

    }

    private static void createDamageSword() {
        // Crée l'épée qui possède des dégâts supplémentaires (lore)
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§cHache de dégâts");

        List<String> lore = new ArrayList<>();
        lore.add("§r» Bonus de dégâts : §c+50%");
        lore.add("§r» §cObjet Opérateur");
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
        lore.add("§r» Bonus de dégâts : §c+5%");
        lore.add("§r» §cObjet Opérateur");
        meta.setLore(lore);

        item.setItemMeta(meta);
        DamageRunes = item;
    }

    private static void createHighRune() {
        // Crée une rune pouvant être ajoutée sur une épée
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§5Altaïr Céleste");

        List<String> lore = new ArrayList<>();
        lore.add("§r» Bonus de dégâts : §c+200%");
        lore.add("§r» §cObjet Opérateur");
        meta.setLore(lore);

        item.setItemMeta(meta);
        HighRune = item;
    }

    private static void createRandomRuneSpeed()
    {
        Random random = new Random();
        float minValue = 0.00f;
        float maxValue = 10.00f;
        float randomValue = minValue + random.nextFloat() * (maxValue - minValue);
        float roundedValue = Math.round(randomValue * 100) / 100f;

        ItemStack itemStack = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§bRune de vitesse");
        List<String> lore = new ArrayList<>();
        lore.add("§aSpeed " + roundedValue + "%");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        RandomRuneSpeed = itemStack;
    }
}
