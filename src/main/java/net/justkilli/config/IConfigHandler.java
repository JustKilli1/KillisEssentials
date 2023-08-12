package net.justkilli.config;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public interface IConfigHandler {

    YamlFile init(String path) throws IOException;
    YamlFile create() throws IOException;
    YamlFile load() throws IOException;
    YamlFile getConfig();

}
