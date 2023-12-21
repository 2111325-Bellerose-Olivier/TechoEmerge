package org.botdiscord.commands.Blackjack;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.util.Random;

//script principale de blackjack. Le jeu est entièrement calculé ici.
public class MainBlackjack {

    public static boolean isPlaying = false;
    public static boolean finJeu_ = false;
    public static int[] mainJoueur;
    public static int totalJoueur;
    public static int[] mainBot;
    public static int[] mainBotShow;
    public static int totalBot;
    public static TextChannel channel_;

    static JDA jda;

    public MainBlackjack(JDA jda){
        this.jda = jda;
    }

    //fonction qui retourne une nouvelle carte aléatoire
    public static int getCarte(){
        Random rand = new Random();
        int carte = rand.nextInt(12);
        carte = carte+1;
        return carte;
    }

    //fonction qui retoune une nouvelle main
    public static int[] NouvelleMain(){
        int carte1 = getCarte();
        int carte2 = getCarte();
        int [] tempMain = {carte1,carte2};
        return tempMain;
    }

    //fonction qui reset le jeu, remet tout à 0
    public static void ResetJeu(){
        int[] temp = {};
        mainBot = temp;
        mainJoueur = temp;
    }

    //fonction appelé quand c'est le tour du bot de jouer
    public static void TourBot(){
        //le total de carte du bot est 17=>=21, il ne fait rien
        if(totalBot >= 17 && totalBot <= 21)
        {
            return;
        }
        //si son total est de <17, il ajoute une carte à sa main
        else if(totalBot < 17)
        {
            int temp = getCarte();
            int[] tempArr = new int[mainBot.length+1];
            //ajoute une carte à la main "normal" du bot
            for(var i = 0; i< mainBot.length;i++)
            {
                tempArr[i] = mainBot[i];
            }
            tempArr[tempArr.length-1] = temp;
            mainBot = tempArr;
            totalBot = totalBot+mainBot[mainBot.length-1];
            //ajoute une carte à la main avec la dernière carte caché du bot
            int[] tempArr2 = new int[mainBot.length];
            for(var i = 0;i<mainBot.length-1;i++)
            {
                tempArr2[i] = mainBot[i];
            }
            tempArr2[mainBot.length-1] = 0;
            mainBotShow = tempArr2;
        }
        if(totalBot > 21 && totalJoueur <= 21)
        {
            FinJeu(true);
        }
        if(totalBot > 21 && totalJoueur > 21)
        {
            FinJeu(false);
        }
        if(totalBot <= 21 && totalJoueur > 21)
        {
            FinJeu(false);
        }
    }

    //fonction qui sert à ajouter une carte aléatoire à la main du joueur
    public static void AjouterCarteJoueur(){
        int temp = getCarte();
        int[] tempArr = new int[mainJoueur.length+1];
        for(var i = 0; i<mainJoueur.length;i++)
        {
            tempArr[i] = mainJoueur[i];
        }
        tempArr[tempArr.length-1] = temp;
        mainJoueur = tempArr;

        totalJoueur = totalJoueur+mainJoueur[mainJoueur.length-1];
    }

    //fonction qui sert à envoyer une main dans un message
    public static void afficherMain(boolean isJoueur)
    {
        String message = "";
        //envoie la main du joueur
        if(isJoueur) {
            message = "votre jeu: ";
            for (var i = 0; i < mainJoueur.length; i++) {
                message = message + mainJoueur[i] + ", ";
            }
            message = message + "total: " + totalJoueur;
            channel_.sendMessage(message).queue();
        }
        //envoie la main du croupier
        else if(!isJoueur)
        {
            message = "jeu du bot: ";
            for(var i = 0;i< mainBotShow.length;i++)
            {
                message = message + mainBotShow[i] + ", ";
            }
            channel_.sendMessage(message).queue();
        }
    }

    //met fait au jeu et envoie un message selon qui a gagné
    public static void FinJeu(boolean joueurGagne){
            isPlaying = false;
            ResetJeu();
            if(joueurGagne)
            {
             channel_.sendMessage("tu as gagné!").queue();
            }
            else {channel_.sendMessage("perdu!").queue();}
    }

    //fonction qui devait être appelé quand c'est le tour du joueur,
    //finalement elle sert à commencer le jeu quand un user fait la commande /blackjack
    public static void Joueur(TextChannel channel){

        if (jda == null) {
            System.out.println("Instance JDA non initialisée.");
            return;
        }

        channel = jda.getTextChannelById(channel.getId());
        if (channel == null) {
            System.out.println("Channel introuvable.");
            return;
        }

        //réinitialise le jeu
        channel_ = channel;
        ResetJeu();
        mainJoueur = NouvelleMain();
        mainBot = NouvelleMain();
        String message = "";

        //calcule le total des cartes de chaque main
        for(var i=0;i< mainBot.length;i++)
        {
            totalBot = totalBot + mainBot[i];
        }

        for(var i = 0;i< mainJoueur.length;i++)
        {
            message = message + mainJoueur[i] + ", ";
            totalJoueur = totalJoueur + mainJoueur[i];
        }

        //envoie les mains du joueur et du croupier en message
        message = "votre main: " + message + "total: " + totalJoueur;

        channel.sendMessage("main du bot: "+mainBot[0]).queue();
        channel.sendMessage(message).queue();
        channel.sendMessage("commandes: /hit  /stand").queue();
    }

}
