package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Overview that represents a tab of specific app type.
 */
public class Overview extends MyTabs{

    AppButton cpu_z = new AppButton();
    AppButton ccleaner = new AppButton();
    AppButton speccy = new AppButton();
    AppButton bat_mon = new AppButton();
    AppButton wumgr = new AppButton();
    AppButton revo = new AppButton();
    AppButton hwinfo = new AppButton();

    /**
     * Construct an object of Overview that contains objects of AppButton with stored apps.
     */
    public Overview(){

        cpu_z.addAppCode(5,0);
        cpu_z.addActionListener(e -> buttons[0].selectButton());

        ccleaner.addAppCode(5,1);
        ccleaner.addActionListener(e -> buttons[1].selectButton());

        speccy.addAppCode(5,2);
        speccy.addActionListener(e -> buttons[2].selectButton());

        bat_mon.addAppCode(5,3);
        bat_mon.addActionListener(e -> buttons[3].selectButton());

        wumgr.addAppCode(5,4);
        wumgr.addActionListener(e -> buttons[4].selectButton());

        revo.addAppCode(5,5);
        revo.addActionListener(e -> buttons[5].selectButton());

        hwinfo.addAppCode(5,6);
        hwinfo.addActionListener(e -> buttons[6].selectButton());

        buttons[0] = cpu_z;
        buttons[1] = ccleaner;
        buttons[2] = speccy;
        buttons[3] = bat_mon;
        buttons[4] = wumgr;
        buttons[5] = revo;
        buttons[6] = hwinfo;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
