package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disk extends MyTabs implements ActionListener{

    MyButton crystalDiskInfo;
    MyButton crystalDiskMark;
    MyButton aomeiBackUpper;
    MyButton diskGenius;
    MyButton dashboardSandisk;
    MyButton wddLifeguard;
    MyButton hdclone;

    public Disk(){
        crystalDiskInfo = new MyButton();
        crystalDiskInfo.addAppCode(9,0);
        crystalDiskInfo.addActionListener(this);

        crystalDiskMark = new MyButton();
        crystalDiskMark.addAppCode(9,1);
        crystalDiskMark.addActionListener(this);

        aomeiBackUpper = new MyButton();
        aomeiBackUpper.addAppCode(9,2);
        aomeiBackUpper.addActionListener(this);

        diskGenius = new MyButton();
        diskGenius.addAppCode(9,3);
        diskGenius.addActionListener(this);

        dashboardSandisk = new MyButton();
        dashboardSandisk.addAppCode(9,4);
        dashboardSandisk.addActionListener(this);

        wddLifeguard = new MyButton();
        wddLifeguard.addAppCode(9,5);
        wddLifeguard.addActionListener(this);

        hdclone = new MyButton();
        hdclone.addAppCode(9,6);
        hdclone.addActionListener(this);

        buttons[0] = crystalDiskInfo;
        buttons[1] = crystalDiskMark;
        buttons[2] = aomeiBackUpper;
        buttons[3] = diskGenius;
        buttons[4] = dashboardSandisk;
        buttons[5] = wddLifeguard;
        buttons[6] = hdclone;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== crystalDiskInfo){buttons[0].selectButton();}

        else if(e.getSource()== crystalDiskMark){buttons[1].selectButton();}

        else if(e.getSource()== aomeiBackUpper){buttons[2].selectButton();}

        else if(e.getSource()== diskGenius){buttons[3].selectButton();}

        else if(e.getSource()== dashboardSandisk){buttons[4].selectButton();}

        else if(e.getSource()== wddLifeguard){buttons[5].selectButton();}

        else if(e.getSource()== hdclone){buttons[6].selectButton();}
    }
}
