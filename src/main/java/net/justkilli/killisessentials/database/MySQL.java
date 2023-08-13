package net.justkilli.killisessentials.database;


import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.config.values.ConfigValue;
import net.justkilli.killisessentials.logging.ILogger;
import net.justkilli.killisessentials.logging.LogLevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles Database Connection
 * */
public class MySQL {

    private final ILogger logger;
    private IConfigHandler configManager;
    private String host, port, database, username, password;
    private Connection con;

    public MySQL(ILogger logger, IConfigHandler configManager) {
        this.logger = logger;
        this.configManager = configManager;
        createDefaultConfig();
    }

    /**
     * Creates Default Config File
     * */
    private void createDefaultConfig() {
        try {
            configManager.addDefaultValue(ConfigValue.SQL_HOST);
            configManager.addDefaultValue(ConfigValue.SQL_PORT);
            configManager.addDefaultValue(ConfigValue.SQL_USERNAME);
            configManager.addDefaultValue(ConfigValue.SQL_PASSWORD);
            configManager.addDefaultValue(ConfigValue.SQL_DATABASE);
        } catch (Exception ex) {
            logger.log(LogLevel.ERROR, "Could not create default mysql config", ex);
        }
    }

    /**
     * Reloads the Config File
     * */
    private void reloadDBSettings() {
        try {
            configManager.load();
            host = configManager.getString(ConfigValue.SQL_HOST).toString();
            port = configManager.getString(ConfigValue.SQL_PORT).toString();
            database = configManager.getString(ConfigValue.SQL_DATABASE).toString();
            username = configManager.getString(ConfigValue.SQL_USERNAME).toString();
            password = configManager.getString(ConfigValue.SQL_PASSWORD).toString();
        } catch(Exception ex) {
            logger.log(LogLevel.ERROR, "Could not reload mysql config", ex);
        }
    }

    /**
     * Connects to Database
     * */
    public void connect() {
        if(isConnected()) return;
        reloadDBSettings();
        String conStr = "jdbc:mysql://"
                + host + ":"
                + port + "/"
                + database
                + "?autoReconnect=true&useSSL=false";
        try {
            con = DriverManager.getConnection(conStr, username, password);
        } catch (SQLException ex) {
            logger.log(LogLevel.ERROR, "Could not connect to Database. Connection Str: " + conStr, ex);
        }
    }

    /**
     * Disconnects from Database
     * */
    public void disconnect() {
        if(!isConnected()) return;
        try {
            con.close();
        } catch (SQLException ex) {
            logger.log(LogLevel.ERROR, "Could not disconnect from Database", ex);
        }
    }

    public boolean isConnected() {
        return (con != null);
    }

    public Connection getConnection() {
        return con;
    }

}
