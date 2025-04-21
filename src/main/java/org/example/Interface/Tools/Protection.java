package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Protection extends MyTabs implements ActionListener{

    MyButton defenderUI;
    MyButton eset;
    MyButton malwareBytes;


    public Protection(){

        defenderUI = new MyButton();
        defenderUI.addAppCode(10,0);
        defenderUI.addActionListener(this);

        eset = new MyButton();
        eset.addAppCode(10,1);
        eset.addActionListener(this);

        malwareBytes = new MyButton();
        malwareBytes.addAppCode(10,2);
        malwareBytes.addActionListener(this);

        buttons[0] = defenderUI;
        buttons[1] = eset;
        buttons[2] = malwareBytes;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== defenderUI){buttons[0].selectButton();}

        else if(e.getSource()== eset){buttons[1].selectButton();}

        else if(e.getSource()== malwareBytes){buttons[2].selectButton();}
    }
}
