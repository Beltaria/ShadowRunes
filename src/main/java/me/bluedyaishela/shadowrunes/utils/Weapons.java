package me.bluedyaishela.shadowrunes.utils;

import org.bukkit.Material;

import java.util.ArrayList;

public class Weapons {

    public ArrayList<Material> getWeapons()
    {
        ArrayList<Material> weapon = new ArrayList<>();

        weapon.add(Material.WOOD_AXE);
        weapon.add(Material.WOOD_SWORD);
        weapon.add(Material.STONE_AXE);
        weapon.add(Material.STONE_SWORD);
        weapon.add(Material.IRON_AXE);
        weapon.add(Material.IRON_SWORD);
        weapon.add(Material.GOLD_AXE);
        weapon.add(Material.GOLD_SWORD);
        weapon.add(Material.DIAMOND_AXE);
        weapon.add(Material.DIAMOND_SWORD);

        return weapon;
    }

}
