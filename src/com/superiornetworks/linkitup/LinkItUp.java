package com.superiornetworks.linkitup;

import com.superiornetworks.linkitup.commands.Command_linkitup;
import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.command.BukkitCommandHandler;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import net.pravian.bukkitlib.util.LoggerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;

public class LinkItUp extends BukkitPlugin
{
    
    public LinkItUp plugin;
    public YamlConfig config;
    public YamlConfig messageConfig;
    public BukkitCommandHandler handler;
    public PluginManager pm;
    public Util util;
    public Messages messages;
    
    @Override
    public void onLoad()
    {
        this.plugin = this;
        this.handler = new BukkitCommandHandler(plugin);        
        //this.config = new YamlConfig(plugin, "config.yml");
        this.messageConfig = new YamlConfig(plugin, "messages.yml");
        this.pm = Bukkit.getPluginManager();
        
        //config.load();
        messageConfig.load();        
        
        this.messages = new Messages(plugin);        
        this.util = new Util(plugin);
    }
    
    @Override
    public void onEnable()
    {
        BukkitLib.init(plugin);
        
        handler.setCommandLocation(Command_linkitup.class.getPackage());        
        
        MessageListener messageListener = new MessageListener(plugin);
        register(messageListener);
        
        // This will be implmented at a later date possibly...
       /* String[] plugins = new String[]{"BarAPI", "HolographicDisplays"};
        
        for (String p : plugins)
        {
            if (util.isPluginEnabled(p) == false)
            {
                LoggerUtils.warning(plugin, p + " is disabled. Some Link It Up functionality will be disabled.");
            }
        } */
        
        LoggerUtils.info(plugin, "Link It Up is enabled.");
    }
    
    @Override
    public void onDisable()
    {
        LoggerUtils.info(plugin, "Link It Up is disabled.");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }
}
