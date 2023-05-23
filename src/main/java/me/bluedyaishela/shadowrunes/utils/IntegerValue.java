package me.bluedyaishela.shadowrunes.utils;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValue {

    public boolean searchStringInLore(List<String> lore, String searchedValue)
    {
        for (String element : lore)
        {
            if (element.contains(searchedValue))
            {
                return true;
            }
        }
        return false;
    }

    public boolean searchStringinString(String defaultString, String searchedString)
    {
        if (defaultString.contains(searchedString))
        {
            return true;
        }
        return false;
    }

    public Integer getIntegerOfLoreRune(String lore)
    {
        String motif = "\\d+";
        Pattern pattern = Pattern.compile(motif);
        Matcher matcher = pattern.matcher(lore);

        if (matcher.find()) {
            String resultat = matcher.group();
            int entier = Integer.parseInt(resultat);
            return entier;
        } else {
            return 0;
        }
    }

}
