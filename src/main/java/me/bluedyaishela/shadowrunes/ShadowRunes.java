package me.bluedyaishela.shadowrunes;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ShadowRunes extends JavaPlugin {

    public FileConfiguration config;
    public File cfile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Création du fichier de configuration
        this.cfile = new File(getDataFolder(), "config.yml");
        if (!this.cfile.exists())
        {
            this.getLogger().info("Le fichier config.yml n'a pas été trouvé, création en cours...");
            this.saveDefaultConfig();
        } else {
            this.getLogger().info("Le fichier de configuration a été trouvé, chargement en cours...");
        }
        this.config = this.getConfig();

        // Récupère l'ensemble des commandes
        this.useCommands();

//        ItemManager.init();
//        this.getServer().getPluginManager().registerEvents(new Damage(this), this);

        // Message de lancement
        System.out.println("ShadowRunes a démarré avec succès.");
    }

    public void useCommands()
    {
        getCommand("shadowrunes").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("ShadowRunes s'est arrêté avec succès.");
    }
}
