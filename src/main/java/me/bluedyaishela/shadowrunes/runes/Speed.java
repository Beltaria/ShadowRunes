package me.bluedyaishela.shadowrunes.runes;

import me.bluedyaishela.shadowrunes.ShadowRunes;
import me.bluedyaishela.shadowrunes.utils.Armors;
import me.bluedyaishela.shadowrunes.utils.Players;
import me.bluedyaishela.shadowrunes.utils.UtilsValue;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Speed implements Listener {
    private final ShadowRunes main;
    private final Players players = new Players();
    private final UtilsValue utilsValue = new UtilsValue();
    public Speed(ShadowRunes plugin)
    {
        this.main = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        float helmetSpeed = getSpeedFromArmor(helmet);
        float chestplateSpeed = getSpeedFromArmor(chestplate);
        float leggingsSpeed = getSpeedFromArmor(leggings);
        float bootsSpeed = getSpeedFromArmor(boots);

        float newSpeed = helmetSpeed + chestplateSpeed + leggingsSpeed + bootsSpeed;
        if (newSpeed == 0F)
        {
            player.setWalkSpeed(0.2F);
//            player.sendMessage("Vitesse actuelle : " + 0.2F);
            return;
        }

//        player.sendMessage("Vitesse actuelle : " + utilsValue.getFloatFromPercentage(players.getDefaultWalkSpeed(), newSpeed));
        player.setWalkSpeed(utilsValue.getFloatFromPercentage(players.getDefaultWalkSpeed(), newSpeed));
    }

    private float getSpeedFromArmor(ItemStack pieceArmure)
    {
        if (pieceArmure == null)
        {
            return 0F;
        }

        Armors armors = new Armors();
        if (!armors.getArmors().contains(pieceArmure.getType()))
        {
            return 0F;
        }

        ItemMeta itemMeta = pieceArmure.getItemMeta();

        if (itemMeta != null && itemMeta.hasLore())
        {
            List<String> lore = itemMeta.getLore();

            for (String line : lore) {
                if (line.contains("Speed")) {

                    float runeSpeed = utilsValue.getFloatOfLoreRune(line);
                    return runeSpeed;
                }
            }
        }
        return 0F;
    }
}
