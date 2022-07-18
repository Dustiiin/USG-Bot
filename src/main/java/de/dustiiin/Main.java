package de.dustiiin;

import de.dustiiin.ticketing.TicketInteraction;
import de.dustiiin.welcome.Welcome;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

import static de.dustiiin.Config.*;

public class Main {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(token)
                .setActivity(Activity.listening("Gesetzbuch zu!"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .enableIntents(GatewayIntent.GUILD_EMOJIS)
                .addEventListeners(new TicketInteraction())
                .addEventListeners(new Welcome())
                .build().awaitReady();


        Guild guild = jda.getGuildById("985346382456037446");

        if (guild != null) {
            guild.upsertCommand("ticket", "Ak- oder Deaktivier die Tickets")
                    .addOption(OptionType.BOOLEAN, "bol", "true oder false", true).queue();
        }




    }
}
