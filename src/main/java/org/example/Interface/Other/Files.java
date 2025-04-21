package org.example.Interface.Other;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Files extends MyTabs implements ActionListener{

    MyButton cyberpunk_extra_content;
    MyButton sh2_music;

    public Files(){

        cyberpunk_extra_content = new MyButton();
        cyberpunk_extra_content.addAppCode(12, 0);
        cyberpunk_extra_content.addActionListener(this);

        sh2_music = new MyButton();
        sh2_music.addAppCode(12, 1);
        sh2_music.addActionListener(this);

        buttons[0] = cyberpunk_extra_content;
        buttons[1] = sh2_music;

        for(MyButton button : buttons){
            this.add(button);
        }

        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== cyberpunk_extra_content){buttons[0].selectButton();}

        else if(e.getSource()== sh2_music){buttons[1].selectButton();}
    }
}
