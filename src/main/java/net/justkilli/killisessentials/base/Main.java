package net.justkilli.killisessentials.base;

import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.config.handler.YAMLConfigHandler;
import net.justkilli.killisessentials.database.DBAccessLayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Main extends JavaPlugin {

        @Override
        public void onEnable() {
            getLogger().info("Killi's Essentials has been enabled!");
            try {
                IConfigHandler configHandler = new YAMLConfigHandler("config.yml");
                DBAccessLayer dbAccessLayer = new DBAccessLayer(configHandler);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDisable() {
            getLogger().info("Killi's Essentials has been disabled!");
        }
}