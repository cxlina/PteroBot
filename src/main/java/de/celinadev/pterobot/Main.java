package de.celinadev.pterobot;

import de.celinadev.pterobot.discord.Bot;
import de.celinadev.pterobot.io.Configuration;

public class Main {

    private final Configuration config;
    private static Main instance;

    public Main() {
        this.config = new Configuration("config");
    }

    public static void main(String[] args) {
        instance = new Main();
        new Bot();
    }

    public static Main getInstance() {
        return instance;
    }

    public Configuration getConfig() {
        return config;
    }
}