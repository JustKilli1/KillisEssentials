package net.justkilli.config.handler;

import net.justkilli.config.ConfigUtils;
import net.justkilli.config.values.ConfigParameter;
import net.justkilli.config.values.ConfigValue;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YAMLConfigHandler implements IConfigHandler {

    private YamlFile config;

    public YAMLConfigHandler(String path) throws IOException {
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
        config.addDefault(value.path(), value.value());
        setComments(value);
        save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void setComments(ConfigValue<T> value) throws IOException {
        if(value.parameters().length == 0) return;
    String comments = Stream.concat(
                                    Stream.of("Parameter Options:"), Arrays.stream(value.parameters())
                                    .map(ConfigParameter::getParameterDescription)
                                    )
                            .collect(Collectors.joining("\n"));
        config.setComment(value.path(), comments);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public <T> void setValue(ConfigValue<T> value) throws IOException {
        config.set(value.path(), value.toString());
        save();
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<String> getString(ConfigValue<String> value) {
        String configValue = config.getString(value.path());
        return ConfigUtils.createConfigValue(value, configValue, value.parameters());
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Boolean> getBoolean(ConfigValue<Boolean> value) {
        Boolean configValue = config.getBoolean(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Integer> getInteger(ConfigValue<Integer> value) {
        Integer configValue = config.getInt(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public ConfigValue<Double> getDouble(ConfigValue<Double> value) {
        Double configValue = config.getDouble(value.path());
        return ConfigUtils.createConfigValue(value, configValue);
    }
}
