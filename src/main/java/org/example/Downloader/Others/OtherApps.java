package org.example.Downloader.Others;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of OtherApps that represents a tab of specific app type.
 */
public class OtherApps extends MyTabs{

    AppButton autoFirma = new AppButton();
    AppButton conf_fmnt = new AppButton();
    AppButton inst_dnie = new AppButton();
    AppButton rufus = new AppButton();
    AppButton kms = new AppButton();
    AppButton launchj4 = new AppButton();
    AppButton r2modman = new AppButton();
    AppButton iconViewer = new AppButton();
    AppButton vencord = new AppButton();
    AppButton wordpress = new AppButton();

    /**
     * Construct an object of OtherApps that contains objects of AppButton with stored apps.
     */
    public OtherApps(){

        autoFirma.addAppCode(11, 0);
        autoFirma.addActionListener(e -> buttons[0].selectButton());

        conf_fmnt.addAppCode(11, 1);
        conf_fmnt.addActionListener(e -> buttons[1].selectButton());

        inst_dnie.addAppCode(11, 2);
        inst_dnie.addActionListener(e -> buttons[2].selectButton());

        rufus.addAppCode(11, 3);
        rufus.addActionListener(e -> buttons[3].selectButton());

        kms.addAppCode(11, 4);
        kms.addActionListener(e -> buttons[4].selectButton());

        launchj4.addAppCode(11, 5);
        launchj4.addActionListener(e -> buttons[5].selectButton());

        r2modman.addAppCode(11, 6);
        r2modman.addActionListener(e -> buttons[6].selectButton());

        iconViewer.addAppCode(11, 7);
        iconViewer.addActionListener(e -> buttons[7].selectButton());

        vencord.addAppCode(11, 8);
        vencord.addActionListener(e -> buttons[8].selectButton());

        wordpress.addAppCode(11, 9);
        wordpress.addActionListener(e -> buttons[9].selectButton());

        buttons[0] = autoFirma;
        buttons[1] = conf_fmnt;
        buttons[2] = inst_dnie;
        buttons[3] = rufus;
        buttons[4] = kms;
        buttons[5] = launchj4;
        buttons[6] = r2modman;
        buttons[7] = iconViewer;
        buttons[8] = vencord;
        buttons[9] = wordpress;

        for(AppButton button : buttons){
            this.add(button);
        }
        this.setVisible(false);

    }
}
