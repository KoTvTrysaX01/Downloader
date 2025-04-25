package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Protection that represents a tab of specific app type.
 */
public class Protection extends MyTabs{

    AppButton defenderUI = new AppButton();
    AppButton eset = new AppButton();
    AppButton malwareBytes = new AppButton();

    /**
     * Construct an object of Protection that contains objects of AppButton with stored apps.
     */
    public Protection(){

        defenderUI.addAppCode(10,0);
        defenderUI.addActionListener(e -> buttons[0].selectButton());

        eset.addAppCode(10,1);
        eset.addActionListener(e -> buttons[1].selectButton());

        malwareBytes.addAppCode(10,2);
        malwareBytes.addActionListener(e -> buttons[2].selectButton());

        buttons[0] = defenderUI;
        buttons[1] = eset;
        buttons[2] = malwareBytes;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
