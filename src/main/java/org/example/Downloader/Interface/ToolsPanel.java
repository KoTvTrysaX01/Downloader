package org.example.Downloader.Interface;

import org.example.Downloader.Tools.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class of ToolsPanel that contains tabs with tool apps.
 */
public class ToolsPanel extends JTabbedPane {

    MyTabs overview = new Overview();
    MyTabs tests = new Tests();
    MyTabs disc = new Disk();
    MyTabs network = new Network();
    MyTabs protection = new Protection();
    MyTabs os_and_isos = new OS_And_ISOs();


    /**
     * Construct an object of ToolsPanel with overview, tests, disc, network, protection and OS&ISOs tabs
     */
    public ToolsPanel(){
        this.setBounds(340, 75, 1034, 775);
        this.setBackground(new Color(0, 166, 39));
        this.setForeground(Color.WHITE);
        this.setVisible(false);

        this.addTab("Overview", overview);
        this.addTab("Tests", tests);
        this.addTab("Disc", disc);
        this.addTab("Network", network);
        this.addTab("Protection", protection);
        this.addTab("OS & ISOs", os_and_isos);
    }
}
