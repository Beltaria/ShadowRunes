package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ShadowRunes;
import me.bluedyaishela.shadowrunes.utils.IntegerValue;
import me.bluedyaishela.shadowrunes.utils.Weapons;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
        // Fichier de configuration
        FileConfiguration config = main.getConfig();

        // Instancie mes Classes
        Weapons weapons = new Weapons();
        IntegerValue integerValue = new IntegerValue();

        // On récupère le joueur qui a cliqué et l'objet actuellement sélectionné
        Player player = (Player) event.getWhoClicked();
        ItemStack arme = event.getCurrentItem();

        // Condition si "arme" est null
        if (arme == null)
        {
            return;
        }

        // Condition si "arme" est bien une arme
        if (!weapons.getWeapons().contains(arme.getType()))
        {
            return;
        }

        // On récupère la rune et on vérifie qu'il s'agisse bien d'une étoile du nether
        ItemStack rune = player.getItemOnCursor();
        if (rune.getType() != Material.NETHER_STAR )
        {
            return;
        }

        // On récupère maintenant la meta de la rune et on vérifie qu'il s'agisse bien d'une rune
        ItemMeta metaRune = rune.getItemMeta();
        boolean stringInLore = integerValue.searchStringInLore(metaRune.getLore(), config.getString("runes.damage.lore"));
        if (!stringInLore || metaRune.getLore() == null) // A modifier !metaRune.getLore().contains("damage")
        {
            return;
        }


        // Récupération de la valeur de la rune :
        int runeValue = integerValue.getIntegerOfLoreRune(metaRune.getLore().toString());
        int maxMultiplier = config.getInt("runes.damage.max-multiplier");

        if (runeValue > maxMultiplier)
        {
            player.sendMessage(config.getString("plugin_commands") + "Cette rune n'est pas valide. Merci de contacter un administrateur");
            return;
        }

        // On récupère la meta de l'arme et on conserve l'ensemble de ses lore :
        ItemMeta metaArme = arme.getItemMeta();


        // Je vérifie si l'arme possède un lore :
        if (metaArme.hasLore())
        {
            ArrayList<String> ancienLore = new ArrayList<>(metaArme.getLore());

            // On vérifie si l'arme possède le lore souhaité ou non
            if (integerValue.searchStringInLore(metaArme.getLore(), config.getString("runes.damage.lore"))) {
                int index = 0;
                for (String lineLore : ancienLore)
                {
                    if (integerValue.searchStringinString(lineLore, config.getString("runes.damage.lore")))
                    {
                        // On récupère la ligne du lore avec la valeur assignée et on ajoute la nouvelle en supplément
                        int armeDamage = integerValue.getIntegerOfLoreRune(ancienLore.get(index));
                        int newDamage = armeDamage + runeValue;

                        // Vérifie la valeur totale
                        if (maxMultiplier < newDamage) {
                            player.sendMessage(config.getString("plugin_commands") + "Augmentation de dégâts limitée à §c" + maxMultiplier + "%");
                            return;
                        }

                        ancienLore.set(index, config.getString("runes.damage.lore") + "§c+" + newDamage + "%");
                        metaArme.setLore(ancienLore);
                        arme.setItemMeta(metaArme);
                        break; // Sort de la boucle lorsque la valeur est trouvée
                    }
                    index++;
                }
            }
            else
            {
                ancienLore.add(config.getString("runes.damage.lore") + "§c+" + runeValue + "%");
                metaArme.setLore(ancienLore);
                arme.setItemMeta(metaArme);
            }
        }
        else // Si l'arme n'a pas de lore
        {
            ArrayList<String> createLore = new ArrayList<>();
            createLore.add(config.getString("runes.damage.lore") + "§c+" + runeValue + "%");
            metaArme.setLore(createLore);
            arme.setItemMeta(metaArme);
        }

        event.setCancelled(true);

        if (rune.getAmount() > 1) {
            rune.setAmount(rune.getAmount() - 1);
        } else {
            player.setItemOnCursor(null);
        }

        player.sendMessage(config.getString("plugin_commands") + "Votre rune a été appliquée avec §asuccès §r!");



    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        // Fichier de configuration
        FileConfiguration config = main.getConfig();

        IntegerValue integerValue = new IntegerValue();

        Player player = (Player) event.getDamager();
        ItemStack weapon = player.getItemInHand();

        if (weapon != null && weapon.getType() == Material.DIAMOND_SWORD) {
            ItemMeta itemMeta = weapon.getItemMeta();

            if (itemMeta != null && itemMeta.hasLore()) {
                List<String> lore = itemMeta.getLore();

                for (String line : lore) {
                    if (line.contains(config.getString("runes.damage.lore"))) {

                        int damageWeapon = integerValue.getIntegerOfLoreRune(line);
                        double percentageDamage = event.getDamage() * 1 + (damageWeapon/event.getDamage());

                        player.sendMessage(event.getDamager().toString());
                        player.sendMessage(String.valueOf(percentageDamage));

                        event.setDamage(percentageDamage);
                        break;
                    }
                }
            }
        }
    }


}
