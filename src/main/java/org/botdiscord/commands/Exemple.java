package org.botdiscord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Exemple implements IComand {

    @Override
    public String getName() {
        return "exemple";
    }

    @Override
    public String getDescription() {
        return "exemple de commande";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("test").queue(); //pas de reply = le bot se tue
    }
}
