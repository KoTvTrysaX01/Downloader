package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Tests that represents a tab of specific app type.
 */
public class Tests extends MyTabs{

    AppButton furMark = new AppButton();
    AppButton occt = new AppButton();
    AppButton memtest86 = new AppButton();
    AppButton aida64 = new AppButton();
    AppButton fanControl = new AppButton();
    AppButton prime95 = new AppButton();
    AppButton powerMax = new AppButton();
    AppButton threedmark = new AppButton();
    AppButton pcmark = new AppButton();

    /**
     * Construct an object of Tests that contains objects of AppButton with stored apps.
     */
    public Tests(){

        furMark.addAppCode(6,0);
        furMark.addActionListener(e -> buttons[0].selectButton());

        occt.addAppCode(6,1);
        occt.addActionListener(e -> buttons[1].selectButton());

        memtest86.addAppCode(6,2);
        memtest86.addActionListener(e -> buttons[2].selectButton());

        aida64.addAppCode(6,3);
        aida64.addActionListener(e -> buttons[3].selectButton());

        fanControl.addAppCode(6,4);
        fanControl.addActionListener(e -> buttons[4].selectButton());

        prime95.addAppCode(6,5);
        prime95.addActionListener(e -> buttons[5].selectButton());

        powerMax.addAppCode(6,6);
        powerMax.addActionListener(e -> buttons[6].selectButton());

        threedmark.addAppCode(6,7);
        threedmark.addActionListener(e -> buttons[7].selectButton());

        pcmark.addAppCode(6,8);
        pcmark.addActionListener(e -> buttons[8].selectButton());

        buttons[0] = furMark;
        buttons[1] = occt;
        buttons[2] = memtest86;
        buttons[3] = aida64;
        buttons[4] = fanControl;
        buttons[5] = prime95;
        buttons[6] = powerMax;
        buttons[7] = threedmark;
        buttons[8] = pcmark;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
