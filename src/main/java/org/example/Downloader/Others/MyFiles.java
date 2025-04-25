/**
 * Contains classes of tabs of the other apps.
 */
package org.example.Downloader.Others;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of MyFiles that represents a tab of specific app type.
 */
public class MyFiles extends MyTabs{

    AppButton cyberpunk_extra_content = new AppButton();
    AppButton sh2_music = new AppButton();

    /**
     * Construct an object of MyFiles that contains objects of AppButton with stored apps.
     */
    public MyFiles(){

        cyberpunk_extra_content.addAppCode(12, 0);
        cyberpunk_extra_content.addActionListener(e -> buttons[0].selectButton());

        sh2_music.addAppCode(12, 1);
        sh2_music.addActionListener(e -> buttons[1].selectButton());

        buttons[0] = cyberpunk_extra_content;
        buttons[1] = sh2_music;

        for(AppButton button : buttons){
            this.add(button);
        }

        this.setVisible(false);

    }
}
