package de.celinadev.pterobot.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public abstract class Command {

    public String getName() {
        return null;
    }

    public void run(Member member, MessageChannel channel, Message message, String[] args) {
    }
}
