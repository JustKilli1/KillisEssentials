package net.justkilli.killisessentials.config.handler;

import net.justkilli.killisessentials.config.ConfigUtils;
import net.justkilli.killisessentials.config.values.ConfigParameter;
import net.justkilli.killisessentials.config.values.ConfigValue;
import net.justkilli.killisessentials.logging.ILogger;
import net.justkilli.killisessentials.logging.LogLevel;
import net.justkilli.killisessentials.logging.loggers.LoggerBuilder;
import net.justkilli.killisessentials.logging.output.ConsolePrinter;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YAMLConfigHandler implements IConfigHandler {

    private static final ILogger CONFIG_LOGGER = new LoggerBuilder("Killi's-Essentials-Configs")
            .addOutputPrinter(new ConsolePrinter())
            .build();
    private YamlFile config;

    public YAMLConfigHandler(String path) {
        config = init(path);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile init(String path) {
        config = new YamlFile(path);
        config.options().copyDefaults(true);

        if(config.exists()) return load();
        else return create();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile create() {
        try {
            config.createNewFile();
            return config;
        } catch (IOException ex) {
            CONFIG_LOGGER.log(LogLevel.ERROR, String.format("Config File with path %s could not be created", config.getFilePath()), ex);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile load() {
        try {
            config.load();
            return config;
        } catch(Exception ex) {
            CONFIG_LOGGER.log(LogLevel.ERROR, String.format("Config File with path %s could not be loaded", config.getFilePath()), ex);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void save() {
        try {
            config.save();
        } catch (IOException ex) {
            CONFIG_LOGGER.log(LogLevel.ERROR, String.format("Config File with path %s could not be saved", config.getFilePath()), ex);
        }
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile getConfig() {
        return config;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void addDefaultValue(ConfigValue<T> value) {
        config.addDefault(value.path(), value.value());
        setComments(value);
        save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void setComments(ConfigValue<T> value) {
        if(value.parameters().length == 0) return;
    String comments = Stream.concat(
                                    Stream.of("Parameter Options:"), Arrays.stream(value.parameters())
                                    .map(ConfigParameter::getParameterDescription)
                                    )
                            .collect(Collectors.joining("\n"));
        config.setComment(value.path(), comments);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void setValue(ConfigValue<T> value) {
        config.set(value.path(), value.toString());
        save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<String> getString(ConfigValue<String> value) {
        String configValue = config.getString(value.path());
        return ConfigUtils.createConfigValue(value, configValue, value.parameters());
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Boolean> getBoolean(ConfigValue<Boolean> value) {
        Boolean configValue = config.getBoolean(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Integer> getInteger(ConfigValue<Integer> value) {
        Integer configValue = config.getInt(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Double> getDouble(ConfigValue<Double> value) {
        Double configValue = config.getDouble(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }

    @Override
    public boolean reload() {
        load();
        return false;
    }
}
