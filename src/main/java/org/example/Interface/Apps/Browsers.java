package org.example.Interface.Apps;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Browsers extends MyTabs implements ActionListener {

    MyButton opera;
    MyButton chrome;
    MyButton firefox;
    MyButton yandexBR;
    MyButton operaGX;
    MyButton brave;

    public Browsers(){
        opera = new MyButton();
        opera.addAppCode(0,0);
        opera.addActionListener(this);

        chrome = new MyButton();
        chrome.addAppCode(0,1);
        chrome.addActionListener(this);

        firefox = new MyButton();
        firefox.addAppCode(0,2);
        firefox.addActionListener(this);

        yandexBR = new MyButton();
        yandexBR.addAppCode(0,3);
        yandexBR.addActionListener(this);

        operaGX = new MyButton();
        operaGX.addAppCode(0,4);
        operaGX.addActionListener(this);

        brave = new MyButton();
        brave.addAppCode(0,5);
        brave.addActionListener(this);

        buttons[0] = opera;
        buttons[1] = chrome;
        buttons[2] = firefox;
        buttons[3] = yandexBR;
        buttons[4] = operaGX;
        buttons[5] = brave;

        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== opera){buttons[0].selectButton();}

        else if(e.getSource()== chrome){buttons[1].selectButton();}

        else if(e.getSource()== firefox){buttons[2].selectButton();}

        else if(e.getSource()== yandexBR){buttons[3].selectButton();}

        else if(e.getSource()== operaGX){buttons[4].selectButton();}

        else if(e.getSource()== brave){buttons[5].selectButton();}
    }
}