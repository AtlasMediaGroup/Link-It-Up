package com.superiornetworks.linkitup;

import com.superiornetworks.linkitup.commands.Command_linkitup;
import net.pravian.aero.command.handler.AeroCommandHandler;
import net.pravian.aero.command.handler.SimpleCommandHandler;
import net.pravian.aero.util.Loggers;
import net.pravian.aero.config.YamlConfig;
import net.pravian.aero.plugin.AeroPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class LinkItUp extends AeroPlugin<LinkItUp>
  {

    public static LinkItUp plugin;
    //
    public YamlConfig pluginconfig;
    public YamlConfig messageConfig;
    //
    public static AeroCommandHandler handler;
    //
    public PluginManager pm;
    public Util util;
    public Messages messages;

    @Override
    public void load()
    {
        LinkItUp.plugin = this;
        //this.config = new YamlConfig(plugin, "config.yml");
        this.messageConfig = new YamlConfig(plugin, "messages.yml");
        this.pm = Bukkit.getPluginManager();

        //config.load();
        messageConfig.load();

        this.messages = new Messages(plugin);
        this.util = new Util(plugin);
    }

    @Override
    public void enable()
    {
        LinkItUp.plugin = this;
        //
        handler = new SimpleCommandHandler(plugin);
        handler.setCommandClassPrefix("Command_");
        handler.loadFrom(Command_linkitup.class.getPackage());
        handler.registerAll();

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
        Loggers.info(plugin, "Link It Up is enabled.");
    }

    @Override
    public void disable()
    {
        LinkItUp.plugin = null;
        Loggers.info(plugin, "Link It Up is disabled.");
    }
  }
