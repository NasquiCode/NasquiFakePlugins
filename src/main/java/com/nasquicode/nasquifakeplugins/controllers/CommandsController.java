package com.nasquicode.nasquifakeplugins.controllers;

import com.nasquicode.nasquifakeplugins.NasquiFakePlugins;
import net.md_5.bungee.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CommandsController {
    public static List<String> command_list = new ArrayList<String>();
    public static void register() {
        command_list.clear();
        Configuration config = NasquiFakePlugins.config;
        for(String command : config.getStringList("commands")) {
            command_list.add(command.toLowerCase());
        }
        NasquiFakePlugins.plugin.getLogger().info(NasquiFakePlugins.prefix+ String.format("Foram registrados %s comandos.", String.valueOf(command_list.size())));
    }
}
