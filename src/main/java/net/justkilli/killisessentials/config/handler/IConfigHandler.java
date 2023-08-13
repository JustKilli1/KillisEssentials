package net.justkilli.killisessentials.config.handler;

import net.justkilli.killisessentials.config.values.ConfigValue;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

/**
 * The IConfigHandler interface provides methods to handle configuration files.
 *
 * <p>
 * The main purpose of this interface is to initialize, create, load, save, and access configuration files.
 * It also provides methods to add default values, set comments, and modify values in the configuration file.
 * </p>
 */
public interface IConfigHandler {


    /**
     * Initializes a YamlFile object based on the given path.
     *
     * @param path the path of the YAML file
     * @return the initialized YamlFile object
     * @throws IOException if an I/O error occurs
     */
    YamlFile init(String path) throws IOException;

    /**
     * Creates a new YamlFile object.
     *
     * @return the created YamlFile object
     * @throws IOException if an I/O error occurs
     */
    YamlFile create() throws IOException;

    /**
     * Loads an existing YamlFile object.
     *
     * @return the loaded YamlFile object
     * @throws IOException if an I/O error occurs
     */
    YamlFile load() throws IOException;

    /**
     * Saves the YamlFile object.
     *
     * @throws IOException if an I/O error occurs
     */
    void save() throws IOException;

    /**
     * Returns the YamlFile configuration object.
     *
     * @return the YamlFile configuration object
     */
    YamlFile getConfig();

    /**
     * Adds a default value to the configuration.
     *
     * @param value the {@link ConfigValue} object representing the default value to be added
     * @throws IOException if an I/O error occurs while adding the default value
     */
    <T> void addDefaultValue(ConfigValue<T> value) throws IOException;

    /**
     * Sets the comments for a configuration value.
     *
     * @param value the {@link ConfigValue} object for which to set the comments
     * @throws IOException if an I/O error occurs while setting the comments
     */
    <T> void setComments(ConfigValue<T> value) throws IOException;

    /**
     * Sets the value for a configuration property.
     *
     * @param value the {@link ConfigValue} object for which to set the value
     * @throws IOException if an I/O error occurs while setting the value
     */
    <T> void setValue(ConfigValue<T> value) throws IOException;

    /**
     * Retrieves a string value from a configuration property.
     *
     * @param value the {@link ConfigValue} object representing the configuration property
     * @return the {@link ConfigValue} object with the retrieved string value
     */
    ConfigValue<String> getString(ConfigValue<String> value);

    /**
     * Retrieves a boolean value from a configuration property.
     *
     * @param value the {@link ConfigValue} object representing the configuration property
     * @return the {@link ConfigValue} object with the retrieved boolean value
     */
    ConfigValue<Boolean> getBoolean(ConfigValue<Boolean> value);

    /**
     * Retrieves an integer value from a configuration property.
     *
     * @param value the {@link ConfigValue} object representing the configuration property
     * @return the {@link ConfigValue} object with the retrieved integer value
     */
    ConfigValue<Integer> getInteger(ConfigValue<Integer> value);

    /**
     * Retrieves a double value from a configuration property.
     *
     * @param value the {@link ConfigValue} object representing the configuration property
     * @return the {@link ConfigValue} object with the retrieved double value
     */
    ConfigValue<Double> getDouble(ConfigValue<Double> value);
}
