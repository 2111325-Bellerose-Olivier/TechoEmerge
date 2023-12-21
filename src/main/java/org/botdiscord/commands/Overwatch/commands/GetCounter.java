package org.botdiscord.commands.Overwatch.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.botdiscord.commands.Overwatch.MainOverwatch;

import java.util.ArrayList;
import java.util.List;

public class GetCounter implements IComand {
    @Override
    public String getName() {
        return "get_counter";
    }

    @Override
    public String getDescription() {
        return "retourne les counters du héro choisie";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.STRING, "hero", "le nom du héro en minuscule, sans accents", true));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        OptionMapping hero = event.getOption("hero");
        String hero_ = hero.getAsString();
        String message = MainOverwatch.GetCounterHero(hero_);
        event.reply(message).queue();
    }
}
