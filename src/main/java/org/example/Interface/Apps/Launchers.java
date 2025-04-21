package org.example.Interface.Apps;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launchers extends MyTabs implements ActionListener {

    MyButton steam;
    MyButton egs;
    MyButton ubisoft;
    MyButton gog;
    MyButton rockstar;
    MyButton ea;
    MyButton battlenet;
    MyButton lol;
    MyButton tlauncher;
    MyButton nvidia;
    MyButton amd;

    public Launchers(){

        steam = new MyButton();
        steam.addAppCode(1,0);
        steam.addActionListener(this);

        egs = new MyButton();
        egs.addAppCode(1,1);
        egs.addActionListener(this);

        ubisoft = new MyButton();
        ubisoft.addAppCode(1,2);
        ubisoft.addActionListener(this);

        gog = new MyButton();
        gog.addAppCode(1,3);
        gog.addActionListener(this);

        rockstar = new MyButton();
        rockstar.addAppCode(1,4);
        rockstar.addActionListener(this);

        ea = new MyButton();
        ea.addAppCode(1,5);
        ea.addActionListener(this);

        battlenet = new MyButton();
        battlenet.addAppCode(1,6);
        battlenet.addActionListener(this);

        lol = new MyButton();
        lol.addAppCode(1,7);
        lol.addActionListener(this);

        tlauncher = new MyButton();
        tlauncher.addAppCode(1,8);
        tlauncher.addActionListener(this);

        nvidia = new MyButton();
        nvidia.addAppCode(1,9);
        nvidia.addActionListener(this);

        amd = new MyButton();
        amd.addAppCode(1,10);
        amd.addActionListener(this);

        buttons[0] = steam;
        buttons[1] = egs;
        buttons[2] = ubisoft;
        buttons[3] = gog;
        buttons[4] = rockstar;
        buttons[5] = ea;
        buttons[6] = battlenet;
        buttons[7] = lol;
        buttons[8] = tlauncher;
        buttons[9] = nvidia;
        buttons[10] = amd;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== steam){buttons[0].selectButton();}

        else if(e.getSource()== egs){buttons[1].selectButton();}

        else if(e.getSource()== ubisoft){buttons[2].selectButton();}

        else if(e.getSource()== gog){buttons[3].selectButton();}

        else if(e.getSource()== rockstar){buttons[4].selectButton();}

        else if(e.getSource()== ea){buttons[5].selectButton();}

        else if(e.getSource()== battlenet){buttons[6].selectButton();}

        else if(e.getSource()== lol){buttons[7].selectButton();}

        else if(e.getSource()== tlauncher){buttons[8].selectButton();}

        else if(e.getSource()== nvidia){buttons[9].selectButton();}

        else if(e.getSource()== amd){buttons[10].selectButton();}
    }
}
