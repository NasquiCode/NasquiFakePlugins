package com.nasquicode.nasquifakeplugins.controllers;

import com.nasquicode.nasquifakeplugins.NasquiFakePlugins;
import net.md_5.bungee.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ServersController {
    public static List<String> server_list = new ArrayList<String>();
    public static void register() {
        server_list.clear();
        Configuration config = NasquiFakePlugins.config;
        server_list.addAll(config.getSection("servers").getKeys());
        NasquiFakePlugins.plugin.getLogger().info(NasquiFakePlugins.prefix+ String.format("Foram registrados %s servidores.", String.valueOf(server_list.size())));
    }
}
