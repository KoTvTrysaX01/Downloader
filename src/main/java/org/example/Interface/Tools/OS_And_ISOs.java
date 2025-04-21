package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OS_And_ISOs extends MyTabs implements ActionListener{

    MyButton win10;
    MyButton win11;
    MyButton ubuntu24;
    MyButton mediCat;
    MyButton strelec;
    MyButton virtualBox;

    public OS_And_ISOs(){
        win10 = new MyButton();
        win10.addAppCode(8,0);
        win10.addActionListener(this);

        win11 = new MyButton();
        win11.addAppCode(8,1);
        win11.addActionListener(this);

        ubuntu24 = new MyButton();
        ubuntu24.addAppCode(8,2);
        ubuntu24.addActionListener(this);

        mediCat = new MyButton();
        mediCat.addAppCode(8,3);
        mediCat.addActionListener(this);

        strelec = new MyButton();
        strelec.addAppCode(8,4);
        strelec.addActionListener(this);

        virtualBox = new MyButton();
        virtualBox.addAppCode(8,5);
        virtualBox.addActionListener(this);

        buttons[0] = win10;
        buttons[1] = win11;
        buttons[2] = ubuntu24;
        buttons[3] = mediCat;
        buttons[4] = strelec;
        buttons[5] = virtualBox;

        for(MyButton button : buttons){
            this.add(button);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== win10){buttons[0].selectButton();}

        else if(e.getSource()== win11){buttons[1].selectButton();}

        else if(e.getSource()== ubuntu24){buttons[2].selectButton();}

        else if(e.getSource()== mediCat){buttons[3].selectButton();}

        else if(e.getSource()== strelec){buttons[4].selectButton();}

        else if(e.getSource()== virtualBox){buttons[5].selectButton();}
    }
}