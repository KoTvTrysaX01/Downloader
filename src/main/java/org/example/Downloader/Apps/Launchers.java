package org.example.Downloader.Apps;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Launchers that represents a tab of specific app type.
 */
public class Launchers extends MyTabs{

    AppButton steam = new AppButton();
    AppButton egs = new AppButton();
    AppButton ubisoft = new AppButton();
    AppButton gog = new AppButton();
    AppButton rockstar = new AppButton();
    AppButton ea = new AppButton();
    AppButton battlenet = new AppButton();
    AppButton lol = new AppButton();
    AppButton tlauncher = new AppButton();
    AppButton nvidia = new AppButton();
    AppButton amd = new AppButton();

    /**
     * Construct an object of Launchers that contains objects of AppButton with stored apps.
     */
    public Launchers(){

        steam.addAppCode(1,0);
        steam.addActionListener(e -> buttons[0].selectButton());

        egs.addAppCode(1,1);
        egs.addActionListener(e -> buttons[1].selectButton());

        ubisoft.addAppCode(1,2);
        ubisoft.addActionListener(e -> buttons[2].selectButton());

        gog.addAppCode(1,3);
        gog.addActionListener(e -> buttons[3].selectButton());

        rockstar.addAppCode(1,4);
        rockstar.addActionListener(e -> buttons[4].selectButton());

        ea.addAppCode(1,5);
        ea.addActionListener(e -> buttons[5].selectButton());

        battlenet.addAppCode(1,6);
        battlenet.addActionListener(e -> buttons[6].selectButton());

        lol.addAppCode(1,7);
        lol.addActionListener(e -> buttons[7].selectButton());

        tlauncher.addAppCode(1,8);
        tlauncher.addActionListener(e -> buttons[8].selectButton());

        nvidia.addAppCode(1,9);
        nvidia.addActionListener(e -> buttons[9].selectButton());

        amd.addAppCode(1,10);
        amd.addActionListener(e -> buttons[10].selectButton());

        buttons[0] = steam;
        buttons[1] = egs;
        buttons[2] = ubisoft;
        buttons[3] = gog;
        buttons[4] = rockstar;
        buttons[5] = ea;
        buttons[6] = battlenet;
        buttons[7] = lol;
        buttons[8] = tlauncher;
        buttons[9] = nvidia;
        buttons[10] = amd;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
