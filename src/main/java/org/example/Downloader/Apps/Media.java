package org.example.Downloader.Apps;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;
import javax.swing.*;

/**
 * Class of Media that represents a tab of specific app type.
 */
public class Media extends MyTabs{
    AppButton vlc = new AppButton();
    AppButton spotify = new AppButton();
    AppButton winrar = new AppButton();
    AppButton sevenzip = new AppButton();
    AppButton reader = new AppButton();
    AppButton readerPro = new AppButton();
    AppButton photoshop = new AppButton();
    AppButton premierePro = new AppButton();
    AppButton vegasPro = new AppButton();
    AppButton figma = new AppButton();
    AppButton obs = new AppButton();
    AppButton utorrent = new AppButton();
    AppButton qBittorrent = new AppButton();
    AppButton xmind = new AppButton();
    AppButton freeMind = new AppButton();;
    AppButton originLabPro = new AppButton();;
    AppButton chemWindow = new AppButton();;
    AppButton blender = new AppButton();;


    /**
     * Construct an object of Media that contains objects of AppButton with stored apps.
     */
    public Media(){

        vlc.addAppCode(2, 0);
        vlc.addActionListener(e -> buttons[0].selectButton());

        spotify.addAppCode(2, 1);
        spotify.addActionListener(e -> buttons[1].selectButton());

        winrar.addAppCode(2, 2);
        winrar.addActionListener(e -> buttons[2].selectButton());

        sevenzip.addAppCode(2, 3);
        sevenzip.addActionListener(e -> buttons[3].selectButton());

        reader.addAppCode(2, 4);
        reader.addActionListener(e -> buttons[4].selectButton());

        readerPro.addAppCode(2, 5);
        readerPro.addActionListener(e -> buttons[5].selectButton());

        photoshop.addAppCode(2, 6);
        photoshop.addActionListener(e -> buttons[6].selectButton());

        premierePro.addAppCode(2, 7);
        premierePro.addActionListener(e -> buttons[7].selectButton());

        vegasPro.addAppCode(2, 8);
        vegasPro.addActionListener(e -> buttons[8].selectButton());

        figma.addAppCode(2, 9);
        figma.addActionListener(e -> buttons[9].selectButton());

        obs.addAppCode(2, 10);
        obs.addActionListener(e -> buttons[10].selectButton());

        utorrent.addAppCode(2, 11);
        utorrent.addActionListener(e -> buttons[11].selectButton());

        qBittorrent.addAppCode(2, 12);
        qBittorrent.addActionListener(e -> buttons[12].selectButton());

        xmind.addAppCode(2, 13);
        xmind.addActionListener(e -> buttons[13].selectButton());

        freeMind.addAppCode(2, 14);
        freeMind.addActionListener(e -> buttons[14].selectButton());

        originLabPro.addAppCode(2, 15);
        originLabPro.addActionListener(e -> buttons[15].selectButton());

        chemWindow.addAppCode(2, 16);
        chemWindow.addActionListener(e -> buttons[16].selectButton());

        blender.addAppCode(2, 17);
        blender.addActionListener(e -> buttons[17].selectButton());


        buttons[0] = vlc;
        buttons[1] = spotify;
        buttons[2] = winrar;
        buttons[3] = sevenzip;
        buttons[4] = reader;
        buttons[5] = readerPro;
        buttons[6] = photoshop;
        buttons[7] = premierePro;
        buttons[8] = vegasPro;
        buttons[9] = figma;
        buttons[10] = obs;
        buttons[11] = utorrent;
        buttons[12] = qBittorrent;
        buttons[13] = xmind;
        buttons[14] = freeMind;
        buttons[15] = originLabPro;
        buttons[16] = chemWindow;
        buttons[17] = blender;

        for(JButton button : buttons){
            this.add(button);
        }
    }
}
