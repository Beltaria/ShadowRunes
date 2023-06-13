package me.bluedyaishela.shadowrunes;

import me.bluedyaishela.shadowrunes.utils.Armors;
import me.bluedyaishela.shadowrunes.utils.Weapons;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Runes implements Listener {

    private final ShadowRunes shadowRunes;

    public Runes(ShadowRunes shadowRunes)
    {
        this.shadowRunes = shadowRunes;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if (!(event.getWhoClicked() instanceof Player))
        {
            return;
        }

        Weapons weapons = new Weapons();
        Armors armors = new Armors();

        Player player = (Player) event.getWhoClicked();
        ItemStack itemUpgrade = event.getCurrentItem();

        if(itemUpgrade == null) return;





    }
}
