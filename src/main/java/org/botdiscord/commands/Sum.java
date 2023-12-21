package org.botdiscord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.botdiscord.IComand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Sum implements IComand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "get sum of two numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.INTEGER, "num1", "the first number", true)
                .setMinValue(1)
                .setMaxValue(100));
        data.add(new OptionData(OptionType.INTEGER, "num2", "the second number", true)
                .setMinValue(1)
                .setMaxValue(100));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        OptionMapping num1 = event.getOption("num1");
        int num1_ = num1.getAsInt();

        OptionMapping num2 = event.getOption("num2");
        int num2_ = num2.getAsInt();

        event.reply(num1_ + num2_ + "").queue(); //sans le + "", sa crash, on peut pas juste afficher un int tout seul
    }
}
