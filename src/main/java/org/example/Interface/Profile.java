package org.example.Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Interface.ProfilesPanel.*;

public class Profile extends JPanel implements ActionListener {

    int this_number;

    JButton edit_button;
    JTextField textField;
    JButton save_button;
    JButton copy_button;
    JButton delete_profile;
    public ArrayList<AppToDownload> profiel_apps = new ArrayList<>();
    public String nameProfile;

    public Profile(ArrayList<AppToDownload> selectedApps, String nameProfile){


        for(AppToDownload app : selectedApps){
            profiel_apps.add(app);
        }

        this.nameProfile = nameProfile;
        this_number = cont;

        //this.setBounds(32, 55, 940, 200);
        this.setBackground(new Color(37, 60, 44));
        this.setLayout(null);

        textField = new JTextField(nameProfile);
        textField.setEditable(false);
        textField.setBounds(10, 8, 150, 20);

        edit_button = new JButton(new ImageIcon("src/Icons/edit.png"));
        edit_button.setBounds(165, 8, 20, 20);
        edit_button.addActionListener(this);

        save_button = new JButton(new ImageIcon("src/Icons/check.png"));
        save_button.setBounds(190, 8, 20, 20);
        save_button.setEnabled(false);
        save_button.addActionListener(this);

        copy_button = new JButton("Copy profile");
        copy_button.setBounds(220, 8, 120, 20);
        copy_button.addActionListener(this);

        delete_profile = new JButton("Delete profile");
        delete_profile.setBounds(837, 8, 120, 20);
        delete_profile.addActionListener(this);

        JPanel apps_profile = new JPanel();
        apps_profile.setBounds(10, 34, 947, 83);
        apps_profile.setBackground(Color.white);
        apps_profile.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 3));
        apps_profile.setBorder(new EmptyBorder(2, 2, 2, 2));


        for(AppToDownload app : selectedApps){
            if(app != null){
                JLabel label = new JLabel();
                label.setIcon(Main.resizeIcon(app.icon, 22));
                apps_profile.add(label);
            }
        }

        this.add(delete_profile);
        this.add(textField);
        this.add(edit_button);
        this.add(save_button);
        this.add(copy_button);
        this.add(apps_profile);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== edit_button){
            textField.setEditable(true);
            save_button.setEnabled(true);
        }
        else if (e.getSource() == save_button){
            textField.setEditable(false);
            this.nameProfile = textField.getText();
            save_button.setEnabled(false);
        }
        else if(e.getSource() == delete_profile){
            for(Profile p : profiles){
                if(p != null){
                    if(p == this){
                        p_panel.remove(p);
                        MyFrame.profilesPanel.setVisible(false);
                        MyFrame.profilesPanel.setVisible(true);
                        cont--;
                        System.out.println(cont);
                        this.profiel_apps = null;
                        p = null;
                    }
                }
            }
        }
        else if(e.getSource() == copy_button){
            Main.selectedApps.clear();
            Main.selectedApps = this.profiel_apps;
            MyFrame.addAppCont();
            Main.desactivateButtons();
        }
    }
}
