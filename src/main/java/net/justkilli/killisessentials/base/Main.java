package net.justkilli.killisessentials.base;

import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.config.handler.YAMLConfigHandler;
import net.justkilli.killisessentials.logging.ILogger;
import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.loggers.LoggerBuilder;
import net.justkilli.killisessentials.logging.output.ConsolePrinter;
import net.justkilli.killisessentials.player.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    private static final ILogger MAIN_LOGGER = new LoggerBuilder("Killi's-Essentials")
            .addOutputPrinter(new ConsolePrinter())
            .build();
    private final IConfigHandler mysqlConfigHandler = new YAMLConfigHandler("mysql.yml");

    @Override
    public void onEnable() {
        MAIN_LOGGER.log(LogLevel.INFO, "Killi's Essentials Library startup...");
        registerListener();
        MAIN_LOGGER.log(LogLevel.INFO, "Killi's Essentials Library started");
    }


    public void registerListener() {
        MAIN_LOGGER.log(LogLevel.INFO, "Registering Listeners...");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(mysqlConfigHandler), this);
        MAIN_LOGGER.log(LogLevel.INFO, "Listeners Registered");
    }

    @Override
    public void onDisable() {

^
    }
}