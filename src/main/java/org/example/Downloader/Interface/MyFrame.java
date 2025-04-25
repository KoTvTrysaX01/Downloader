package org.example.Downloader.Interface;

import org.example.Downloader.Functions.Connection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static org.example.Downloader.Functions.Main.countSelectedApps;

/**
 * Class of MyFrame that is the main class of the program interface. Contains all main components of the interface.
 */
public class MyFrame extends JFrame implements Runnable {

    Thread threadTryConnect;
    public static MyTabs[] categories = new MyTabs[13];

    AppsPanel appPanel = new AppsPanel();
    ToolsPanel toolsPanel = new ToolsPanel();
    OthersPanel othersPanel = new OthersPanel();

    public static ProfilesPanel profilesPanel = new ProfilesPanel();


    public static DownloadPanel downloadPanel = new DownloadPanel();

    LeftPanel leftPanel = new LeftPanel();
//    public static RightPanel rightPanel = new RightPanel();
    public static TopPanel topPanel = new TopPanel();
    static ConsolePanel consolePanel = new ConsolePanel();

    /**
     * Constructs an object of MyFrame with visual components such as
     * top panel with basic program information and a button that checks connection,
     * left panel with buttons that help navigate inside the program,
     * 5 main pages of AppsPanel, ToolsPanel, OthersPanel, ProfilesPanel and DownloadPanel
     * and console panel with selected apps counter and dynamic text console.
     * Also has an array that stores all tabs with buttons.
     * @throws IOException when something goes wrong.
     */
    public MyFrame() throws IOException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 900);
        this.setTitle("Downloader");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(207, 255, 220));


        topPanel.check_connection.addActionListener(e -> {
            threadTryConnect = new Thread(this);
            threadTryConnect.start();
        });

        leftPanel.button_apps.addActionListener(e -> {
            appPanel.setVisible(true);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        });

        leftPanel.button_tools.addActionListener(e -> {
            appPanel.setVisible(false);
            toolsPanel.setVisible(true);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        });

        leftPanel.button_others.addActionListener(e -> {
            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(true);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        });

        leftPanel.button_profiles.addActionListener(e -> {
            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(true);
            downloadPanel.setVisible(false);
        });

        leftPanel.button_download.addActionListener(e -> {
            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(true);

            downloadPanel.updateAppPanel();
        });



        categories[0] = appPanel.browsers;
        categories[1] = appPanel.launchers;
        categories[2] = appPanel.media;
        categories[3] = appPanel.programming;
        categories[4] = appPanel.communication;
        categories[5] = toolsPanel.overview;
        categories[6] = toolsPanel.tests;
        categories[7] = toolsPanel.disc;
        categories[8] = toolsPanel.network;
        categories[9] = toolsPanel.protection;
        categories[10] = toolsPanel.os_and_isos;
        categories[11] = othersPanel.otherApps;
        categories[12] = othersPanel.myFiles;

        this.add(topPanel);
        this.add(leftPanel);
        this.add(appPanel);
        this.add(toolsPanel);
        this.add(othersPanel);
        this.add(profilesPanel);
        this.add(downloadPanel);
//        this.add(rightPanel);
        this.add(consolePanel);
        this.setVisible(true);

    }

    /**
     * Update the app counter with current number of selected apps.
     */
    public static void updateAppCounter(){
        ConsolePanel.selected_apps_count.setText("Downloading apps: " + countSelectedApps());
    }

    /**
     * Appends new messages to the console.
     * @param message from any other class that reports about something.
     */
    public static void consoleMessage(String message){
        consolePanel.console.append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " - " + message +"\n");
    }

    /**
     * Starts new thread for check connection button and allows to navigate inside the program during the process.
     */
    @Override
    public void run() {
        new Connection().checkConnection();
    }
}
