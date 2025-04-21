package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Overview extends MyTabs implements ActionListener{

    MyButton cpu_z;
    MyButton ccleaner;
    MyButton speccy;
    MyButton bat_mon;
    MyButton wumgr;
    MyButton revo;
    MyButton hwinfo;

    public Overview(){
        cpu_z = new MyButton();
        cpu_z.addAppCode(5,0);
        cpu_z.addActionListener(this);

        ccleaner = new MyButton();
        ccleaner.addAppCode(5,1);
        ccleaner.addActionListener(this);

        speccy = new MyButton();
        speccy.addAppCode(5,2);
        speccy.addActionListener(this);

        bat_mon = new MyButton();
        bat_mon.addAppCode(5,3);
        bat_mon.addActionListener(this);

        wumgr = new MyButton();
        wumgr.addAppCode(5,4);
        wumgr.addActionListener(this);

        revo = new MyButton();
        revo.addAppCode(5,5);
        revo.addActionListener(this);

        hwinfo = new MyButton();
        hwinfo.addAppCode(5,6);
        hwinfo.addActionListener(this);

        buttons[0] = cpu_z;
        buttons[1] = ccleaner;
        buttons[2] = speccy;
        buttons[3] = bat_mon;
        buttons[4] = wumgr;
        buttons[5] = revo;
        buttons[6] = hwinfo;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== cpu_z){buttons[0].selectButton();}

        else if(e.getSource()== ccleaner){buttons[1].selectButton();}

        else if(e.getSource()== speccy){buttons[2].selectButton();}

        else if(e.getSource()== bat_mon){buttons[3].selectButton();}

        else if(e.getSource()== wumgr){buttons[4].selectButton();}

        else if(e.getSource()== revo){buttons[5].selectButton();}

        else if(e.getSource()== hwinfo){buttons[6].selectButton();}
    }
}
