package net.justkilli.config.values;

/**
 * Represents a configuration value.
 *
 * @param <T> the type of the value
 */
public record ConfigValue<T>(String path, T value, ConfigParameter... parameters) {

    public static final ConfigValue<String> STRING = new ConfigValue<String>("string", String.format("Test String %s Value", ConfigParameter.TEST_PARAMETER), ConfigParameter.TEST_PARAMETER);
    public static final ConfigValue<Boolean> BOOLEAN = new ConfigValue<Boolean>("boolean", true);
    public static final ConfigValue<Integer> INTEGER = new ConfigValue<Integer>("integer", 1);
    public static final ConfigValue<Double> DOUBLE = new ConfigValue<Double>("double", 1.0);

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
