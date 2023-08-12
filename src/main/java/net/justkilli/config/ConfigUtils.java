package net.justkilli.config;

import net.justkilli.config.values.ConfigParameter;
import net.justkilli.config.values.ConfigValue;

public class ConfigUtils {

    public static <T> ConfigValue<T> createConfigValue(ConfigValue<T> configValue, T value, ConfigParameter... parameters) {
        return new ConfigValue<>(configValue.path(), value, parameters);
    }

    public static <T> ConfigValue<T> createConfigValue(ConfigValue<T> configValue, ConfigParameter... parameters) {
        return new ConfigValue<>(configValue.path(), configValue.value(), parameters);
    }

}
