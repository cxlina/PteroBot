package de.celinadev.pterobot.commands.impl;

import com.mattmalec.pterodactyl4j.client.entities.ClientServer;
import de.celinadev.pterobot.Main;
import de.celinadev.pterobot.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.List;

public class ListServersCommand extends Command {

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public void run(Member member, MessageChannel channel, Message message, String[] args) {
        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            if (args.length == 0) {
                try {
                    List<String> servers = new ArrayList<>();
                    StringBuilder s = new StringBuilder("Servers:");
                    for (ClientServer server : Main.getInstance().getPteroAPI().getClient().retrieveServers().execute()) {
                        s.append("\n").append(server.getName()).append(": ").append(server.getIdentifier());
                    }
                    message.reply(s.toString()).queue();
                } catch (Exception e) {
                    message.reply("Received error. Check Terminal.").queue();
                }
            } else message.reply("Please use ;list").queue();
        } else message.reply("You don't have the required Permissions for this Command.").queue();
    }
}
