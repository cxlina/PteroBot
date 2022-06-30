package de.celinadev.pterobot.discord;

import de.celinadev.pterobot.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private JDA jda;

    public Bot() {
        String token = Main.getInstance().getConfig().getFile().getString("applicationToken", "invalid");
        try {
            JDABuilder builder = JDABuilder.createDefault(token);
            builder.setStatus(OnlineStatus.ONLINE).setActivity(Activity.watching("Pterodactyl Panel"));
            this.jda = builder.build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
