package de.celinadev.pterobot.commands.impl;

import com.mattmalec.pterodactyl4j.client.entities.ClientServer;
import com.mattmalec.pterodactyl4j.exceptions.NotFoundException;
import de.celinadev.pterobot.Main;
import de.celinadev.pterobot.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public class StartServerCommand extends Command {

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public void run(Member member, MessageChannel channel, Message message, String[] args) {
        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            if (args.length == 1) {
                String id = args[0];
                try {
                    ClientServer server = Main.getInstance().getPteroAPI().getClient().retrieveServerByIdentifier(id).execute();
                    server.start().execute();
                    message.reply("Starting the Server " + server.getName()).queue();
                } catch (NotFoundException e) {
                    message.reply("There's no existing server with this ID.").queue();
                }
            } else message.reply("Please use ;start <server-id>").queue();
        } else message.reply("You don't have the required Permissions for this Command.").queue();
    }
}