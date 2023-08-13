package net.justkilli.killisessentials.config;

import net.justkilli.killisessentials.config.values.ConfigParameter;
import net.justkilli.killisessentials.config.values.ConfigValue;

/**
 * Utility class for creating and manipulating ConfigValues.
 */
public class ConfigUtils {

    /**
     * Creates a new {@link ConfigValue} object with the given config value, value, and configuration parameters.
     *
     * @param configValue  the original config value object
     * @param value        the value for the new config value object
     * @param parameters   optional configuration parameters
     * @param <T>          the type of the config value
     * @return the new config value object
     */
    public static <T> ConfigValue<T> createConfigValue(ConfigValue<T> configValue, T value, ConfigParameter... parameters) {
        return new ConfigValue<>(configValue.path(), value, parameters);
    }

    /**
     * Creates a new {@link ConfigValue} object with the given config value and configuration parameters.
     *
     * @param configValue  the original config value object
     * @param parameters   optional configuration parameters
     * @param <T>          the type of the config value
     * @return the new config value object
     */
    public static <T> ConfigValue<T> createConfigValue(ConfigValue<T> configValue, ConfigParameter... parameters) {
        return new ConfigValue<>(configValue.path(), configValue.value(), parameters);
    }
}
