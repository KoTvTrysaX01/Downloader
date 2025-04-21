package org.example.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Interface.Main.desactivateButtons;
import static org.example.Interface.MyFrame.consoleMessage;


public class Download extends JPanel implements ActionListener, Runnable {


    public JPanel apps_panel = new JPanel();
    JButton show_apps;
    JPanel info_panel;
    public JButton download_b;
    JButton clear_b;

    public JProgressBar progressBar;
    public JTextField text_progress;

    JButton browse_b;
    JTextField dir;
    JTextField autoInstallText;

    static JCheckBox autoInstall;

    Thread threadDownload;


    Download() {
        this.setBounds(340, 95, 1034, 755);
        this.setBackground(new Color(47, 111, 65));
        this.setForeground(Color.white);
        this.setLayout(null);

        show_apps = new JButton("Show apps");
        show_apps.setBounds(15, 30, 120, 40);
        show_apps.addActionListener(this);

        clear_b = new JButton("Clear all");
        clear_b.setBounds(15, 100, 120, 40);
        clear_b.addActionListener(this);

        apps_panel = new JPanel();
        apps_panel.setBounds(150, 15, 829, 140);
        apps_panel.setBackground(Color.white);
        apps_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 3));

        info_panel = new JPanel();
        info_panel.setLayout(null);
        info_panel.setBackground(new Color(105, 186, 128));
        info_panel.setBounds(20, 20, 994, 170);
        info_panel.add(show_apps);
        info_panel.add(apps_panel);
        info_panel.add(clear_b);



        download_b = new JButton("DOWNLOAD");
        download_b.setBounds(362, 650, 300, 70);
        download_b.addActionListener(this);

        progressBar = new JProgressBar();
        progressBar.setBounds(40, 450, 954, 70);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);

        text_progress = new JTextField("Downloading: ");
        text_progress.setBounds(317, 540, 400, 50);
        text_progress.setFont(new Font("Inter Black", Font.PLAIN, 20));
        text_progress.setHorizontalAlignment(0);
        text_progress.setEditable(false);


        browse_b = new JButton("Browse");
        browse_b.setBounds(20, 250, 150, 50);
        browse_b.addActionListener(this);

        dir = new JTextField();
        dir.setBounds(180, 250, 834, 50);
        dir.setEditable(false);
        dir.setFont(new Font("Inter Black", Font.PLAIN, 20));
        dir.setVisible(true);

        autoInstallText = new JTextField("Install apps automatically.");
        autoInstallText.setBounds(20, 320, 250, 30);
        autoInstallText.setFont(new Font("Inter Black", Font.PLAIN, 20));
        autoInstallText.setHorizontalAlignment(0);
        autoInstallText.setEditable(false);


        autoInstall = new JCheckBox();
        autoInstall.setBounds(280, 320, 30, 30);
        autoInstall.setIcon(new ImageIcon(""));
        autoInstall.setSelectedIcon(Main.resizeIcon("src/Icons/Red_X.png", 25));


        this.add(download_b);
        this.add(info_panel);
        this.add(progressBar);
        this.add(text_progress);
        this.add(browse_b);
        this.add(dir);
        this.add(autoInstallText);
        this.add(autoInstall);

        this.setVisible(false);
    }

    public void updateAppPanel(){
        for (Component c : apps_panel.getComponents()) {
            apps_panel.remove(c);
        }
        for (AppToDownload app : Main.selectedApps) {
            if (app != null) {
                JLabel label = new JLabel();
                label.setIcon(Main.resizeIcon(app.icon, 25));
                apps_panel.add(label);
            }
        }
        apps_panel.setVisible(false);
        apps_panel.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show_apps) {
            updateAppPanel();
        }
        else if (e.getSource() == download_b) {
            if(Main.countSelectedApps() == 0){
                consoleMessage("You must select at least 1 app.");
            }
            else if (dir.getText() == "Select a path to save" || dir.getText() == ""){
                consoleMessage("You must select destiny folder.");
            }
            else{
                threadDownload = new Thread(this);
                threadDownload.start();
                download_b.setEnabled(false);

                //workerDownload.execute();
            }
        }
        else if (e.getSource() == browse_b) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                dir.setText(String.valueOf(chooser.getSelectedFile()));
            }
            else {
                consoleMessage("The destiny folder wasn't selected.");
            }
        }
        else if (e.getSource() == clear_b){
            Main.selectedApps.clear();
            MyFrame.addAppCont();
            desactivateButtons();
            updateAppPanel();
        }
    }

//    SwingWorker<Boolean, Void> workerDownload = new SwingWorker<>() {
//
//        @Override
//        protected Boolean doInBackground() {
//            new Connection().tryConnect(Main.selectedApps, dir.getText());
//            return true;
//        }
//
//        @Override
//        protected void done() {
//            System.out.println("We are done");
//            download_b.setEnabled(true);
//        }
//    };

    @Override
    public void run() {
        new Connection().tryConnect(Main.selectedApps, dir.getText());
    }
}