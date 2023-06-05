package me.bluedyaishela.shadowrunes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {

    private final ShadowRunes main;
    public Commands(ShadowRunes plugin) {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration config = main.getConfig();

        if(sender instanceof Player)
        {
            Player player = (Player)sender;
            if (args.length == 0)
            {
                player.sendMessage(config.getString("plugin_commands") + "§cVous n'avez pas sélectionné d'arguments lors de l'exécution de la commande, ré-essayez.");
                player.sendMessage(config.getString("plugin_commands") + "§cExemple : /shadowrunes <value>");
            } else {
                String argument = args[0];

                if (argument.equals("damagesword"))
                {
                    player.getInventory().addItem(ItemManager.DamageSword);
                    player.sendMessage(config.getString("plugin_commands") + "§cVous avez obtenu l'arme de dégâts.");
                }
                else if (argument.equals("damagerune"))
                {
                    player.getInventory().addItem(ItemManager.DamageRunes);
                    player.sendMessage(config.getString("plugin_commands") + "§cVous avez obtenu la rune de dégâts.");
                }
                else if (argument.equals("highrune"))
                {
                    player.getInventory().addItem(ItemManager.HighRune);
                    player.sendMessage(config.getString("plugin_commands") + "§cVous avez obtenu la rune de dégâts.");
                }
                else if (argument.equals("reload"))
                {
                    player.sendMessage("§c"+config.getString("plugin_name")+" a été rechargé avec succès !");
                    // Code permettant de recharger le plugin à faire
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> availableCommands = new ArrayList<>();

        if(args.length == 1)
        {
            availableCommands.addAll(Arrays.asList("help", "damagesword", "damagerune", "highrune", "reload"));
            return this.getArgsComplete(args, availableCommands, 0);
        }

//        switch (args.length) {
//            case 1:
//                availableCommands.addAll(Arrays.asList("help", "add", "addall", "leaderboard", "show"));
//                return this.getArgsComplete(args, availableCommands, 0);
//            case 2:
//                availableCommands.addAll(Arrays.asList("value", "player"));
//                return this.getArgsComplete(args, availableCommands, 1);
//        }
        return null;
    }

    public List<String> getArgsComplete(String[] args, List<String> availableCommands, int argsIndex) {
        List<String> completions = new ArrayList<>();
        String input = args[argsIndex].toLowerCase();

        for (String commandOption : availableCommands) {
            if (commandOption.startsWith(input)) {
                completions.add(commandOption);
            }
        }

        return completions;
    }
}
