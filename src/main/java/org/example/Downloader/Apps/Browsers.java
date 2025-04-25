/**
 * Contains classes of tabs of the common apps.
 */
package org.example.Downloader.Apps;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;


/**
 * Class of Browsers that represents a tab of specific app type.
 */
public class Browsers extends MyTabs{

    AppButton chrome = new AppButton();
    AppButton firefox = new AppButton();
    AppButton yandexBR = new AppButton();
    AppButton opera = new AppButton();
    AppButton operaGX = new AppButton();
    AppButton brave = new AppButton();

    /**
     * Construct an object of Browsers that contains objects of AppButton with stored apps.
     */
    public Browsers(){

        chrome.addAppCode(0,0);
        chrome.addActionListener(e -> buttons[0].selectButton());

        firefox.addAppCode(0,1);
        firefox.addActionListener(e -> buttons[1].selectButton());

        yandexBR.addAppCode(0,2);
        yandexBR.addActionListener(e -> buttons[2].selectButton());

        opera.addAppCode(0,3);
        opera.addActionListener(e -> buttons[3].selectButton());

        operaGX.addAppCode(0,4);
        operaGX.addActionListener(e -> buttons[4].selectButton());

        brave.addAppCode(0,5);
        brave.addActionListener(e -> buttons[5].selectButton());

        buttons[0] = chrome;
        buttons[1] = firefox;
        buttons[2] = yandexBR;
        buttons[3] = opera;
        buttons[4] = operaGX;
        buttons[5] = brave;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}