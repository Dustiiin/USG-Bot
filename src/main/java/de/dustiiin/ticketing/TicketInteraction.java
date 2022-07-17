package de.dustiiin.ticketing;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static de.dustiiin.Config.*;

public class TicketInteraction extends ListenerAdapter {

    public void onSelectMenuInteraction(SelectMenuInteractionEvent event) {
        String categoryid = "";
        String name = "";



        if (event.getSelectMenu().getId().equals("ticketmenu")) {
            if (event.getInteraction().getId().equals("carrer")) {
                categoryid = carrerid;
                name = "Karriere";
            }




            Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(categoryid);
            TextChannel channel = event.getGuild().createTextChannel(name + "-" + Objects.requireNonNull(event.getMember()).getUser().getName(), category).complete();

            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.HSBtoRGB(48, 68, 60));
            builder.setDescription("Es wird sich in kürze um dich gekümmert\n"
                                 + "Reagiere mit \uD83D\uDD12 + und das Ticket wird geschlossen");

            Message message = channel.sendMessageEmbeds(builder.build())
                    .setActionRow(sendButtons())
                    .complete();

            Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

            String jumpURL = message.getJumpUrl();
            event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
            channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
            ping.delete().queue();
        }
    }

    public void onButtonInteraction(ButtonInteractionEvent event) {
        Member user = event.getMember();

        if (event.getButton().getId().equals("closeticket")) {
            event.reply("Dieses Ticket wird geschlossen").queue();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getTextChannel().delete().queue();
        }
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ticket")) {
            boolean bol = event.getOption("bol").getAsBoolean();


                TextChannel channel = event.getGuild().getTextChannelById("998038479512539236");
                if (bol) {
                    event.reply("Du hast den Kassen Command aktiviert!").setEphemeral(true).queue();
                    channel.deleteMessageById(channel.getLatestMessageId()).queue();
                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setColor(Color.MAGENTA.darker());
                    builder.setTitle("Bewerbung");
                    builder.setDescription("Hier kannst du dich bei uns bewerben.");

                    channel.sendMessageEmbeds(builder.build())
                            .setActionRow(
                                    SelectMenu.create("ticketmenu")
                                            .addOption("Karriere", "carrer")
                                            .addOption("Adoption", "adopt")
                                            .addOption("Eheschließung", "marry")
                                            .addOption("Gewerbe", "busimess")
                                            .addOption("Alggemeine Frage", "question")
                                            .addOption("Tierhaltungslizenz", "livestock")
                                            .addOption("Strafanzeige", "complaint")
                                            .build()
                            )
                            .queue();
                } else {
                    event.reply("Der Channel befindet sich jetzt im Wartungsmodus").setEphemeral(true).queue();
                    channel.deleteMessageById(channel.getLatestMessageId()).queue();
                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setTitle("Channel aktuelle gesperrt!");
                    builder.setDescription("Dieser Channel befimdet sich aktuell in Wartungsarbeiten");

                    channel.sendMessageEmbeds(builder.build()).queue();
                }
            }
        }


    private static List<Button> sendButtons() {
        List<Button> buttons = new ArrayList<>();
        buttons.add(Button.danger("closeticket", "Close"));

        return buttons;
    }
}
