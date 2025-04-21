package org.example.Interface;


import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static org.example.Interface.MyFrame.consoleMessage;


public class ProfilesPanel extends JPanel implements ActionListener {



    JButton b_add_profile;
    static JPanel p_panel;
    public static Profile[] profiles = new Profile[5];
    public static int cont = 0;
    private JLabel text;


    public void readJSON() throws IOException {
        File f = new File("src/profiles.json");
        if (f.exists()){
            InputStream is = new FileInputStream("src/profiles.json");
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            try {
                JSONArray profilesJson = new JSONArray(jsonTxt);
                for(int i = 0; i < profilesJson.length(); i++){

                    JSONObject profile = profilesJson.getJSONObject(i);

                    JSONArray apps = profile.getJSONArray("apps");
                    ArrayList<AppToDownload> profileApps = new ArrayList<>();

                    int p;
                    for(p = 0; p < apps.length(); p++){
                        JSONObject app = apps.getJSONObject(p);
                        profileApps.add(new AppToDownload(  app.getString("app_name"),
                                                            app.getString("app_path"),
                                                            app.getString("app_icon"),
                                                            app.getString("app_command")));
                    }
                    profiles[i] = new Profile(profileApps, profile.getString("name"));
                    p_panel.add(profiles[i]);
                    profiles[i].setVisible(true);
                    cont++;
                }
            }catch (Exception e){
                consoleMessage("Couldn't get saved profiles.");
            }
        }
    }

    ProfilesPanel() throws IOException {
        this.setBounds(340, 95, 1034, 755);
        this.setBackground(new Color(47, 111, 65));
        this.setForeground(Color.white);
        this.setLayout(null);

        text = new JLabel("YOUR PROFILES");
        text.setFont(new Font("Inter Black", Font.PLAIN, 28));
        text.setBounds(16, 5, 300, 35);
        text.setBackground(new Color(5, 53, 19));
        text.setForeground(Color.WHITE);
        text.setHorizontalAlignment(0);
        text.setOpaque(true);

        b_add_profile = new JButton("Add new profile");
        b_add_profile.setBounds(868, 5, 140, 35);
        b_add_profile.addActionListener(this);

        p_panel = new JPanel();
        p_panel.setBounds(16, 45, 992, 690);
        p_panel.setBackground(new Color(105, 186, 128));
        p_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        p_panel.setLayout(new GridLayout(5, 1, 0, 8));

        this.add(text);
        this.add(b_add_profile);
        this.add(p_panel);
        this.setVisible(false);

        try{
            readJSON();
        }catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Main.countSelectedApps() == 0) {
            MyFrame.console_area.append("You selected 0 apps\n");
        }
        else{
            if (e.getSource() == b_add_profile && cont < 5) {
                profiles[cont] = (new Profile(Main.selectedApps, "Profile #" + (cont + 1)));
                p_panel.add(profiles[cont]);
                profiles[cont++].setVisible(true);
            }
            else{
                MyFrame.console_area.append("You reached max ammount of profiles\n");
            }
        }
    }



}

