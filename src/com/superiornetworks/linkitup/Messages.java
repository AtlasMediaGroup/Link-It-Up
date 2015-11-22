package com.superiornetworks.linkitup;

import java.util.HashMap;
import java.util.Map;
import net.pravian.aero.util.Loggers;

public class Messages
  {

    private final Map<String, Object> messages;
    private final Map<String, String> strMessages = new HashMap<>();

    public Messages(LinkItUp plugin)
    {
        this.messages = plugin.messageConfig.getConfigurationSection("messages").getValues(false);

        for (Map.Entry<String, Object> message : this.messages.entrySet())
        {
            this.strMessages.put(message.getKey(), message.getValue().toString());
        }

        Loggers.info(plugin, "Messages initalized. " + messages.values().size() + " messages loaded.\n" + strMessages.values().size() + " String messages loaded.");
    }

    public String getMessage(String message)
    {
        return (String) messages.get(message);
    }

    public Map<String, String> getMessages()
    {
        return this.strMessages;
    }
  }
