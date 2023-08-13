package net.justkilli.killisessentials.logging.output;

import net.justkilli.killisessentials.logging.LogLevel;

import java.util.List;

/**
 * This interface represents an output printer for logging messages.
 */

public interface IOutputPrinter {

    /**
     * Writes a LogMessage to the designated Output Target.
     *
     * @param level The {@link LogLevel} of the Log.
     * @param message The Message that gets written to the designated Output Target.
     */
    void print(LogLevel level, List<String> message);
    /**
     * Writes A LogMessage to the designated Output Target
     * @param level The {@link LogLevel} of the Log
     * @param message The Message that gets written to the designated Output Target
     * */
    void print(LogLevel level, String message);

    /**
     * Method for Logger to Format a Log Message
     * @param logLevel LogLevel
     * @param loggerName Name of the calling logger
     * @param message Custom Message
     * @param ex occurring Exception
     * @return Formatted LogMessage
     * @see LogLevel
     * */
    String format(LogLevel logLevel, String loggerName, List<String> message, Exception ex);

    /**
     * Method for Logger to Format a Log Message
     * @param logLevel LogLevel
     * @param loggerName Name of the calling logger
     * @param message Custom Message
     * @param ex occurring Exception
     * @return Formatted LogMessage
     * @see LogLevel
     * */
    String format(LogLevel logLevel, String loggerName, String message, Exception ex);

}
