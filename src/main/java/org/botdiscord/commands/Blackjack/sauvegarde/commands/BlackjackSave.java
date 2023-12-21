package org.botdiscord.commands.Blackjack.sauvegarde.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Blackjack.sauvegarde.MainSauvegarde;

import java.util.List;

public class BlackjackSave implements IComand {
    //nom de la commande
    @Override
    public String getName() {
        return "blackjack_save";
    }
    //description de la commande
    @Override
    public String getDescription() {
        return "commande pour sauvegarder la progression au blackjack";
    }
    //pas utilisé ici
    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    //appele les bonnes fonctions du fichier de blackjack quand le joueur fait la commande /blackjack_save
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        MainSauvegarde save = new MainSauvegarde();
        String user = event.getInteraction().getUser().getName();
        save.incrementScore(user,10);
        event.reply("pointage sauvegardé").queue();
    }
}
