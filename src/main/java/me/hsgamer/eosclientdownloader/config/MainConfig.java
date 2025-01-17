package me.hsgamer.eosclientdownloader.config;

import me.hsgamer.hscore.config.PathableConfig;
import me.hsgamer.hscore.config.path.CommentablePath;
import me.hsgamer.hscore.config.path.ConfigPath;
import me.hsgamer.hscore.config.path.impl.BooleanConfigPath;
import me.hsgamer.hscore.config.path.impl.StringConfigPath;
import me.hsgamer.hscore.config.simpleconfiguration.SimpleConfig;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class MainConfig extends PathableConfig {
    public static final ConfigPath<String> CLIENT_ID = new CommentablePath<>(
            new StringConfigPath("client.id", ""),
            "The client's ID"
    );
    public static final ConfigPath<String> CLIENT_SECRET = new CommentablePath<>(
            new StringConfigPath("client.secret", ""),
            "The client's secret key"
    );
    public static final ConfigPath<String> CLIENT_FOLDER_ID = new CommentablePath<>(
            new StringConfigPath("client.folder-id", "10sGYKJCvNNra6WAnAsILFLd2qBbd9043"),
            "The folder's ID"
    );
    public static final ConfigPath<Boolean> FILE_DELETE_EXISTED_UNCOMPRESSED = new CommentablePath<>(
            new BooleanConfigPath("file.delete-existed-files", false),
            "Should the existed files be deleted before uncompressing ?"
    );

    public MainConfig() {
        super(new SimpleConfig<>(new File(".", "config.yml"), new YamlFile(), (file, yamlFile) -> {
            yamlFile.setConfigurationFile(file);
            try {
                yamlFile.loadWithComments();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }));
    }
}
