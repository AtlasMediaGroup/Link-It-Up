package com.superiornetworks.linkitup;

public class Util
  {

    private final LinkItUp plugin;

    public Util(LinkItUp plugin)
    {
        this.plugin = plugin;
    }

    public boolean isPluginEnabled(String plugin)
    {
        return this.plugin.pm.isPluginEnabled(plugin);
    }
  }
