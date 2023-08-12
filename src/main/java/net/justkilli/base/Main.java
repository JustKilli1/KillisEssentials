package net.justkilli.base;

import net.justkilli.config.ConfigUtils;
import net.justkilli.config.handler.YAMLConfigHandler;
import net.justkilli.config.handler.IConfigHandler;
import net.justkilli.config.values.ConfigParameter;
import net.justkilli.config.values.ConfigValue;

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

        IConfigHandler configHandler = new YAMLConfigHandler("config.yml");
        configHandler.addDefaultValue(ConfigValue.STRING);
        configHandler.addDefaultValue(ConfigValue.INTEGER);
        configHandler.addDefaultValue(ConfigValue.BOOLEAN);
        configHandler.addDefaultValue(ConfigValue.DOUBLE);

        ConfigValue<Boolean> booleanSetConfigValue = new ConfigValue<>(ConfigValue.BOOLEAN.path(), false);
        configHandler.setValue(booleanSetConfigValue);

        String str = configHandler.getString(ConfigValue.STRING).toString();
        Boolean bool = configHandler.getBoolean(ConfigValue.BOOLEAN).value();
        System.out.println(str);
        System.out.println(bool);
        String str2 = configHandler.getString(ConfigUtils.createConfigValue(ConfigValue.STRING, ConfigParameter.TEST_PARAMETER.copy("Test String"))).toString();
        System.out.println(str2);

    }
}