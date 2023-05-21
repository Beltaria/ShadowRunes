package me.bluedyaishela.shadowrunes;

import com.sun.org.apache.bcel.internal.generic.DMUL;
import me.bluedyaishela.shadowrunes.runes.Damage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ShadowRunes extends JavaPlugin {

    public FileConfiguration config;
    public File cfile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.cfile = new File(getDataFolder(), "config.yml");
        if (!this.cfile.exists())
        {
            this.getLogger().info("Le fichier config.yml n'a pas été trouvé, création en cours...");
            this.saveDefaultConfig();
        } else {
            this.getLogger().info("Le fichier de configuration a été trouvé, chargement en cours...");
        }
        this.config = this.getConfig();

//        this.getServer().getPluginManager().registerEvents(new Damage(this), this);

        System.out.println("FoodEffect a démarré avec succès.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("FoodEffect s'est arrêté avec succès.");
    }
}
