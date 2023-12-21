package org.botdiscord.commands.Blackjack.sauvegarde;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

//script qui gère la sauvegarde des scores au blackjack
public class MainSauvegarde {
    private final String SCORES_FILE = "scores.json";
    private Map<String, Integer> scores; // Utilisateur (par son ID) et score
    public int test = 0;

    //constructeur qui charge les scores existant du fichier json scores.json
    public MainSauvegarde()
    {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        this.scores = loadScoreFromFile();
    }

    //fonction qui utilise ObjectMapper pour lire le fichier json
    //et convertir le contenu du fichier en une Hashmap
    //file: ce qui doit être lu, HashMap: en quoi il doit être converti
    private Map<String, Integer> loadScoreFromFile()
    {
      try{
          File file = new File(SCORES_FILE);
          if(file.exists())
          {
              ObjectMapper objectMapper = new ObjectMapper();
              test = 1;
              return objectMapper.readValue(file, HashMap.class);
          }
      } catch (IOException e) {e.printStackTrace();}
      test = 2;
      return new HashMap<>();
    }

    //enregistre les scores actuels dans le fichier json
    //création d'un nouveaux ObjectMapper, configure des options
    //de mise en forme et écrit la hashmap dans le fichier json
    private void saveScoreToFile(){
        try
        {
            File file = new File(SCORES_FILE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(file,scores);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //renvoie le score d'un joueur. renvoie 0 si aucune score n'est trouvé
    public int getScore(String user)
    {
        return scores.getOrDefault(user,0);
    }

    //sauvegarde le score actuel d'un joueur dans score et ensuite
    // dans le fichier
    public void setScores(String user, int score)
    {
        scores.put(user,score);
        saveScoreToFile();
    }

    //incréemente simplement le score d'un joueur
    public void incrementScore(String user, int points)
    {
        int currentScore = getScore(user);
        setScores(user, currentScore+points);
    }

    //fonction qui sert à tester, imprime les scores dans la console.
    private void printScores(String message) {
        System.out.println(message);
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("User ID: " + entry.getKey() + ", Score: " + entry.getValue());
        }
        System.out.println();
    }

    public int getTest()
    {
        return test;
    }

}
