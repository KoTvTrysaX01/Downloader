package org.example.Interface;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public AppToDownload appToDownload;
    public String app_name ;
    public String file_name;

    public MyButton(){
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setLayout(null);
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
    }

    public void addAppCode(int row, int col){

        this.appToDownload = new AppToDownload(
                Main.apps_names[row][col],
                Main.files_names[row][col],
                Main.files_icons[row][col],
                Main.files_command[row][col]
        );

        this.app_name = Main.apps_names[row][col];
        this.setText(app_name);
        this.file_name = Main.files_names[row][col];
        this.setIcon(Main.resizeIcon(Main.files_icons[row][col], 65));

    }

    public void selectButton(){
        if(this.getBackground() == Color.green){
            Main.removeApp(appToDownload);
            this.setBackground(null);
            MyFrame.addAppCont();
        }
        else{
            this.setBackground(Color.green);
            Main.addApp(appToDownload);
            MyFrame.addAppCont();
        }
    }
}
