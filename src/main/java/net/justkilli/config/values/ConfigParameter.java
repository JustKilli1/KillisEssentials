package net.justkilli.config.values;

public record ConfigParameter(String name, String value, String description) {

    public static final ConfigParameter TEST_PARAMETER = new ConfigParameter("test", "Das ist ein Test Parameter", "Das ist eine Test erklärung für den Parameter");
    private static final Character IDENTIFIER = '%';

    @Override
    public String toString() {
        return IDENTIFIER + name() + IDENTIFIER;
    }

    public ConfigParameter copy(String value) {
        return new ConfigParameter(name(), value, description);
    }

    public String getParameterDescription() {
        return String.format("%s -> %s", toString(), description);
    }

}
