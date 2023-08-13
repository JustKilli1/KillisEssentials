package net.justkilli.killisessentials.database;


import net.justkilli.killisessentials.config.handler.IConfigHandler;
import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.ILogger;
import net.justkilli.killisessentials.logging.loggers.LoggerBuilder;
import net.justkilli.killisessentials.logging.output.ConsolePrinter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Normal Sql Queries no Data processing
 * */
public class DBAccessLayer {

    protected static final ILogger logger = new LoggerBuilder("Database").addOutputPrinter(new ConsolePrinter()).build();

    private MySQL mySql;

    public DBAccessLayer(IConfigHandler mysqlConfigHandler) {
        mySql = new MySQL(logger, mysqlConfigHandler);
        mySql.connect();
    }

    /**
     * Creates a new database using the given Database object.
     *
     * @param database the Database object containing the database creation query
     * @return true if the database was created successfully, false otherwise
     */
    public boolean createDatabase(DatabaseTable database) {
        String sqlQuery = database.getDatabaseCreationQuery();
        return executeSQLRequest(sqlQuery);
    }

    public void disable() {
        mySql.disconnect();
    }

    /**
     * Reconnects to database if not connected
     */
    private void checkAndReconnectConnection() {
        if (!mySql.isConnected()) {
            mySql.connect();
        }
    }

    protected boolean executeSQLRequest(String sqlQuery) {
        checkAndReconnectConnection();
        if (mySql.isConnected()) {
            Connection connection = mySql.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                logger.log(LogLevel.ERROR, "Execute SQL request failed. " + sqlQuery, ex);
                return false;
            }
        } else {
            return false;
        }
    }
    protected ResultSet querySQLRequest(String sqlQuery) {
        checkAndReconnectConnection();
        if (mySql.isConnected()) {
            Connection connection = mySql.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                return ps.executeQuery();
            } catch (SQLException ex) {
                logger.log(LogLevel.ERROR, "Query SQL request failed. " + sqlQuery, ex);
                return null;
            }
        } else {
            return null;
        }
    }
}
