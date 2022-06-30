package de.celinadev.pterobot.ptero;

import com.mattmalec.pterodactyl4j.PteroBuilder;
import com.mattmalec.pterodactyl4j.application.entities.PteroApplication;
import com.mattmalec.pterodactyl4j.client.entities.PteroClient;
import de.celinadev.pterobot.Main;
import de.celinadev.pterobot.util.LogUtil;

public class PteroAPI {

    private PteroClient client;
    private PteroApplication app;

    public PteroAPI() {
        String apiKey = Main.getInstance().getConfig().getFile().getString("pteroApiKey", "invalid");
        String apiUrl = Main.getInstance().getConfig().getFile().getString("pteroApiUrl", "invalid");
        if (apiKey.equals("invalid")) {
            LogUtil.error("Ptero", "Missing or invalid API key.", "line1", "line2");
            System.exit(0);
        }
        if (apiUrl.equals("invalid")) {
            LogUtil.log("Ptero", "Missing or invalid API URL.");
            System.exit(0);
        }
        this.client = PteroBuilder.createClient(apiUrl, apiKey);
        LogUtil.log("Ptero", "Initialized Ptero Client.");
        this.app = PteroBuilder.createApplication(apiUrl, apiKey);
        LogUtil.log("Ptero", "Initialized Ptero Application.");
    }

    public PteroClient getClient() {
        return client;
    }

    public PteroApplication getApp() {
        return app;
    }
}
