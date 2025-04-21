package org.example.Interface.Other;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherApps extends MyTabs implements ActionListener{

    MyButton autoFirma;
    MyButton conf_fmnt;
    MyButton inst_dnie;
    MyButton rufus;
    MyButton kms;
    MyButton launchj4;
    MyButton r2modman;
    MyButton iconViewer;
    MyButton vencord;
    MyButton wordpress;

    public OtherApps(){

        autoFirma = new MyButton();
        autoFirma.addAppCode(11, 0);
        autoFirma.addActionListener(this);

        conf_fmnt = new MyButton();
        conf_fmnt.addAppCode(11, 1);
        conf_fmnt.addActionListener(this);

        inst_dnie = new MyButton();
        inst_dnie.addAppCode(11, 2);
        inst_dnie.addActionListener(this);

        rufus = new MyButton();
        rufus.addAppCode(11, 3);
        rufus.addActionListener(this);

        kms = new MyButton();
        kms.addAppCode(11, 4);
        kms.addActionListener(this);

        launchj4 = new MyButton();
        launchj4.addAppCode(11, 5);
        launchj4.addActionListener(this);

        r2modman = new MyButton();
        r2modman.addAppCode(11, 6);
        r2modman.addActionListener(this);

        iconViewer = new MyButton();
        iconViewer.addAppCode(11, 7);
        iconViewer.addActionListener(this);

        vencord = new MyButton();
        vencord.addAppCode(11, 8);
        vencord.addActionListener(this);

        wordpress = new MyButton();
        wordpress.addAppCode(11, 9);
        wordpress.addActionListener(this);

        buttons[0] = autoFirma;
        buttons[1] = conf_fmnt;
        buttons[2] = inst_dnie;
        buttons[3] = rufus;
        buttons[4] = kms;
        buttons[5] = launchj4;
        buttons[6] = r2modman;
        buttons[7] = iconViewer;
        buttons[8] = vencord;
        buttons[9] = wordpress;

        for(MyButton button : buttons){
            this.add(button);
        }
        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== autoFirma){buttons[0].selectButton();}

        else if(e.getSource()== conf_fmnt){buttons[1].selectButton();}

        else if(e.getSource()== inst_dnie){buttons[2].selectButton();}

        else if(e.getSource()== rufus){buttons[3].selectButton();}

        else if(e.getSource()== kms){buttons[4].selectButton();}

        else if(e.getSource()== launchj4){buttons[5].selectButton();}

        else if(e.getSource()== r2modman){buttons[6].selectButton();}

        else if(e.getSource()== iconViewer){buttons[7].selectButton();}

        else if(e.getSource()== vencord){buttons[8].selectButton();}

        else if(e.getSource()== wordpress){buttons[9].selectButton();}
    }
}
