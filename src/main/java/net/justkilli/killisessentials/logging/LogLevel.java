package net.justkilli.killisessentials.logging;

/**
 * The {@code LogLevel} enum represents different levels of logging.
 * Each level has a unique name associated with it.
 */

public enum LogLevel {

    INFO("Info"),
    WARN("Warn"),
    ERROR("Error"),
    DEBUG("Debug")
    ;

    private String name;

    LogLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
