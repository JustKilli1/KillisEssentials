package net.justkilli.config.values;

public record ConfigParameter(String name, String value) {

    public static final ConfigParameter TEST_PARAMETER = new ConfigParameter("test", "Das ist ein Test Parameter");
    private static final Character IDENTIFIER = '%';

    @Override
    public String toString() {
        return IDENTIFIER + name() + IDENTIFIER;
    }

    public ConfigParameter copy(String value) {
        return new ConfigParameter(name(), value);
    }

}
