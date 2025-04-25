package org.example.Downloader.Interface;

import org.example.Downloader.Others.MyFiles;
import org.example.Downloader.Others.OtherApps;

import javax.swing.*;
import java.awt.*;


/**
 * Class of OthersPanel that contains tabs with common apps.
 */
public class OthersPanel extends JTabbedPane {

    MyTabs otherApps = new OtherApps();
    MyTabs myFiles = new MyFiles();

    /**
     * Construct an object of OthersPanel with otherApps and myFiles tabs
     */
    public OthersPanel(){

        this.setBounds(340, 75, 1034, 775);
        this.setBackground(new Color(0, 166, 39));
        this.setForeground(Color.WHITE);
        this.setVisible(false);

        this.add("Other Apps", otherApps);
        this.add("My Files", myFiles);

    }
}
