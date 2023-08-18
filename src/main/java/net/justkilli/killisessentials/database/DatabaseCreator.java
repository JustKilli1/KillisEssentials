package net.justkilli.killisessentials.database;

import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.ILogger;
import net.justkilli.killisessentials.logging.loggers.LoggerBuilder;
import net.justkilli.killisessentials.logging.output.ConsolePrinter;

import java.util.List;

/**
 * The DatabaseCreator class is responsible for creating databases and logging the status of each creation.
 */

public class DatabaseCreator {

    /**
     * Represents the logger used to log creation status.
     * This logger is used to log the status of each database creation.
     */
    private static final ILogger logger = new LoggerBuilder("Killi's-Essentials-Database").addOutputPrinter(new ConsolePrinter()).build();

    /**
     * Represents a database access layer using SQL.
     * This class provides methods to interact with the database using SQL queries.
     */
    private final DBAccessLayer sql;
    /**
     * Represents a list of databases to be created.
     * This list contains the databases that need to be created.
     */
    private final List<DatabaseTable> databases;

    /**
     * Constructs a new DatabaseCreator with the specified logger, SQL access layer, and list of databases.
     *
     * @param logger    the logger used to log creation status
     * @param sql       the SQL access layer used to create databases
     * @param databases the list of databases to be created
     */
    public DatabaseCreator(DBAccessLayer sql, List<DatabaseTable> databases) {
        this.sql = sql;
        this.databases = databases == null ? List.of() : databases;
    }

    /**
     * Creates all databases in the list and logs the status for each creation.
     *
     * @return true if all database creations are successful, false otherwise.
     */
    public boolean create() {
        return databases.stream().allMatch(this::createDatabaseAndLogStatus);
    }

    /**
     * Creates a database and logs the status.
     *
     * @param database the database to create
     * @return true if the database creation is successful, false otherwise
     */
    private boolean createDatabaseAndLogStatus(DatabaseTable database) {
        String databaseName = database.name();

        logger.log(LogLevel.INFO, String.format("Creating database table %s...", databaseName));
        if(!sql.createDatabase(database)) {
            logger.log(LogLevel.ERROR, String.format("Failed to create database table %s", databaseName));
            return false;
        }
        logger.log(LogLevel.INFO, String.format("Created database table %s", databaseName));
        return true;
    }

}
