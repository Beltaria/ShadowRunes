package me.bluedyaishela.shadowrunes.utils;

import org.bukkit.Material;

import java.util.ArrayList;

public class Armors {

    public ArrayList<Material> getArmors()
    {
        ArrayList<Material> armor = new ArrayList<>();

        armor.add(Material.DIAMOND_HELMET);
        armor.add(Material.DIAMOND_CHESTPLATE);
        armor.add(Material.DIAMOND_LEGGINGS);
        armor.add(Material.DIAMOND_BOOTS);

        /*
            Autres types d'armures à rajouter prochainement
         */

        return armor;
    }
}
