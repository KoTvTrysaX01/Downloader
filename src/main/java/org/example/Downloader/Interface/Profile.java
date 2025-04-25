package org.example.Downloader.Interface;

import org.example.Downloader.Functions.AppToDownload;
import org.example.Downloader.Functions.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

import static org.example.Downloader.Interface.ProfilesPanel.*;

/**
 * Class of Profile that may store objects of AppToDownload and allows to manipulate itself.
 * Is used in ProfilesPanel.
 */
public class Profile extends JPanel{

    int this_number;
    public ArrayList<AppToDownload> profiel_apps = new ArrayList<>();
    public String nameProfile;

    JTextField textField;
    JButton edit_button = new JButton(new ImageIcon("src/Icons/edit.png"));
    JButton save_button = new JButton(new ImageIcon("src/Icons/check.png"));
    JButton copy_button = new JButton("Copy profile");
    JButton delete_profile = new JButton("Delete profile");
    JPanel saved_apps_panel = new JPanel();


    /**
     * Constructs an object of Profile with some visual components and functions.
     * Shows a panel with saved apps. Can change its name in a text field using the edit button and confirming it by using the save button.
     * Can delete itself from ProfilesPanel array using the delete button.
     * @param selectedApps list of selected apps that is going to be store by the panel.
     * @param nameProfile name of the panel. Predefined by default but can be changed by user.
     */
    public Profile(ArrayList<AppToDownload> selectedApps, String nameProfile){

        for(AppToDownload app : selectedApps){
            profiel_apps.add(app);
        }

        this.nameProfile = nameProfile;
        this_number = cont;

        this.setBackground(new Color(37, 60, 44));
        this.setLayout(null);

        textField = new JTextField(nameProfile);
        textField.setEditable(false);
        textField.setBounds(10, 8, 150, 20);


        edit_button.setBounds(165, 8, 20, 20);
        edit_button.addActionListener(e -> {
            textField.setEditable(true);
            save_button.setEnabled(true);
        });

        save_button.setBounds(190, 8, 20, 20);
        save_button.setEnabled(false);
        save_button.addActionListener(e -> {
            textField.setEditable(false);
            this.nameProfile = textField.getText();
            save_button.setEnabled(false);
        });

        copy_button.setBounds(220, 8, 120, 20);
        copy_button.addActionListener(e -> {
            Main.selectedApps.clear();
            Main.selectedApps = this.profiel_apps;
            MyFrame.updateAppCounter();
            Main.desactivateButtons();
        });

        delete_profile.setBounds(837, 8, 120, 20);
        delete_profile.addActionListener(e -> {
            for(Profile p : profiles){
                if(p != null){
                    if(p == this){
                        profile_panel.remove(p);
                        MyFrame.profilesPanel.setVisible(false);
                        MyFrame.profilesPanel.setVisible(true);
                        cont--;
                        //System.out.println(cont);
                        this.profiel_apps = null;
                        p = null;
                    }
                }
            }
        });

        saved_apps_panel.setBounds(10, 34, 947, 83);
        saved_apps_panel.setBackground(Color.white);
        saved_apps_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 3));
        saved_apps_panel.setBorder(new EmptyBorder(2, 2, 2, 2));

        for(AppToDownload app : selectedApps){
            if(app != null){
                JLabel label = new JLabel();
                label.setIcon(Main.resizeIcon(app.icon, 22));
                saved_apps_panel.add(label);
            }
        }

        this.add(delete_profile);
        this.add(textField);
        this.add(edit_button);
        this.add(save_button);
        this.add(copy_button);
        this.add(saved_apps_panel);
        this.setVisible(false);
    }
}
