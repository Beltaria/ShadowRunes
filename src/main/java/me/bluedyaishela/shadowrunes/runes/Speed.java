package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ShadowRunes;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed implements Listener {

    private static final float DEFAULT_SPEED = 0.2f;
    private final ShadowRunes main;
    public Speed(ShadowRunes plugin)
    {
        this.main = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        float speed = player.getWalkSpeed();
        ItemStack leggings = player.getInventory().getLeggings();

        if (leggings == null || !leggings.getItemMeta().hasLore())
        {
            player.sendMessage("§cVitesse par défaut");
            player.setWalkSpeed(0.2F);
            return;
        }

        float percentageSpeed = 0.2F + (0.2F * 100 / 100);


        if (leggings.hasItemMeta() && leggings.getItemMeta().getLore().contains("Vitesse"))
        {
            player.sendMessage("§aVitesse augmentée");
            player.setWalkSpeed(percentageSpeed);
        }
    }
}
