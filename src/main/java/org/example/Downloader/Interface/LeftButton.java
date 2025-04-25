package org.example.Downloader.Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Class of LeftButton that contains object of LeftButton and is used in the LeftPanel class
 */
public class LeftButton extends JButton {

    /**
     * Constructs an object of LeftButton with visual modifications.
     */
    LeftButton(String name){
        this.setText(name);
        this.setBackground(new Color(105, 186, 128));
        this.setForeground(new Color(250, 240, 241));
        this.setFont(new Font("Inter Black", Font.PLAIN, 32));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalAlignment(0);
        this.setVerticalAlignment(0);
        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
