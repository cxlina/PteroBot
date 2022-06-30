package de.celinadev.pterobot.io;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public class Configuration {

    private YamlFile file;

    public Configuration(String name) {
        try {
            if (!name.endsWith(".yml") && !name.endsWith(".yaml")) name += ".yml";
            this.file = new YamlFile("./config/" + name);
            if (!this.file.exists())
                this.file.createNewFile();
            this.file.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void set(String path, Object value) {
        try {
            this.file.set(path, value);
            this.file.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlFile getFile() {
        return file;
    }
}
