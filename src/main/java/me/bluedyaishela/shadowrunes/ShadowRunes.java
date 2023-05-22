package me.bluedyaishela.shadowrunes;

import me.bluedyaishela.shadowrunes.runes.Damage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ShadowRunes extends JavaPlugin {

    public FileConfiguration config;
    public File cfile;

    @Override
    public void onEnable()
    {

        this.cfile = new File(getDataFolder(), "config.yml");
        if (!this.cfile.exists())
        {
            this.getLogger().info("Le fichier config.yml n'a pas été trouvé, création en cours...");
            this.saveDefaultConfig();
        } else {
            this.getLogger().info("Le fichier de configuration a été trouvé, chargement en cours...");
        }
        this.config = this.getConfig();

        this.useCommands();
        ItemManager.init();


        this.getServer().getPluginManager().registerEvents(new Damage(this), this);

        System.out.println("ShadowRunes a démarré avec succès.");
    }

    public void useCommands()
    {
        this.getCommand("shadowrunes").setExecutor(new Commands(this));
    }

    @Override
    public void onDisable()
    {
        System.out.println("ShadowRunes s'est arrêté avec succès.");
    }
}
