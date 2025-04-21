package org.example.Interface.Apps;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Communication extends MyTabs implements ActionListener{

    MyButton discord;
    MyButton telegram;
    MyButton whatsUp;
    MyButton teamSpeak;
    MyButton skype;
    MyButton teams;

    public Communication() {
        discord = new MyButton();
        discord.addAppCode(4, 0);
        discord.addActionListener(this);

        telegram = new MyButton();
        telegram.addAppCode(4, 1);
        telegram.addActionListener(this);

        whatsUp = new MyButton();
        whatsUp.addAppCode(4, 2);
        whatsUp.addActionListener(this);

        teamSpeak = new MyButton();
        teamSpeak.addAppCode(4, 3);
        teamSpeak.addActionListener(this);

        skype = new MyButton();
        skype.addAppCode(4, 4);
        skype.addActionListener(this);

        teams = new MyButton();
        teams.addAppCode(4, 5);
        teams.addActionListener(this);

        buttons[0] = discord;
        buttons[1] = telegram;
        buttons[2] = whatsUp;
        buttons[3] = teamSpeak;
        buttons[4] = skype;
        buttons[5] = teams;

        for (MyButton button : buttons) {
            this.add(button);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== discord){buttons[0].selectButton();}

        else if(e.getSource()== telegram){buttons[1].selectButton();}

        else if(e.getSource()== whatsUp){buttons[2].selectButton();}

        else if(e.getSource()== teamSpeak){buttons[3].selectButton();}

        else if(e.getSource()== skype){buttons[4].selectButton();}

        else if(e.getSource()== teams){buttons[5].selectButton();}
    }
}
