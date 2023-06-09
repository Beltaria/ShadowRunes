package me.bluedyaishela.shadowrunes.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsValue {

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

    public Float getFloatOfLoreRune(String lore)
    {
        String motif = "\\d+";
        Pattern pattern = Pattern.compile(motif);
        Matcher matcher = pattern.matcher(lore);

        if (matcher.find()) {
            String resultat = matcher.group();
            Float entier = (float) Integer.parseInt(resultat);
            return entier;
        } else {
            return 0F;
        }
    }

    public float getFloatFromPercentage(Float initialValue, Float percentage)
    {
        return initialValue + (initialValue * percentage / 100);
    }

}
