package org.botdiscord.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;

import java.util.List;

public class DeleteChannels implements IComand {
    @Override
    public String getName() {
        return "delete_all_channels";
    }

    @Override
    public String getDescription() {
        return "delete tout les channels du serveur";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        List<TextChannel> textChannels = guild.getTextChannels();

        for(TextChannel textChannel : textChannels)
        {
            if(!textChannel.getName().equals("general"))
            {
                textChannel.delete().queue();
            }
            else{continue;}
        }
        event.reply("lmao les channels sont deletes").queue();
    }
}
