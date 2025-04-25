package org.example.Downloader.Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class of MyTabs that contains objects of AppButton. Is a page that shows apps of a specific type.
 */
public class MyTabs extends JPanel{

    public AppButton[] buttons = new AppButton[]{
            new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(),
            new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(),
            new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(),
            new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(),
            new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(), new AppButton(),
    };

    /**
     * Constructs an object of MyTabs with visual modifications and an array of 30 objects of AppButton.
     */
    public MyTabs(){
        this.setLayout(new GridLayout(5, 6, 25, 40));
        this.setBounds(340, 95, 1034, 755);
        this.setBorder(BorderFactory.createLineBorder(new Color(3, 64, 0)));
        this.setBackground(new Color(105, 186, 128));
        for(JButton button : buttons){
            button.setVisible(false);
        }
        this.setBorder(new EmptyBorder(14,14,14,14));
    }
}
