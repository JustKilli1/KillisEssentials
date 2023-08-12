package net.justkilli.config;

import net.justkilli.config.values.ConfigValue;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public class ConfigHandler implements IConfigHandler {

    private YamlFile config;

    public ConfigHandler(String path) throws IOException {
        config = init(path);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile init(String path) throws IOException {
        config = new YamlFile(path);
        config.options().copyDefaults(true);
        if(config.exists()) return load();
        else return create();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile create() throws IOException {
        config.createNewFile();
        return config;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile load() throws IOException {
        config.load();
        return config;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void save() throws IOException {
        config.save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public YamlFile getConfig() {
        return config;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void addDefaultValue(ConfigValue<T> value) throws IOException {
        config.addDefault(value.path(), value.toString());
        save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void setValue(ConfigValue<T> value) throws IOException {
        config.set(value.path(), value.toString());
        save();
    }
}
