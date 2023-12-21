package org.botdiscord.commands.Blackjack.commands;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Blackjack.MainBlackjack;

import java.util.List;


//fichier qui gère la commande de /hit
public class Hit implements IComand {

    //nom de la commande
    @Override
    public String getName() {
        return "hit";
    }
    //description de la commande
    @Override
    public String getDescription() {
        return "lors du blackjack, hit pour demander une autre carte";
    }
    //pas utilisé ici
    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    //appèle les bonnes fonctions du fichier de blackjack quand le joueur fait la commande /hit
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if(MainBlackjack.isPlaying)
        {
            MainBlackjack.AjouterCarteJoueur();
            MainBlackjack.TourBot();
            MainBlackjack.afficherMain(false);
            MainBlackjack.afficherMain(true);
            event.reply("commandes: /hit  /stand").queue();
        }
    }
}
