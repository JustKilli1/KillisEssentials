package net.justkilli.killisessentials.player.database;

import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.database.DBAccessLayer;

import java.sql.ResultSet;
import java.util.UUID;

public class DBAccessLayerPlayer extends DBAccessLayer {

    public DBAccessLayerPlayer(IConfigHandler mysqlConfigHandler) {
        super(mysqlConfigHandler);
    }

    /**
     * Adds a player to the database.
     *
     * @param name the name of the player
     * @param uuid the unique identifier of the player
     * @return true if the player was successfully added, false otherwise
     */
    public boolean addPlayer(String name, UUID uuid) {
        String sqlQuery = String.format("INSERT INTO Player (Name, UUID) VALUES ('%s', '%s');", name, uuid.toString());
        return executeSQLRequest(sqlQuery);
    }

    /**
     * Retrieves a player from the database based on their UUID.
     *
     * @param uuid the unique identifier of the player
     * @return a ResultSet object containing the player's information, or null if the player does not exist
     */
    public ResultSet getPlayer(UUID uuid) {
        String sqlQuery = String.format("SELECT * FROM Player WHERE UUID = '%s';", uuid.toString());
        return querySQLRequest(sqlQuery);
    }

}
