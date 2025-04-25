package org.example.Downloader.Interface;

import javax.swing.*;
import java.awt.*;

import static org.example.Downloader.Functions.Main.countSelectedApps;


/**
 * Class of ConsolePanel that contains two panels with information for the user.
 */
public class ConsolePanel extends JPanel {

    JTextArea console = new JTextArea();
    JScrollPane consolePane = new JScrollPane(console);

    JPanel download_info = new JPanel();
    static JLabel selected_apps_count = new JLabel("Downloading apps: " + countSelectedApps());

    /**
     * Construct an object of ConsolePanel wit
     * selected_apps_count that shows current number of selected apps and
     * console that writes messages to the user.
     */
    public ConsolePanel(){

        this.setBounds(10, 510, 280, 340);
        this.setLayout(null);

        selected_apps_count.setVerticalAlignment(JLabel.CENTER);
        selected_apps_count.setHorizontalAlignment(JLabel.CENTER);
        selected_apps_count.setForeground(Color.WHITE);
        selected_apps_count.setFont(new Font("Inter Black", Font.PLAIN, 24));

        download_info.setBounds(0,0,280, 50);
        download_info.setBackground(new Color(37, 60, 44));
        download_info.add(selected_apps_count);
        download_info.setBorder(BorderFactory.createLineBorder(new Color(47, 111, 65), 3));

        console.setEditable(false);
        console.setBackground(new Color(37, 61, 44));
        console.setForeground(Color.WHITE);

        consolePane.setBounds(0, 47, 280, 293);
        consolePane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        consolePane.setBorder(BorderFactory.createLineBorder(new Color(47, 111, 65), 3));

        this.add(download_info);
        this.add(consolePane);
        this.setVisible(true);
    }
}
