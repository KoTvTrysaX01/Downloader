/**
 * Contains classes of tabs of the tool apps.
 */
package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Disk that represents a tab of specific app type.
 */
public class Disk extends MyTabs{

    AppButton crystalDiskInfo = new AppButton();
    AppButton crystalDiskMark = new AppButton();
    AppButton aomeiBackUpper = new AppButton();
    AppButton diskGenius = new AppButton();
    AppButton dashboardSandisk = new AppButton();
    AppButton wddLifeguard = new AppButton();
    AppButton hdclone = new AppButton();

    /**
     * Construct an object of Disk that contains objects of AppButton with stored apps.
     */
    public Disk(){

        crystalDiskInfo.addAppCode(9,0);
        crystalDiskInfo.addActionListener(e -> buttons[0].selectButton());

        crystalDiskMark.addAppCode(9,1);
        crystalDiskMark.addActionListener(e -> buttons[1].selectButton());

        aomeiBackUpper.addAppCode(9,2);
        aomeiBackUpper.addActionListener(e -> buttons[2].selectButton());

        diskGenius.addAppCode(9,3);
        diskGenius.addActionListener(e -> buttons[3].selectButton());

        dashboardSandisk.addAppCode(9,4);
        dashboardSandisk.addActionListener(e -> buttons[4].selectButton());

        wddLifeguard.addAppCode(9,5);
        wddLifeguard.addActionListener(e -> buttons[5].selectButton());

        hdclone.addAppCode(9,6);
        hdclone.addActionListener(e -> buttons[6].selectButton());

        buttons[0] = crystalDiskInfo;
        buttons[1] = crystalDiskMark;
        buttons[2] = aomeiBackUpper;
        buttons[3] = diskGenius;
        buttons[4] = dashboardSandisk;
        buttons[5] = wddLifeguard;
        buttons[6] = hdclone;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
