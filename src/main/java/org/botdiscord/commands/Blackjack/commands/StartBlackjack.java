package org.botdiscord.commands.Blackjack.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Blackjack.MainBlackjack;

import java.util.List;
//fichier pour la commande /blackjack
public class StartBlackjack implements IComand {
    //nom de la commande
    @Override
    public String getName() {
        return "blackjack";
    }
    //description de la commande
    @Override
    public String getDescription() {
        return "commencer la partie de Blackjack";
    }
    //pas utilisé ici
    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    //appele les bonnes fonctions du fichier de blackjack quand le joueur fait la commande /blackjack
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        MainBlackjack.isPlaying = true;
        event.reply("la partie de blackjack commence!").queue();
        MainBlackjack.Joueur(event.getChannel().asTextChannel());
    }
}
