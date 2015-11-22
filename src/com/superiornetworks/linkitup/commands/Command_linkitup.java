package com.superiornetworks.linkitup.commands;

import com.superiornetworks.linkitup.LinkItUp;
import net.pravian.aero.command.SimpleCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_linkitup extends SimpleCommand<LinkItUp>
  {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
    {
        sender.sendMessage("This is the Link It Up Plugin. Please run /linkhelp for help documentation.");
        return true;
    }
  }
