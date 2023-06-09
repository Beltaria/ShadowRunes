package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ShadowRunes;
import me.bluedyaishela.shadowrunes.utils.Players;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Speed implements Listener {
    private final ShadowRunes main;
    private final Players players = new Players();
    public Speed(ShadowRunes plugin)
    {
        this.main = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        ItemStack leggings = player.getInventory().getLeggings();

        player.sendMessage(String.valueOf(player.getWalkSpeed()));
        player.sendMessage(String.valueOf(players.getDefaultWalkSpeed()));

        if (leggings == null || !leggings.getItemMeta().hasLore())
        {
            player.sendMessage("§cVitesse par défaut");
            player.setWalkSpeed(players.getDefaultWalkSpeed());
            return;
        }

        Integer bonusSpeed = 10;
        float percentageSpeed = 0.2F + (0.2F * bonusSpeed / 100);


        if (leggings.hasItemMeta() && leggings.getItemMeta().getLore().contains("Vitesse"))
        {
            player.sendMessage("§aVitesse augmentée");
            player.setWalkSpeed(percentageSpeed);
        }
    }
}
