package org.example.Downloader.Tools;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Network that represents a tab of specific app type.
 */
public class Network extends MyTabs{

    AppButton anyDesk = new AppButton();
    AppButton rustDesk = new AppButton();
    AppButton supremo = new AppButton();
    AppButton hwMonitoPro = new AppButton();
    AppButton openVPN = new AppButton();
    AppButton wireGuard = new AppButton();
    AppButton hamachi = new AppButton();
    AppButton shadowsocks = new AppButton();
    AppButton xampp = new AppButton();

    /**
     * Construct an object of Network that contains objects of AppButton with stored apps.
     */
    public Network(){

        anyDesk.addAppCode(7,0);
        anyDesk.addActionListener(e -> buttons[0].selectButton());

        rustDesk.addAppCode(7,1);
        rustDesk.addActionListener(e -> buttons[1].selectButton());

        supremo.addAppCode(7,2);
        supremo.addActionListener(e -> buttons[2].selectButton());

        hwMonitoPro.addAppCode(7,3);
        hwMonitoPro.addActionListener(e -> buttons[3].selectButton());

        openVPN.addAppCode(7,4);
        openVPN.addActionListener(e -> buttons[4].selectButton());

        wireGuard.addAppCode(7,5);
        wireGuard.addActionListener(e -> buttons[5].selectButton());

        hamachi.addAppCode(7,6);
        hamachi.addActionListener(e -> buttons[6].selectButton());

        shadowsocks.addAppCode(7,7);
        shadowsocks.addActionListener(e -> buttons[7].selectButton());

        xampp.addAppCode(7,8);
        xampp.addActionListener(e -> buttons[8].selectButton());

        buttons[0] = anyDesk;
        buttons[1] = rustDesk;
        buttons[2] = supremo;
        buttons[3] = hwMonitoPro;
        buttons[4] = openVPN;
        buttons[5] = wireGuard;
        buttons[6] = hamachi;
        buttons[7] = shadowsocks;
        buttons[8] = xampp;

        for(AppButton button : buttons){
            this.add(button);
        }
    }
}
