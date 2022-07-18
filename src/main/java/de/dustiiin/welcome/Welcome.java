package de.dustiiin.welcome;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

import static de.dustiiin.Config.*;


public class Welcome extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        TextChannel channel = event.getGuild().getTextChannelById(welcomeChannel);

        channel.sendMessage("Herzlich Willkommen " + member.getUser().getAsMention()).queue();
        event.getGuild().addRoleToMember(member, Objects.requireNonNull(event.getGuild().getRoleById(welcomeRole))).queue();
    }

}
