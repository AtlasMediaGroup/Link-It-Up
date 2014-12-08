package com.superiornetworks.linkitup.commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_linkitup extends BukkitCommand
{

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args)
    {
        sender.sendMessage("This is the Link It Up Plugin. Please run /linkhelp for help documentation.");
        return true;
    }    
}
