package net.justkilli.killisessentials.player.database;

import net.justkilli.killisessentials.database.DBHandler;

import java.sql.ResultSet;
import java.util.Optional;
import java.util.UUID;

public class DBHandlerPlayer extends DBHandler {

    private DBAccessLayerPlayer sql;

    public DBHandlerPlayer(DBAccessLayerPlayer sql) {
        super(sql);
        this.sql = sql;
    }

    /**
     * Checks if a player with the given UUID exists in the database.
     *
     * @param uuid the UUID of the player to check
     * @return true if the player exists, false otherwise
     */
    public boolean playerExists(UUID uuid) {
        ResultSet rs = sql.getPlayer(uuid);
        Optional<ResultSet> rsOpt = resultSetIsEmpty(rs, true);
        return rsOpt.isPresent();
    }

}
