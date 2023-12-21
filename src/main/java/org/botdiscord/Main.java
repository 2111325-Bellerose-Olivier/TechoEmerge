package org.botdiscord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.botdiscord.commands.*;
import org.botdiscord.commands.Blackjack.MainBlackjack;
import org.botdiscord.commands.Blackjack.commands.Hit;
import org.botdiscord.commands.Blackjack.commands.Stand;
import org.botdiscord.commands.Blackjack.commands.StartBlackjack;
import org.botdiscord.commands.Blackjack.sauvegarde.MainSauvegarde;
import org.botdiscord.commands.Blackjack.sauvegarde.commands.BlackjackPointage;
import org.botdiscord.commands.Blackjack.sauvegarde.commands.BlackjackSave;
import org.botdiscord.commands.Overwatch.commands.GetCounter;
import org.botdiscord.commands.Steam.commands.SteamGetPrice;

//fichier main du bot, c'est ici qu'il est initialisé
//noter que j'ai pas commenté les fichiers qui ne sont pas pertinents au projet.

public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        //ligne qui connecte le code au bot. le token sert à ce connecter
        JDA bot = JDABuilder.createDefault("MTEwMTIyOTE2MjkzMDM4OTAxNA.GuVjbp.MNQtsHFz0vv50cpLXqXVXSZW1a-zFITsv7TvhI")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.playing("with mixtapes"))
                .addEventListeners(new Main())
                .build();
        //initialisation du manager de commande
        CommandManager manager = new CommandManager();
        //initailisation du jeu de blackjack
        MainBlackjack jack = new MainBlackjack(bot);
        //plus utilisé, c'est l'ancienne façons de gérer les commandes
        bot.addEventListener(new Listener());
        //bot.addEventListener(new Exemple());
        //bot.addEventListener(new Sum());
        bot.addEventListener(new Explosion());

        //ajout des commandes au command manager
        manager.add(new Play());
        manager.add(new Exemple());
        manager.add(new StartBlackjack());
        manager.add(new Hit());
        manager.add(new SteamGetPrice());
        manager.add(new GetCounter());
        manager.add(new DeleteChannels());
        manager.add(new BlackjackPointage());
        manager.add(new BlackjackSave());
        manager.add(new Stand());

        bot.addEventListener(manager);

        //initialisation
        MainSauvegarde save = new MainSauvegarde();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Récupérer le message et le texte
        Message message = event.getMessage();
        String content = message.getContentRaw();

        // Vérifier si le message provient d'un utilisateur et s'il contient un texte spécifique
        if (!event.getAuthor().isBot() && content.equalsIgnoreCase("!ping")) {
            TextChannel channel = message.getChannel().asTextChannel();
            User author = event.getAuthor();

            // Réagir au message
            channel.sendMessage(author.getAsMention() + ", Pong!").queue();
        }

        if (!event.getAuthor().isBot() && content.equalsIgnoreCase("!soviet")) {

        }
    }
}
