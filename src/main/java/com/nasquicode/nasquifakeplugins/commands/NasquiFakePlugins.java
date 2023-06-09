package com.nasquicode.nasquifakeplugins.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.io.IOException;

public class NasquiFakePlugins extends Command {
    public NasquiFakePlugins(String command) {
        super(command);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length <= 0) {
            sender.sendMessage("§fEste servidor utiliza §bNasquiFakePlugins§f! Descubra mais plugins em §enasquicode.com§f.");
            return;
        }
        if(args[0].equalsIgnoreCase("reload")) {
            try {
                com.nasquicode.nasquifakeplugins.NasquiFakePlugins.plugin.loadConfig();
                sender.sendMessage(com.nasquicode.nasquifakeplugins.NasquiFakePlugins.prefix +"Configuração recarregada com sucesso!");
            } catch (IOException e) {
                sender.sendMessage(com.nasquicode.nasquifakeplugins.NasquiFakePlugins.prefix +"§cOcorreu um erro ao carregar a configuração (config.yml)!");
                throw new RuntimeException(e);
            }
            return;
        }
    }
}
