package org.botdiscord.commands.Steam.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Steam.MainSteam;

import java.util.ArrayList;
import java.util.List;

public class SteamGetPrice implements IComand {
    @Override
    public String getName() {
        return "steam_get_price";
    }

    @Override
    public String getDescription() {
        return "obtenir le prix d'un jeu";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.STRING, "nom_jeu", "le nom du jeu", true));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply(MainSteam.main()).queue();
    }
}
