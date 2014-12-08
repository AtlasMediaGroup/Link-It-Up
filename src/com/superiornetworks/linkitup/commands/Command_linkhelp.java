package com.superiornetworks.linkitup.commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class Command_linkhelp extends BukkitCommand
{

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args)
    {
        sender.sendMessage(ChatColor.BLUE + "Welcome to the Link It Up help documentation.");
        sender.sendMessage(ChatColor.RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        sender.sendMessage(ChatColor.RED + "");
        sender.sendMessage(ChatColor.DARK_PURPLE + "Please contact server staff for full details on the avlible commands");
        sender.sendMessage(ChatColor.DARK_PURPLE + "You can see our project for general help here: https://github.com/Superior-Development/Link-It-Up");
        return true;
    }    
}
