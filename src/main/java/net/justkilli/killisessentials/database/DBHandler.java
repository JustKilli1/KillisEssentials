package net.justkilli.killisessentials.database;

import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.ILogger;

import java.sql.ResultSet;
import java.util.Optional;


/**
 * DBHandler class is responsible for handling database operations.
 * It works with ResultSets obtained from SQL queries.
 *
 * @see DBAccessLayer
 */

public class DBHandler {

    protected static final ILogger logger = DBAccessLayer.logger;
    /**
     * Gets ResultSets from sql request
     * --> Gets Information needed from ResultSet and returns it
     * Works with sql return data(ResultSets)
     * */
    protected DBAccessLayer sql;

    public DBHandler(DBAccessLayer sql) {
        this.sql = sql;
    }

    /**
     * Closes the provided ResultSet
     *
     * @param result ResultSet to be closed
     */
    private void closeResultSet(ResultSet result) {
        try {
            result.close();
        } catch (Exception ex) {
            logger.log(LogLevel.ERROR, "Could not close ResultSet", ex);
        }
    }

    /**
     * Checks if the given ResultSet is empty.
     *
     * @param result the ResultSet to check
     * @param close if true, the ResultSet will be closed after checking
     * @return an Optional containing the non-empty ResultSet if it exists, otherwise an empty Optional
     */
    public Optional<ResultSet> resultSetIsEmpty(ResultSet result, boolean close) {
        if(result == null) return Optional.empty();
        try {
            if(!result.next()) return Optional.empty();
            return Optional.of(result);
        } catch(Exception ex) {
            logger.log(LogLevel.ERROR, "Could not check if ResultSet is empty", ex);
            return Optional.empty();
        } finally {
            if(close) closeResultSet(result);
        }
    }

    /**
     * Checks if the given ResultSet is empty.
     *
     * @param result the ResultSet to check for emptiness
     * @return an Optional containing the ResultSet if it is not empty, otherwise an empty Optional
     */
    public Optional<ResultSet> resultSetIsEmpty(ResultSet result) {
        return resultSetIsEmpty(result, false);
    }
}
