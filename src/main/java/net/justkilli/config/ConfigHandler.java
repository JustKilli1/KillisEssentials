package net.justkilli.config;

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
}
