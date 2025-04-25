package org.example.Downloader.Interface;

import org.example.Downloader.Functions.AppToDownload;
import org.example.Downloader.Functions.Main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

/**
 * Class of AppButton that contains object of AppToDownload and is used in the MyTabs class.
 */
public class AppButton extends JButton {

    public AppToDownload appToDownload;
    public String app_name;

    /**
     * Constructs an object of AppButton with visual modifications.
     */
    public AppButton(){
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setLayout(null);
//        this.setFocusPainted(false);
//        this.setContentAreaFilled(false);
        this.setFocusable(false);

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Adds data to variable appToDownload using positions of Main database.
     * @param row row position in the database.
     * @param col col position in the database.
     */
    public void addAppCode(int row, int col){

        this.appToDownload = new AppToDownload(
                Main.apps_names[row][col],
                Main.files_names[row][col],
                Main.files_icons[row][col],
                Main.files_command[row][col]
        );

        this.app_name = Main.apps_names[row][col];
        this.setText(app_name);
        this.setIcon(Main.resizeIcon(Main.files_icons[row][col], 65));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 110, 16), 2));

    }

    /**
     * Changes border of the button and adds it's appToDownload to the Main list of selected apps.
     * If the button was already selected than it cancels the action.
     */
    public void selectButton(){
        if(Objects.equals(((LineBorder) this.getBorder()).getLineColor(), new Color(245, 71, 59))){
            Main.removeApp(appToDownload);
            this.setBorder(BorderFactory.createLineBorder(new Color(0, 110, 16), 2));
            MyFrame.updateAppCounter();
        }
        else{
            this.setBorder(BorderFactory.createLineBorder(new Color(245, 71, 59), 4));
            Main.addApp(appToDownload);
            MyFrame.updateAppCounter();
        }
    }

    /**
     * Is used to add a gradient layer to the button's background.
     * @param g An object of Graphics class that belongs to the button.
     */
//    protected void paintComponent(Graphics g){
//        final Graphics2D g2 = (Graphics2D) g.create();
//        g2.setPaint(new GradientPaint(
//                new Point(0, getHeight() + 40), new Color(102, 255, 179),
//                new Point(getWidth() - 40, 0), new Color(231, 247, 111)));
//        g2.fillRect(0, 0, getWidth(), getHeight());
//        g2.dispose();
//
//        super.paintComponent(g);
//    }
}
