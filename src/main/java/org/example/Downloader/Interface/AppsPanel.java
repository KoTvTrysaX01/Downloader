package org.example.Downloader.Interface;

import org.example.Downloader.Apps.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class of AppsPanel that contains tabs with common apps.
 */
public class AppsPanel extends JTabbedPane {

    MyTabs browsers = new Browsers();
    MyTabs launchers = new Launchers();
    MyTabs media = new Media();
    MyTabs programming = new Programming();
    MyTabs communication = new Communication();

    /**
     * Construct an object of AppsPanel with browsers, launchers, media, programming and communication tabs.
     */
    public AppsPanel(){
        this.setBounds(340, 75, 1034, 775);
        this.setBackground(new Color(0, 166, 39));
        this.setForeground(Color.WHITE);
        this.setVisible(false);

        this.addTab("Browsers", browsers);
        this.addTab("Launchers", launchers);
        this.addTab("Media", media);
        this.addTab("Programming", programming);
        this.addTab("Communication", communication);
    }


}
