package org.example.Downloader.Apps;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Communication that represents a tab of specific app type.
 */
public class Communication extends MyTabs{

    AppButton discord = new AppButton();
    AppButton telegram = new AppButton();
    AppButton whatsUp = new AppButton();
    AppButton teamSpeak = new AppButton();
    AppButton skype = new AppButton();
    AppButton teams = new AppButton();

    /**
     * Construct an object of Communication that contains objects of AppButton with stored apps.
     */
    public Communication() {

        discord.addAppCode(4, 0);
        discord.addActionListener(e -> buttons[0].selectButton());


        telegram.addAppCode(4, 1);
        telegram.addActionListener(e -> buttons[1].selectButton());


        whatsUp.addAppCode(4, 2);
        whatsUp.addActionListener(e -> buttons[2].selectButton());


        teamSpeak.addAppCode(4, 3);
        teamSpeak.addActionListener(e -> buttons[3].selectButton());


        skype.addAppCode(4, 4);
        skype.addActionListener(e -> buttons[4].selectButton());


        teams.addAppCode(4, 5);
        teams.addActionListener(e -> buttons[5].selectButton());

        buttons[0] = discord;
        buttons[1] = telegram;
        buttons[2] = whatsUp;
        buttons[3] = teamSpeak;
        buttons[4] = skype;
        buttons[5] = teams;

        for (AppButton button : buttons) {
            this.add(button);

        }
    }
}
