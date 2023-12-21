package org.botdiscord.commands.Blackjack.sauvegarde.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Blackjack.sauvegarde.MainSauvegarde;

import java.util.List;

public class BlackjackPointage implements IComand {
    //nom de la commande
    @Override
    public String getName() {
        return "blackjack_pointage";
    }
    //description de la commande
    @Override
    public String getDescription() {
        return "avoir ton pointage total actuel";
    }
    //pas utilisé ici
    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    //appele les bonnes fonctions du fichier de blackjack quand le joueur fait la commande /blackjack_pointage
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        MainSauvegarde save = new MainSauvegarde();


        event.reply("ton score: "+save.getScore("user1_id")).queue();
    }
}
