package net.justkilli.config.values;

public record ConfigValue<T>(String path, T value, ConfigParameter... parameters) {

    public static final ConfigValue<String> STRING = new ConfigValue<String>("string", String.format("Test String %s Value", ConfigParameter.TEST_PARAMETER), ConfigParameter.TEST_PARAMETER);
    public static final ConfigValue<Boolean> BOOLEAN = new ConfigValue<Boolean>("boolean", true);
    public static final ConfigValue<Integer> INTEGER = new ConfigValue<Integer>("integer", 1);
    public static final ConfigValue<Double> DOUBLE = new ConfigValue<Double>("double", 1.0);

    @Override
    public String toString() {
        return replaceParameter();
    }

    public String replaceParameter() {
        if(!(value instanceof String strValue)) return String.valueOf(value);
        for(ConfigParameter parameter : parameters) {
            strValue = strValue.replace(parameter.toString(), parameter.value());
        }
        return strValue;
    }

}
