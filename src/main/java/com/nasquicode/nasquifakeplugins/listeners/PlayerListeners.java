package com.nasquicode.nasquifakeplugins.listeners;

import com.nasquicode.nasquifakeplugins.NasquiFakePlugins;
import com.nasquicode.nasquifakeplugins.controllers.CommandsController;
import com.nasquicode.nasquifakeplugins.controllers.ServersController;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListeners implements Listener {
    @EventHandler
    public void playerPluginCommand(ChatEvent e) {
        ProxiedPlayer player = (ProxiedPlayer) e.getSender();
        NasquiFakePlugins.plugin.getLogger().info(player.getName()+e.getMessage()+player.getServer().getInfo().getName());
        if(!e.isCommand()) return;
        //ProxiedPlayer player = (ProxiedPlayer) e.getSender();
        String server = player.getServer().getInfo().getName();
        if(!ServersController.server_list.contains(server)) return;
        String command = e.getMessage().replace("/","").split(" ")[0];
        NasquiFakePlugins.plugin.getLogger().info(command);
        if(!CommandsController.command_list.contains(command)) return;
        e.setCancelled(true);
        player.sendMessage(NasquiFakePlugins.config.getString(String.format("servers.%s.message", server)).replace("&","§"));
     }
}