package de.celinadev.pterobot.discord;

import de.celinadev.pterobot.Main;
import de.celinadev.pterobot.commands.CommandManager;
import de.celinadev.pterobot.util.LogUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.List;

public class Bot {

    private JDA jda;

    public Bot() {
        String token = Main.getInstance().getConfig().getFile().getString("applicationToken", "invalid");
        List<String> intents = Main.getInstance().getConfig().getFile().getStringList("enabledIntents");
        try {
            JDABuilder builder = JDABuilder.createDefault(token);
            builder.setStatus(OnlineStatus.ONLINE).setActivity(Activity.watching("Pterodactyl Panel"));
            for (String intent : intents) {
                builder.enableIntents(GatewayIntent.valueOf(intent));
                LogUtil.log("JDA", "Enabled Intent '" + intent.toLowerCase().replace("_", " ") + "'");
            }
            builder.addEventListeners(new CommandManager());
            this.jda = builder.build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public JDA getJDA() {
        return jda;
    }
}
