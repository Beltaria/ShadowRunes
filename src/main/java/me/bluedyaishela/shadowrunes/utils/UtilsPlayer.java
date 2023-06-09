package me.bluedyaishela.shadowrunes.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UtilsPlayer {

    private static final float DEFAULT_SPEED = 0.2F;
    public float getDefaultWalkSpeed()
    {
        return DEFAULT_SPEED;
    }

    public boolean isPlayerOnline(String pseudo) {
        Player player = Bukkit.getPlayer(pseudo);
        return player != null && player.isOnline();
    }
}
