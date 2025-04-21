package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tests extends MyTabs implements ActionListener{

    MyButton furMark;
    MyButton occt;
    MyButton memtest86;
    MyButton aida64;
    MyButton fanControl;
    MyButton prime95;
    MyButton powerMax;
    MyButton threedmark;
    MyButton pcmark;

    public Tests(){

        furMark = new MyButton();
        furMark.addAppCode(6,0);
        furMark.addActionListener(this);

        occt = new MyButton();
        occt.addAppCode(6,1);
        occt.addActionListener(this);

        memtest86 = new MyButton();
        memtest86.addAppCode(6,2);
        memtest86.addActionListener(this);

        aida64 = new MyButton();
        aida64.addAppCode(6,3);
        aida64.addActionListener(this);

        fanControl = new MyButton();
        fanControl.addAppCode(6,4);
        fanControl.addActionListener(this);

        prime95 = new MyButton();
        prime95.addAppCode(6,5);
        prime95.addActionListener(this);

        powerMax = new MyButton();
        powerMax.addAppCode(6,6);
        powerMax.addActionListener(this);

        threedmark = new MyButton();
        threedmark.addAppCode(6,7);
        threedmark.addActionListener(this);

        pcmark = new MyButton();
        pcmark.addAppCode(6,8);
        pcmark.addActionListener(this);

        buttons[0] = furMark;
        buttons[1] = occt;
        buttons[2] = memtest86;
        buttons[3] = aida64;
        buttons[4] = fanControl;
        buttons[5] = prime95;
        buttons[6] = powerMax;
        buttons[7] = threedmark;
        buttons[8] = pcmark;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== furMark){buttons[0].selectButton();}

        else if(e.getSource()== occt){buttons[1].selectButton();}

        else if(e.getSource()== memtest86){buttons[2].selectButton();}

        if(e.getSource()== aida64){buttons[3].selectButton();}

        else if(e.getSource()== fanControl){buttons[4].selectButton();}

        else if(e.getSource()== prime95){buttons[5].selectButton();}

        else if(e.getSource()== powerMax){buttons[6].selectButton();}

        else if(e.getSource()== threedmark){buttons[7].selectButton();}

        else if(e.getSource()== pcmark){buttons[8].selectButton();}
    }
}
