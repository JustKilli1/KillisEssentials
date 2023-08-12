package net.justkilli.config.values;

public record ConfigValue<T>(String path, T value) {

    public static final ConfigValue<String> STRING = new ConfigValue<String>("string", "Test String Value");
    public static final ConfigValue<Boolean> BOOLEAN = new ConfigValue<Boolean>("boolean", true);
    public static final ConfigValue<Integer> INTEGER = new ConfigValue<Integer>("integer", 1);
    public static final ConfigValue<Double> DOUBLE = new ConfigValue<Double>("double", 1.0);

    @Override
    public String toString() {
        return String.valueOf(value());
    }

}
