package net.justkilli.config;

import net.justkilli.config.values.ConfigValue;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public interface IConfigHandler {

    YamlFile init(String path) throws IOException;
    YamlFile create() throws IOException;
    YamlFile load() throws IOException;
    void save() throws IOException;
    YamlFile getConfig();

    <T> void addDefaultValue(ConfigValue<T> value) throws IOException;
    <T> void setValue(ConfigValue<T> value) throws IOException;
    ConfigValue<String> getString(ConfigValue<String> value);
    ConfigValue<Boolean> getBoolean(ConfigValue<Boolean> value);
    ConfigValue<Integer> getInteger(ConfigValue<Integer> value);
    ConfigValue<Double> getDouble(ConfigValue<Double> value);
}
