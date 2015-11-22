package com.superiornetworks.linkitup;

import java.util.Map;
import net.pravian.aero.util.Loggers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MessageListener implements Listener
  {

    LinkItUp plugin;

    MessageListener(LinkItUp plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPreprocessCommand(PlayerCommandPreprocessEvent event)
    {
        for (Map.Entry<String, String> message : plugin.messages.getMessages().entrySet())
        {
            if (message.getKey().equalsIgnoreCase(event.getMessage().substring(1)))
            {
                Loggers.info(message.getValue());
                event.getPlayer().sendMessage(message.getValue());
                event.setCancelled(true);
            }
        }
    }
  }
