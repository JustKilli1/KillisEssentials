package net.justkilli.killisessentials.config;

import net.justkilli.killisessentials.config.handler.IConfigHandler;

import java.util.HashMap;
import java.util.Map;

public abstract class ConfigManager {

    private static final Map<String, IConfigHandler> CONFIG_HANDLERS = new HashMap<>();

    public static void registerConfigHandler(String name, IConfigHandler configHandler) {
        CONFIG_HANDLERS.put(name, configHandler);
    }

    public static void unregisterConfigHandler(String name) {
        CONFIG_HANDLERS.remove(name);
    }

    public static IConfigHandler getConfigHandler(String name) {
        return CONFIG_HANDLERS.get(name);
    }

    public static void reloadConfigHandler(String name) {
        IConfigHandler configHandler = getConfigHandler(name);
        if(configHandler != null) configHandler.reload();
    }

    public static void reloadAllConfigHandlers() {
        CONFIG_HANDLERS.values().forEach(IConfigHandler::reload);
    }

    public static void saveConfigHandler(String name) {
        IConfigHandler configHandler = getConfigHandler(name);
        if(configHandler != null) configHandler.save();
    }

    public static void saveAllConfigHandlers() {
        CONFIG_HANDLERS.values().forEach(IConfigHandler::save);
    }
}
