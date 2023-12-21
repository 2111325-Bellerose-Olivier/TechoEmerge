package org.botdiscord;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;


//interface utilisé pour gérer les commandes
public interface IComand {
    //nom de la commande
    String getName();
    //description de la commande
    String getDescription();
    //option de la commande (comme le lien youtube pour la commande de /play par exemple)
    List<OptionData> getOptions();

    //action effectué quand la commande est appelé
    void execute(SlashCommandInteractionEvent event);
}
