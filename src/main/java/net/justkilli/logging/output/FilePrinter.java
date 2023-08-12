package net.justkilli.logging.output;

import net.justkilli.logging.ILogger;
import net.justkilli.logging.LogLevel;
import net.justkilli.logging.LoggingUtils;
import net.justkilli.logging.files.FileHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * FilePrinter is an implementation of the {@link IOutputPrinter} interface that writes log messages to a file.
 * It manages the log file using a {@link FileHandler} and provides methods to print log messages at different {@link LogLevel}.
 */
public class FilePrinter implements IOutputPrinter {
    /**
     * Directory where the log file is stored.
     * */
    public static final String LOG_DIRECTORY = "logs";
    /**
     * Prefix for the log file name.
     * */
    public static final String LOG_FILE_PREFIX = "log";
    /**
     * FileHandler that manages the LogFile
     * */
    private final FileHandler fileHandler;

    public FilePrinter() {
        String filePath = String.format("%s/%s_%s.txt", LOG_DIRECTORY, LOG_FILE_PREFIX, getCurrentDateFormatted());
        fileHandler = new FileHandler(filePath);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void print(LogLevel level, List<String> message) {
        try {
            fileHandler.write(message, fileHandler.fileExists());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void print(LogLevel level, String message) {
        print(level, List.of(message));
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public String format(LogLevel logLevel, String loggerName, List<String> message, Exception ex) {
        String messageMSG = formatMessage(message);
        String exceptionMSG = formatException(ex);
        return String.format("----------------------[%s]----------------------%n" +
                "Level: %s%n" +
                "Logger Name: %s" +
                messageMSG +
                exceptionMSG, getCurrentDateTimeFormatted(), logLevel, loggerName);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public String format(LogLevel logLevel, String loggerName, String message, Exception ex) {
        return format(logLevel, loggerName, List.of(message), ex);
    }

    /**
     * Formats the given list of messages into a formatted string.
     *
     * @param message The list of messages to be formatted.
     * @return The formatted string containing the list of messages.
     */
    private String formatMessage(List<String> message) {
        return (message == null) ? "" : String.format("%nMessage: %s", String.join(" ", message));
    }

    /**
     * Formats the given exception into a formatted string.
     *
     * @param ex The exception to be formatted.
     * @return The formatted string containing the exception.
     */
    private String formatException(Exception ex) {
        return (ex == null) ? "" : String.format("%nException: %s", LoggingUtils.getStackTraceAsStr(ex));
    }

    /**
     * Formats the current date and time into a string with the format "dd-MM-yyyy HH:mm:ss".
     *
     * @return The formatted string representing the current date and time.
     */
    private String getCurrentDateTimeFormatted() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    /**
     * Formats the current date into a string with the format "dd-MM-yyyy".
     *
     * @return The formatted string representing the current date.
     */
    private String getCurrentDateFormatted() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return currentDateTime.format(formatter);
    }

}
