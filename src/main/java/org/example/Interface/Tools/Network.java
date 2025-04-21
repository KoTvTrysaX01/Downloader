package org.example.Interface.Tools;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Network extends MyTabs implements ActionListener{

    MyButton anyDesk;
    MyButton rustDesk;
    MyButton supremo;
    MyButton hwMonitoPro;
    MyButton openVPN;
    MyButton wireGuard;
    MyButton hamachi;
    MyButton shadowsocks;
    MyButton xampp;

    public Network(){
        anyDesk = new MyButton();
        anyDesk.addAppCode(7,0);
        anyDesk.addActionListener(this);

        rustDesk = new MyButton();
        rustDesk.addAppCode(7,1);
        rustDesk.addActionListener(this);

        supremo = new MyButton();
        supremo.addAppCode(7,2);
        supremo.addActionListener(this);

        hwMonitoPro = new MyButton();
        hwMonitoPro.addAppCode(7,3);
        hwMonitoPro.addActionListener(this);

        openVPN = new MyButton();
        openVPN.addAppCode(7,4);
        openVPN.addActionListener(this);

        wireGuard = new MyButton();
        wireGuard.addAppCode(7,5);
        wireGuard.addActionListener(this);

        hamachi = new MyButton();
        hamachi.addAppCode(7,6);
        hamachi.addActionListener(this);

        shadowsocks = new MyButton();
        shadowsocks.addAppCode(7,7);
        shadowsocks.addActionListener(this);

        xampp = new MyButton();
        xampp.addAppCode(7,8);
        xampp.addActionListener(this);

        buttons[0] = anyDesk;
        buttons[1] = rustDesk;
        buttons[2] = supremo;
        buttons[3] = hwMonitoPro;
        buttons[4] = openVPN;
        buttons[5] = wireGuard;
        buttons[6] = hamachi;
        buttons[7] = shadowsocks;
        buttons[8] = xampp;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== anyDesk){buttons[0].selectButton();}

        else if(e.getSource()== rustDesk){buttons[1].selectButton();}

        else if(e.getSource()== supremo){buttons[2].selectButton();}

        else if(e.getSource()== hwMonitoPro){buttons[3].selectButton();}

        else if(e.getSource()== openVPN){buttons[4].selectButton();}

        else if(e.getSource()== wireGuard){buttons[5].selectButton();}

        else if(e.getSource()== hamachi){buttons[6].selectButton();}

        else if(e.getSource()== shadowsocks){buttons[7].selectButton();}

        else if(e.getSource()== xampp){buttons[8].selectButton();}
    }
}
