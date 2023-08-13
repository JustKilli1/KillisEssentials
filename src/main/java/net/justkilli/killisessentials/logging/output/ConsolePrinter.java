package net.justkilli.killisessentials.logging.output;

import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.LoggingUtils;

import java.util.List;



/**
 * ConsolePrinter is a class that implements the IOutputPrinter interface.
 * It provides methods for printing log messages and formatting log messages with specified log level, logger name, message, and exception.
 */
public class ConsolePrinter implements IOutputPrinter {
    /**
     * {@inheritDoc}
     * */
    @Override
    public void print(LogLevel level, List<String> message) {
        message.forEach(System.out::println);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void print(LogLevel level, String message) {
        System.out.println(message);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public String format(LogLevel logLevel, String loggerName, List<String> message, Exception ex) {
        String msg = message != null && !message.isEmpty() ? String.join(" ", message) : "";
        String stackTrace = ex != null ? String.format("%nStackTrace: %s", LoggingUtils.getStackTraceAsStr(ex)) : "";
        return String.format("[%s][%s] %s%s", logLevel, loggerName, msg, stackTrace);
    }
    /**
     * {@inheritDoc}
     * */
    @Override
    public String format(LogLevel logLevel, String loggerName, String message, Exception ex) {
            return format(logLevel, loggerName, List.of(message), ex);
    }
}
