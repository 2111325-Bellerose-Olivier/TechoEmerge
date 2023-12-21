package org.botdiscord.commands.Overwatch;

import java.util.Objects;

public class MainOverwatch {

    public static String GetCounterHero(String hero){
        String message;

        if(hero == "dva"){message = "Zarya, Winston, Symmetra, Mei, Moira";}
        else if(Objects.equals(hero, "doomfist")){message = "Tracer, Genji, Bastion, Sombra, Widowmaker, Ash, Ana";}
        else if(Objects.equals(hero, "orisa")){message = "Zarya, Winston, Doomfist, Symmetra, Moira";}
        else if(Objects.equals(hero, "ramattra")){message = "Roadhog, Reaper, Pharah, Genji, Widowmaker, Cassidy";}
        else if(Objects.equals(hero, "reinhardt")){message = "Sombra, Cass, Bastion, Mei, Junkrat, Pharah";}
        else if(Objects.equals(hero, "roadhog")){message = "Wrecking Ball, Reaper, Echo, Junkrat, Pharah, Sombra, Widowmaker, Ana";}
        else if(Objects.equals(hero, "sigma")){message = "Ramattra, Roadhog, Genji, Tracer, Sombra, Lucio";}
        else if(Objects.equals(hero, "winston")){message = "Zarya, Junkrat, Pharah, Bastion, Ana, Brigitte";}
        else if(Objects.equals(hero, "wreckingball")){message = "Roadhog, Mei, Sombra, Ana, Brigitte";}
        else if(Objects.equals(hero, "zarya")){message = "Dva, Junkrat, Pharah, Echo, Bastion, Genji";}
        else {message = "hero non trouvé " + hero;}

        return message;
    }
}
