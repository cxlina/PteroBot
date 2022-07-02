package de.celinadev.pterobot.commands;

import de.celinadev.pterobot.commands.impl.ListServersCommand;
import de.celinadev.pterobot.commands.impl.RestartServerCommand;
import de.celinadev.pterobot.commands.impl.StartServerCommand;
import de.celinadev.pterobot.commands.impl.StopServerCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private final List<Command> registeredCommands;

    public CommandManager() {
        this.registeredCommands = new ArrayList<>();
        this.registeredCommands.addAll(Arrays.asList(
                new StartServerCommand(),
                new StopServerCommand(),
                new RestartServerCommand(),
                new ListServersCommand()
        ));
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot() || e.isWebhookMessage() || !e.getMessage().getContentRaw().startsWith(";")) return;
        String command = e.getMessage().getContentRaw().split(" ")[0].substring(1);
        for (Command c : this.registeredCommands) {
            if (command.equals(c.getName())) {
                String[] args = new String[]{};
                for (String s : e.getMessage().getContentRaw().split(" "))
                    if (!s.equalsIgnoreCase(";" + command))
                        args = ArrayUtils.add(args, s);
                c.run(e.getMember(), e.getChannel(), e.getMessage(), args);
                return;
            }
        }
    }

    public List<Command> getRegisteredCommands() {
        return registeredCommands;
    }
}
