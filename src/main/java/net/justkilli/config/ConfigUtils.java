package net.justkilli.config;

import net.justkilli.config.values.ConfigValue;

public class ConfigUtils {

    public static <T> ConfigValue<T> createConfigValue(ConfigValue<T> configValue, T value) {
        return new ConfigValue<>(configValue.path(), value);
    }

}
