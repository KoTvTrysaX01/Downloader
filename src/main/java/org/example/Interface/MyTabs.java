package org.example.Interface;

import javax.swing.*;
import java.awt.*;

public class MyTabs extends JPanel {

    public MyButton[] buttons = new MyButton[]{
            new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(),
            new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(),
            new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(),
            new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(),
            new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(), new MyButton(),
    };

    public MyTabs(){
        this.setLayout(new GridLayout(5, 6, 50, 55));
        this.setBounds(340, 95, 1034, 755);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(new Color(46, 111, 64));
        for(JButton button : buttons){
            button.setVisible(false);
        }
    }


}
