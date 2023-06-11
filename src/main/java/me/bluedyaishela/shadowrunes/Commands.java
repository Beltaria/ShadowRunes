package me.bluedyaishela.shadowrunes;

import me.bluedyaishela.shadowrunes.commands.CommandFunctionManager;
import org.bukkit.Bukkit;
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
        CommandFunctionManager cmdFunctionManager = new CommandFunctionManager();

        if(!(sender instanceof Player))
        {
            return false;
        }

        if (args.length == 0)
        {
            sender.sendMessage("Vous utilisez actuellement ShadowRunes Beta");
            return false;
        }

        switch (args[0])
        {
            case "reload":
                return cmdFunctionManager.reloadCommand(sender);
            case "give":
                return cmdFunctionManager.giveCommand(sender, args);
            case "help":
                return cmdFunctionManager.helpCommand(sender, args);
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> availableCommands = new ArrayList<>();

        if(args.length == 1)
        {
            availableCommands.addAll(Arrays.asList("help", "reload", "give"));
            return this.getArgsComplete(args, availableCommands, 0);
        }

        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        List<String> playerNames = new ArrayList<>();

        for (Player player : players) {
            playerNames.add(player.getName());
        }

        switch (args[0])
        {
            case "help":
                availableCommands.addAll(Arrays.asList("1", "2", "3"));
                return this.getArgsComplete(args, availableCommands, 1);
            case "give":
                if (args.length == 2)
                {
                    availableCommands.addAll(playerNames);
                    return this.getArgsComplete(args, availableCommands, 1);
                } else if (args.length == 3) {
                    availableCommands.addAll(Arrays.asList("damagesword", "damagesword"));
                    return this.getArgsComplete(args, availableCommands, 2);
                }
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
