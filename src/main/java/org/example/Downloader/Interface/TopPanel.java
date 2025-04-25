package org.example.Downloader.Interface;

import org.example.Downloader.Functions.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Class of TopPanel that shows basic program information.
 */
public class TopPanel extends JPanel {

    JLabel program_name = new JLabel("DOWNLOADER");
    JLabel author_name = new JLabel("VADIM ELSHIN | DAW 1 | IES DOCTOR BALMIS");
    JButton check_connection = new JButton("Check Connection:");
    public JLabel status_connection = new JLabel(Main.resizeIcon("src/Icons/neutral.png", 55));

    /**
     * Construct an object of TopPanel with labels of its name, its author and a button that check connection to the server.
     */
    public TopPanel(){
        this.setBounds(10, 10, 1364, 60);
        this.setBackground(new Color(104, 186, 127));
        this.setLayout(null);

        program_name.setBounds(10, 5, 290, 50);
        program_name.setBackground(new Color(37, 60, 44));
        program_name.setForeground(Color.WHITE);
        program_name.setOpaque(true);
        program_name.setVerticalAlignment(JLabel.CENTER);
        program_name.setHorizontalAlignment(JLabel.CENTER);
        program_name.setFont(new Font("Arial", Font.PLAIN, 30));
        program_name.setBorder(BorderFactory.createLineBorder(new Color(110, 253, 112), 2));


        author_name.setBounds(310, 5, 700, 50);
        author_name.setBackground(new Color(110, 253, 112));
        author_name.setForeground(Color.BLACK);
        author_name.setBorder(BorderFactory.createLineBorder(new Color(110, 253, 112), 2));
        author_name.setOpaque(true);
        author_name.setVerticalAlignment(JLabel.CENTER);
        author_name.setHorizontalAlignment(JLabel.CENTER);
        author_name.setFont(new Font("Arial", Font.PLAIN, 30));
        author_name.setBorder(BorderFactory.createLineBorder(new Color(37, 60, 44), 2));

        check_connection.setBounds(1020, 5, 250, 50);
        check_connection.setFont(new Font("Arial", Font.PLAIN, 24));
        check_connection.setBackground(new Color(47, 111, 65));
        check_connection.setForeground(Color.WHITE);
        check_connection.setFocusable(false);
        check_connection.setBorder(BorderFactory.createLineBorder(new Color(110, 253, 112), 2));

        status_connection.setBounds(1290, 0, 60, 60);
        status_connection.setOpaque(false);

        this.add(program_name);
        this.add(author_name);
        this.add(check_connection);
        this.add(status_connection);
    }
}
