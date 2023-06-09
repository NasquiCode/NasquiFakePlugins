package com.nasquicode.nasquifakeplugins;

import com.nasquicode.nasquifakeplugins.controllers.CommandsController;
import com.nasquicode.nasquifakeplugins.controllers.ServersController;
import com.nasquicode.nasquifakeplugins.listeners.PlayerListeners;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public final class NasquiFakePlugins extends Plugin {

    public static NasquiFakePlugins plugin;
    public static String prefix = "§b[NasquiFakePlugins] §f";
    public static Configuration config;

    @Override
    public void onEnable() {
        plugin = this;
        try {
            makeConfig();
            loadConfig();
        } catch (IOException e) {
            getLogger().info(prefix+"§cOcorreu um erro ao carregar a configuração (config.yml)!");
            throw new RuntimeException(e);
        }
        getProxy().getPluginManager().registerListener(plugin, new PlayerListeners());
        getProxy().getPluginManager().registerCommand(plugin, new com.nasquicode.nasquifakeplugins.commands.NasquiFakePlugins("nasquifakeplugins"));
        getLogger().info(prefix+"Plugin iniciado com sucesso!");
    }

    @Override
    public void onDisable() {
        getLogger().info(prefix+"Plugin desabilitado com sucesso!");
    }

    public void makeConfig() throws IOException {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder(), "config.yml");


        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void loadConfig() throws IOException {
        config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        ServersController.register();
        CommandsController.register();
    }
}
