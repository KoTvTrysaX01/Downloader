package org.example.Interface;

import org.example.Interface.Apps.*;
import org.example.Interface.Other.Files;
import org.example.Interface.Other.OtherApps;
import org.example.Interface.Tools.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.example.Interface.Main.countSelectedApps;


public class MyFrame extends JFrame implements ActionListener, Runnable {
    LeftButton button_apps;
    LeftButton button_tools;
    LeftButton button_others;
    LeftButton button_profiles;
    LeftButton button_download;

    JTabbedPane appPanel;
    JTabbedPane toolsPanel;
    JTabbedPane othersPanel;

    JButton try_connect;
    static JLabel image_connection;

    static MyTabs[] categories = new MyTabs[13];


    public static JPanel profilesPanel;
    public static Download downloadPanel;

    static JLabel downloading_apps;

    JScrollPane console;
    public static JTextArea console_area;

    Thread threadTryConnect;

    public class LeftButton extends JButton{
        public LeftButton(String name){
            this.setText(name);
            this.setBackground(new Color(105, 186, 128));
            this.setForeground(new Color(250, 240, 241));
            this.setFont(new Font("Inter Black", Font.PLAIN, 32));
            this.setHorizontalTextPosition(SwingConstants.CENTER);
            this.setVerticalTextPosition(SwingConstants.CENTER);
            this.setHorizontalAlignment(0);
            this.setVerticalAlignment(0);

        }
    }

