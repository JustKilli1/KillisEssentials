package net.justkilli.killisessentials.config;

import net.justkilli.killisessentials.config.handler.IConfigHandler;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private final Map<String, IConfigHandler> CONFIG_HANDLERS = new HashMap<>();

    public void registerConfigHandler(String name, IConfigHandler configHandler) {
        CONFIG_HANDLERS.put(name, configHandler);
    }

    public void unregisterConfigHandler(String name) {
        CONFIG_HANDLERS.remove(name);
    }

    public IConfigHandler getConfigHandler(String name) {
        return CONFIG_HANDLERS.get(name);
    }

    public void reloadConfigHandler(String name) {
        IConfigHandler configHandler = getConfigHandler(name);
        if(configHandler != null) configHandler.reload();
    }

    public void reloadAllConfigHandlers() {
        CONFIG_HANDLERS.values().forEach(IConfigHandler::reload);
    }

    public void saveConfigHandler(String name) {
        IConfigHandler configHandler = getConfigHandler(name);
        if(configHandler != null) configHandler.save();
    }

    public void saveAllConfigHandlers() {
        CONFIG_HANDLERS.values().forEach(IConfigHandler::save);
    }
}
