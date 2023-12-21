package org.botdiscord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {
//    @Override
//    public void onReady(@NotNull ReadyEvent event){
//        Guild guild = event.getJDA().getGuildById("905114575391817728");
//        guild.upsertCommand("exemple", "commande d'exemple").queue();
//        guild.upsertCommand("sum", "gives the sum of two numbers").addOptions(//addOptions sert à ajouter des options dans la commande. dans ce cas-ci, un nombre pour faire l'addition
//                new OptionData(OptionType.INTEGER, "num1", "the first number", true)
//                        .setMinValue(1)
//                        .setMaxValue(100),
//                new OptionData(OptionType.INTEGER, "num2", "the second number", true)
//                .setMinValue(1)
//                .setMaxValue(100)
//        ).queue();
//        guild.upsertCommand("explosion","ÇA EXPLOSE LE SERVEUR HAHAHAHAHHA (non sérieux ça extermine le serveur)").queue();
//    }
}
