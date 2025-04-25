package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of OS_And_ISOs that represents a tab of specific app type.
 */
public class OS_And_ISOs extends MyTabs{

    AppButton win10 = new AppButton();
    AppButton win11 = new AppButton();
    AppButton ubuntu24 = new AppButton();
    AppButton mediCat = new AppButton();
    AppButton strelec = new AppButton();
    AppButton virtualBox = new AppButton();

    /**
     * Construct an object of OS_And_ISOs that contains objects of AppButton with stored apps.
     */
    public OS_And_ISOs(){

        win10.addAppCode(8,0);
        win10.addActionListener(e -> buttons[0].selectButton());

        win11.addAppCode(8,1);
        win11.addActionListener(e -> buttons[1].selectButton());

        ubuntu24.addAppCode(8,2);
        ubuntu24.addActionListener(e -> buttons[2].selectButton());

        mediCat.addAppCode(8,3);
        mediCat.addActionListener(e -> buttons[3].selectButton());

        strelec.addAppCode(8,4);
        strelec.addActionListener(e -> buttons[4].selectButton());

        virtualBox.addAppCode(8,5);
        virtualBox.addActionListener(e -> buttons[5].selectButton());

        buttons[0] = win10;
        buttons[1] = win11;
        buttons[2] = ubuntu24;
        buttons[3] = mediCat;
        buttons[4] = strelec;
        buttons[5] = virtualBox;

        for(AppButton button : buttons){
            this.add(button);
        }

    }
}