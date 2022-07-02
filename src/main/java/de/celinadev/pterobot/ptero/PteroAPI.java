package de.celinadev.pterobot.ptero;

import com.mattmalec.pterodactyl4j.PteroBuilder;
import com.mattmalec.pterodactyl4j.client.entities.PteroClient;
import de.celinadev.pterobot.Main;
import de.celinadev.pterobot.util.LogUtil;

public class PteroAPI {

    private PteroClient client;

    public PteroAPI() {
        try {
            String apiKey = Main.getInstance().getConfig().getFile().getString("pteroApiKey", "invalid");
            String apiUrl = Main.getInstance().getConfig().getFile().getString("pteroApiUrl", "invalid");
            if (apiKey.equals("invalid")) {
                LogUtil.error("Ptero", "Missing API key.", "at: config.yml");
                System.exit(0);
            }
            if (apiUrl.equals("invalid")) {
                LogUtil.error("Ptero", "Missing API URL.", "at: config.yml");
                System.exit(0);
            }
            this.client = PteroBuilder.createClient(apiUrl, apiKey);
            this.client.retrieveServers().execute();
            LogUtil.log("Ptero", "Initialized Ptero Client.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PteroClient getClient() {
        return client;
    }
}
