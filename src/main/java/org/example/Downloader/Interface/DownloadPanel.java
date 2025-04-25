/**
 *  Contains classes that provide main visual components of the interface.
 */
package org.example.Downloader.Interface;

import org.example.Downloader.Functions.AppToDownload;
import org.example.Downloader.Functions.Connection;
import org.example.Downloader.Functions.Main;

import javax.swing.*;
import java.awt.*;

import static org.example.Downloader.Interface.MyFrame.consoleMessage;
import static org.example.Downloader.Functions.Main.desactivateButtons;

/**
 * Class of ConsolePanel that is responsible for choosing destiny folder and downloading the apps.
 */
public class DownloadPanel extends JPanel implements Runnable{

    JPanel info_panel = new JPanel();
    public JPanel apps_panel = new JPanel();
    JButton clear_b = new JButton("Clear all");

    JButton browse_b = new JButton("Browse");
    JTextField destiny_folder = new JTextField();

    JTextField auto_install_text = new JTextField("Install apps automatically");
    public static JCheckBox autoInstall = new JCheckBox();

    public JProgressBar progressBar = new JProgressBar();
    public JTextField text_progress = new JTextField("Downloading: ");
    public JButton download_b = new JButton("DOWNLOAD");

    Thread threadDownload;

    /**
     * Constructs an object of DownloadPanel with
     * visual information about selected apps and option to clear and install them,
     * current destiny folder and option to select it,
     * progress bar of the downloading process and the button that start it.
     */
    public DownloadPanel(){
        this.setBounds(340, 95, 1034, 755);
        this.setBackground(new Color(47, 111, 65));
        this.setForeground(Color.white);
        this.setLayout(null);

        info_panel.setLayout(null);
        info_panel.setBackground(new Color(105, 186, 128));
        info_panel.setBounds(20, 20, 994, 170);
        info_panel.add(apps_panel);
        info_panel.add(clear_b);

        clear_b.setBounds(15, 55, 120, 60);
        clear_b.addActionListener(e -> {
            Main.selectedApps.clear();
            MyFrame.updateAppCounter();
            desactivateButtons();
            updateAppPanel();
        });

        apps_panel.setBounds(150, 15, 829, 140);
        apps_panel.setBackground(Color.white);
        apps_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 3));


        destiny_folder.setText("");
        destiny_folder.setBounds(180, 250, 834, 50);
        destiny_folder.setEditable(false);
        destiny_folder.setFont(new Font("Inter Black", Font.PLAIN, 20));
        destiny_folder.setVisible(true);

        auto_install_text.setBounds(20, 320, 250, 30);
        auto_install_text.setFont(new Font("Inter Black", Font.PLAIN, 20));
        auto_install_text.setHorizontalAlignment(0);
        auto_install_text.setEditable(false);

        autoInstall.setBounds(280, 325, 20, 20);
//        autoInstall.setIcon(new ImageIcon(""));
//        autoInstall.setSelectedIcon(Main.resizeIcon("src/Icons/Red_X.png", 20));

        progressBar.setBounds(20, 450, 994, 70);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);

        text_progress.setBounds(317, 540, 400, 50);
        text_progress.setFont(new Font("Inter Black", Font.PLAIN, 20));
        text_progress.setHorizontalAlignment(0);
        text_progress.setEditable(false);

        browse_b.setBounds(20, 250, 150, 50);
        browse_b.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                destiny_folder.setText(String.valueOf(chooser.getSelectedFile()));
            }
            else {
                consoleMessage("The destiny folder wasn't selected");
            }
        });


        download_b.setBounds(362, 650, 300, 70);
        download_b.addActionListener(e -> {
            if(Main.countSelectedApps() == 0){
                consoleMessage("You must select at least 1 app.");
            }
            else if (destiny_folder.getText() == ""){
                consoleMessage("You must select destiny folder.");
            }
            else{
                threadDownload = new Thread(this);
                threadDownload.start();
                download_b.setEnabled(false);
            }
        });


        this.add(info_panel);
        this.add(download_b);
        this.add(progressBar);
        this.add(text_progress);
        this.add(browse_b);
        this.add(destiny_folder);
        this.add(auto_install_text);
        this.add(autoInstall);

        this.setVisible(false);
    }

    /**
     * Update the apps_panel with selected app each time an app is selected or removed from the list of selected apps.
      */
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


    /**
     * Starts a thread that runs on background and update the progress bar with the current value.
     */
    @Override
    public void run() {
        new Connection().tryDownload(Main.selectedApps, destiny_folder.getText());
    }
}
