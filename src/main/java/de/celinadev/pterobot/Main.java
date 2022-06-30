package de.celinadev.pterobot;

import de.celinadev.pterobot.discord.Bot;
import de.celinadev.pterobot.io.Configuration;
import de.celinadev.pterobot.ptero.PteroAPI;

public class Main {

    private static Main instance;
    private Configuration config;
    private Bot bot;
    private PteroAPI pteroAPI;

    private void initialize() {
        this.config = new Configuration("config");
        this.bot = new Bot();
        this.pteroAPI = new PteroAPI();
    }

    public static void main(String[] args) {
        instance = new Main();
        instance.initialize();
    }

    public static Main getInstance() {
        return instance;
    }

    public Configuration getConfig() {
        return config;
    }

    public Bot getBot() {
        return bot;
    }

    public PteroAPI getPteroAPI() {
        return pteroAPI;
    }
}