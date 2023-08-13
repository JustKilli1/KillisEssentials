package net.justkilli.killisessentials.config.values;

/**
 * Represents a configuration value.
 *
 * @param <T> the type of the value
 */
public record ConfigValue<T>(String path, T value, ConfigParameter... parameters) {

    public static final ConfigValue<String> SQL_HOST = new ConfigValue<>("sql.host", "localhost");
    public static final ConfigValue<String> SQL_PORT = new ConfigValue<>("sql.port", "3306");
    public static final ConfigValue<String> SQL_USERNAME = new ConfigValue<>("sql.username", "USERNAME");
    public static final ConfigValue<String> SQL_PASSWORD = new ConfigValue<>("sql.password", "PASSWORD");
    public static final ConfigValue<String> SQL_DATABASE = new ConfigValue<>("sql.database", "DATABASE");

    @Override
    public String toString() {
        return replaceParameter();
    }

    /**
     * Replaces parameter placeholders in the string {@link #value} with their corresponding values.
     * If the value is not an instance of String, it is converted to a String using String.valueOf().
     * Parameter placeholders are identified by their {@link ConfigParameter#toString()} representation in the string value.
     * The placeholders are replaced with the value of the corresponding ConfigParameter using replace().
     *
     * @return the string value with parameter placeholders replaced
     * @see ConfigParameter
     */
    public String replaceParameter() {
        if(!(value instanceof String strValue)) return String.valueOf(value);
        for(ConfigParameter parameter : parameters) {
            strValue = strValue.replace(parameter.toString(), parameter.value());
        }
        return strValue;
    }

}
