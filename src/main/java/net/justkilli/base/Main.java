package net.justkilli.base;

import net.justkilli.config.ConfigHandler;
import net.justkilli.config.IConfigHandler;
import net.justkilli.logging.ILogger;
import net.justkilli.logging.LogLevel;
import net.justkilli.logging.loggers.LoggerBuilder;
import net.justkilli.logging.output.ConsolePrinter;
import net.justkilli.logging.output.DialogPrinter;
import net.justkilli.logging.output.FilePrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        //Logger Test
/*        ILogger logger = new LoggerBuilder("Main")
                .addOutputPrinter(new ConsolePrinter())
                .addOutputPrinter(new FilePrinter())
                .addOutputPrinter(new DialogPrinter())
                .build();
        logger.log(LogLevel.INFO, "Hello world!");
        logger.log(LogLevel.WARN, "Hello world!");
        logger.log(LogLevel.ERROR, "Hello world!");
        logger.log(LogLevel.DEBUG, "Hello world!");*/

        IConfigHandler configHandler = new ConfigHandler("config.yml");

    }
}