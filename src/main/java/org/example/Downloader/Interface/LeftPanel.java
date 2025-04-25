package org.example.Downloader.Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class of LeftPanel that is responsible for Left Panel component of the interface.
 */
public class LeftPanel extends JPanel{


    public LeftButton button_apps = new LeftButton("APPS");
    public LeftButton button_tools = new LeftButton("TOOLS");
    public LeftButton button_others = new LeftButton("OTHER APPS");
    public LeftButton button_profiles = new LeftButton("PROFILES");
    public LeftButton button_download = new LeftButton("DOWNLOAD");

    /**
     * Construct an object of LeftPanel that contains 5 buttons of all main pages.
     */
    public LeftPanel(){
        this.setBounds(10, 90, 280, 400);
        this.setBackground(new Color(47, 111, 65));
        this.setLayout(new GridLayout(5, 1, 25, 15));
        this.setBorder(new EmptyBorder(10, 20, 10, 20));

        this.add(button_apps);
        this.add(button_tools);
        this.add(button_others);
        this.add(button_profiles);
        this.add(button_download);
    }

}
