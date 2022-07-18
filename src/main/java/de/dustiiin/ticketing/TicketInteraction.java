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
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static de.dustiiin.Config.*;

public class TicketInteraction extends ListenerAdapter {


    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        if (event.getComponentId().equals("ticketmenu")) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.yellow);
            builder.setDescription("Es wird sich in kürze um dich gekümmert");

            if ("carrer".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(carrerid);
                TextChannel channel = event.getGuild().createTextChannel("Karrier-" + event.getMember().getUser().getName(), category).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("adopt".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(adoptid);
                TextChannel channel = event.getGuild().createTextChannel("Adoption-" + event.getMember().getUser().getName(), category).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("marry".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(marryid);
                TextChannel channel = event.getGuild().createTextChannel("Eheschließung-" + event.getMember().getUser().getName(), category).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("business".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(businessid);
                TextChannel channel = event.getGuild().createTextChannel("Gewerbe-" + event.getMember().getUser().getName(), category).complete();
                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("question".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(questionid);
                TextChannel channel = event.getGuild().createTextChannel("Frage-" + event.getMember().getUser().getName(), category).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("livestock".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(livestockid);
                TextChannel channel = event.getGuild().createTextChannel("Tierhaltungslizenz-" + event.getMember().getUser().getName(), category).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            } else if ("complaint".equals(event.getValues().get(0))) {
                Category category = Objects.requireNonNull(event.getGuild()).getCategoryById(complaintid);
                TextChannel channel = event.getGuild().createTextChannel("Strafanzeige-" + event.getMember().getUser().getName()).complete();

                Message message = channel.sendMessageEmbeds(builder.build())
                        .setActionRow(sendButtons()).complete();

                Message ping = channel.sendMessage(event.getMember().getUser().getAsMention()).complete();

                String jumpURL = message.getJumpUrl();
                event.reply("Deine Ticket wurde erstellt\n" + "[" + channel.getName() +"](" + jumpURL + ")").setEphemeral(true).queue();
                channel.upsertPermissionOverride(event.getMember()).grant(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
                ping.delete().queue();

            }
        }
    }




    public void onButtonInteraction(ButtonInteractionEvent event) {


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
