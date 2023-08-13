package net.justkilli.killisessentials.player.database;

import net.justkilli.killisessentials.database.DBHandler;

public class DBHandlerPlayer extends DBHandler {

    private DBAccessLayerPlayer sql;

    public DBHandlerPlayer(DBAccessLayerPlayer sql) {
        super(sql);
        this.sql = sql;
    }
}
