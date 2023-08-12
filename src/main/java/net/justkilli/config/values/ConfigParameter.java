package net.justkilli.config.values;

/**
 * Represents a configuration parameter with its name, value, and description.
 */
public record ConfigParameter(String name, String value, String description) {

    public static final ConfigParameter TEST_PARAMETER = new ConfigParameter("test", "Das ist ein Test Parameter", "Das ist eine Test erklärung für den Parameter");
    private static final Character IDENTIFIER = '%';

    @Override
    public String toString() {
        return IDENTIFIER + name() + IDENTIFIER;
    }

    /**
     * Creates a copy of the ConfigParameter with the specified value.
     *
     * @param value the value to be set for the copied ConfigParameter
     * @return a new ConfigParameter with the same name, the specified value, and the same description
     */
    public ConfigParameter copy(String value) {
        return new ConfigParameter(name(), value, description);
    }

    /**
     * Returns the description of the ConfigParameter in the format:
     * "[name] -> [description]"
     *
     * @return the description of the ConfigParameter
     */
    public String getParameterDescription() {
        return String.format("%s -> %s", toString(), description);
    }

}
