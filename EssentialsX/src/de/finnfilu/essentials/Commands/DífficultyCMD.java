package de.finnfilu.essentials.Commands;

// Plugin programmiert von FinnFilu
// Weiterverwenden verboten!


import de.finnfilu.essentials.Main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DífficultyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("difficulty")) {
            if(p.hasPermission("Essentials.difficulty")) {
                if(sender instanceof Player) {
                    if(args.length == 1) {

                        if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("peaceful")) {

                            Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
                            p.sendMessage(Data.pre + "§7Setze Schwierigkeit auf §eFriedlich§7.");

                        } else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("easy")) {

                            Bukkit.getWorld("world").setDifficulty(Difficulty.EASY);
                            p.sendMessage(Data.pre + "§7Setze Schwierigkeit auf §eEinfach§7.");

                        } else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("normal")) {

                            Bukkit.getWorld("world").setDifficulty(Difficulty.NORMAL);
                            p.sendMessage(Data.pre + "§7Setze Schwierigkeit auf §eNormal§7.");

                        } else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("hard")) {

                            Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
                            p.sendMessage(Data.pre + "§7Setze Schwierigkeit auf §eHart§7.");

                        }

                    } else
                        p.sendMessage(Data.pre + "§cBitte benutze: §e/difficulty <Schwierigkeit>");
                } else
                    Bukkit.getConsoleSender().sendMessage(Data.pre + Data.notpl);
            } else
                p.sendMessage(Data.pre + Data.noperms);
        }

        return false;
    }
}