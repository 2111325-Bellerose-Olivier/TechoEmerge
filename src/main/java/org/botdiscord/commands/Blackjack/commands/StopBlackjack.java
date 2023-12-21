package org.botdiscord.commands.Blackjack.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Blackjack.MainBlackjack;

import java.util.List;
//fichier pour la commande /stopBlackjack
public class StopBlackjack implements IComand {
    //nom de la commande
    @Override
    public String getName() {
        return "stopBlackjack";
    }
    //description de la commande
    @Override
    public String getDescription() {
        return "arrêter la partie en cours";
    }
    //pas utilisé ici
    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    //appèle les bonnes fonctions du fichier de blackjack quand le joueur fait la commande /stopBlackjack
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        MainBlackjack.FinJeu(false);
    }
}