    MyFrame() throws IOException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 900);
        this.setTitle("Downloader");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(207, 255, 220));

        JPanel topPanel = new JPanel();
        topPanel.setBounds(10, 10, 1364, 60);
        topPanel.setBackground(new Color(104, 186, 127));
        topPanel.setLayout(null);

        JLabel name = new JLabel("DOWNLOADER");
        name.setBounds(10, 5, 290, 50);
        name.setBackground(new Color(37, 60, 44));
        name.setForeground(Color.WHITE);
        name.setOpaque(true);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Arial", Font.PLAIN, 30));


        JLabel madeby = new JLabel("VADIM ELSHIN | DAW 1 | IES DOCTOR BALMIS");
        madeby.setBounds(310, 5, 700, 50);
        madeby.setBackground(new Color(110, 253, 112));
        madeby.setForeground(Color.BLACK);
        madeby.setOpaque(true);
        madeby.setVerticalAlignment(JLabel.CENTER);
        madeby.setHorizontalAlignment(JLabel.CENTER);
        madeby.setFont(new Font("Arial", Font.PLAIN, 30));

        try_connect = new JButton("Check Connection: ");
        try_connect.setBounds(1020, 5, 250, 50);
        try_connect.setFont(new Font("Arial", Font.PLAIN, 24));
        try_connect.setBackground(new Color(47, 111, 65));
        try_connect.setForeground(Color.WHITE);
        try_connect.addActionListener(this);

        image_connection = new JLabel(Main.resizeIcon("src/Icons/neutral.png", 55));
        image_connection.setBounds(1290, 0, 60, 60);
        image_connection.setOpaque(false);

        topPanel.add(name);
        topPanel.add(madeby);
        topPanel.add(try_connect);
        topPanel.add(image_connection);




        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(10, 90, 280, 400);
        leftPanel.setBackground(new Color(47, 111, 65));
        leftPanel.setLayout(new GridLayout(5, 1, 25, 15));
        leftPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        button_apps = new LeftButton("APPS");
        button_apps.addActionListener(this);


        button_tools = new LeftButton("TOOLS");
        button_tools.addActionListener(this);


        button_others = new LeftButton("OTHER APPS");
        button_others.addActionListener(this);

        button_profiles = new LeftButton("PROFILES");
        button_profiles.addActionListener(this);

        button_download = new LeftButton("DOWNLOAD");
        button_download.addActionListener(this);


        leftPanel.add(button_apps);
        leftPanel.add(button_tools);
        leftPanel.add(button_others);
        leftPanel.add(button_profiles);
        leftPanel.add(button_download);


        appPanel = new MyTabbedPane();
        appPanel.setBackground(new Color(145, 193, 113));
        MyTabs browsers = new Browsers();
        MyTabs launchers = new Launchers();
        MyTabs media = new Media();
        MyTabs programming = new Programming();
        MyTabs communication = new Communication();
        appPanel.addTab("Browsers", browsers);
        appPanel.addTab("Launchers", launchers);
        appPanel.addTab("Media", media);
        appPanel.addTab("Programming", programming);
        appPanel.addTab("Communication", communication);


        toolsPanel = new MyTabbedPane();
        MyTabs overview = new Overview();
        MyTabs tests = new Tests();
        MyTabs disc = new Disk();
        MyTabs network = new Network();
        MyTabs protection = new Protection();
        MyTabs os_and_isos = new OS_And_ISOs();
        toolsPanel.addTab("Overview", overview);
        toolsPanel.addTab("Tests", tests);
        toolsPanel.addTab("Disc", disc);
        toolsPanel.addTab("Network", network);
        toolsPanel.addTab("Protection", protection);
        toolsPanel.addTab("OS & ISOs", os_and_isos);


        othersPanel = new MyTabbedPane();
        MyTabs otherAppsPanel = new OtherApps();
        MyTabs myFilesPanel = new Files();
        othersPanel.add("Apps", otherAppsPanel);
        othersPanel.add("My Files", myFilesPanel);



        downloadPanel = new Download();


        JPanel download_info = new JPanel(new GridLayout());
        downloading_apps = new JLabel("Downloading apps: " + countSelectedApps());
        downloading_apps.setVerticalAlignment(JLabel.CENTER);
        downloading_apps.setHorizontalAlignment(JLabel.CENTER);
        downloading_apps.setForeground(Color.WHITE);
        downloading_apps.setFont(new Font("Inter Black", Font.PLAIN, 24));
        download_info.setBounds(10,490,280, 50);
        download_info.setBackground(new Color(37, 60, 44));
        download_info.add(downloading_apps);


        console_area = new JTextArea();
        console = new JScrollPane(console_area);


        console.setBounds(10, 560, 280, 290);
        console_area.setEditable(false);
        console_area.setBackground(new Color(37, 61, 44));
        console_area.setForeground(Color.WHITE);
        console.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        profilesPanel = new ProfilesPanel();

        categories[0] = browsers;
        categories[1] = launchers;
        categories[2] = media;
        categories[3] = programming;
        categories[4] = communication;
        categories[5] = overview;
        categories[6] = tests;
        categories[7] = disc;
        categories[8] = network;
        categories[9] = protection;
        categories[10] = os_and_isos;
        categories[11] = otherAppsPanel;
        categories[12] = myFilesPanel;

        this.add(topPanel);
        this.add(leftPanel);
        this.add(appPanel);
        this.add(toolsPanel);
        this.add(othersPanel);
        this.add(profilesPanel);
        this.add(console);
        this.add(downloadPanel);
        this.add(download_info);
        this.setVisible(true);

    }

    public static void addAppCont(){
        downloading_apps.setText("Downloading apps: " + countSelectedApps());
    }

    public static void consoleMessage(String message){
        console_area.append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " - " + message +"\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == try_connect){
            threadTryConnect = new Thread(this);
            threadTryConnect.start();
        }

       else if(e.getSource()== button_apps){
            appPanel.setVisible(true);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        }

        else if(e.getSource()== button_tools){
            appPanel.setVisible(false);
            toolsPanel.setVisible(true);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        }

        else if(e.getSource()== button_others){
            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(true);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(false);
        }


        else if(e.getSource()== button_profiles){
            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(true);
            downloadPanel.setVisible(false);
        }

        else if(e.getSource() == button_download){

            appPanel.setVisible(false);
            toolsPanel.setVisible(false);
            othersPanel.setVisible(false);
            profilesPanel.setVisible(false);
            downloadPanel.setVisible(true);

            downloadPanel.updateAppPanel();
        }
    }



    @Override
    public void run() {
        new Connection().checkConnection();
    }
}
