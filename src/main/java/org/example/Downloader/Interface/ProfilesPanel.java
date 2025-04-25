package org.example.Downloader.Interface;

import org.apache.commons.io.IOUtils;
import org.example.Downloader.Functions.AppToDownload;
import org.example.Downloader.Functions.Main;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import static org.example.Downloader.Interface.MyFrame.consoleMessage;


/**
 * Class of ProfilePanel that contains array of 5 Profiles objects.
 */

public class ProfilesPanel extends JPanel{

    JButton add_profile_b;
    static JPanel profile_panel;
    public static Profile[] profiles = new Profile[5];
    public static int cont = 0;
    private JLabel text_field;

    /**
     * Reads JSON file and collects stored profiles from it.
     * @throws IOException if json file is not found or is null.
     */
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
                    profile_panel.add(profiles[i]);
                    profiles[i].setVisible(true);
                    cont++;
                }
            }catch (Exception e){
                consoleMessage("Couldn't get saved profiles.");
            }
        }
    }

    /**
     * Construct an object of ProfilesPanel that shows informative text field, button to add new profile and panel for profiles.
     */
    ProfilesPanel() {
        this.setBounds(340, 95, 1034, 755);
        this.setBackground(new Color(47, 111, 65));
        this.setForeground(Color.white);
        this.setLayout(null);

        text_field = new JLabel("YOUR PROFILES");
        text_field.setFont(new Font("Inter Black", Font.PLAIN, 28));
        text_field.setBounds(16, 5, 300, 35);
        text_field.setBackground(new Color(5, 53, 19));
        text_field.setForeground(Color.WHITE);
        text_field.setHorizontalAlignment(0);
        text_field.setOpaque(true);

        add_profile_b = new JButton("Add new profile");
        add_profile_b.setBounds(868, 5, 140, 35);
        add_profile_b.addActionListener(e -> {
            if(Main.countSelectedApps() == 0){
                consoleMessage("You selected 0 apps");
            }
            else{
                if (cont < 5) {
                    profiles[cont] = (new Profile(Main.selectedApps, "Profile #" + (cont + 1)));
                    profile_panel.add(profiles[cont]);
                    profiles[cont++].setVisible(true);
                }
                else{
                    consoleMessage("You've reached max amount of profiles");
                }
            }
        });

        profile_panel = new JPanel();
        profile_panel.setBounds(16, 45, 992, 690);
        profile_panel.setBackground(new Color(105, 186, 128));
        profile_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        profile_panel.setLayout(new GridLayout(5, 1, 0, 8));

        this.add(text_field);
        this.add(add_profile_b);
        this.add(profile_panel);
        this.setVisible(false);

        try{
            readJSON();
        }catch (Exception e) {
            e.getMessage();
        }
    }
}
