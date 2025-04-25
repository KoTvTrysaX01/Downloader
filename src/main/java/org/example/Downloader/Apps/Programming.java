package org.example.Downloader.Apps;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyTabs;

/**
 * Class of Programming that represents a tab of specific app type.
 */
public class Programming extends MyTabs{

    AppButton notepad = new AppButton();
    AppButton vscode = new AppButton();
    AppButton visualStudio = new AppButton();
    AppButton intelij = new AppButton();
    AppButton pycharm = new AppButton();
    AppButton eclipse = new AppButton();
    AppButton netbeans = new AppButton();
    AppButton cmder = new AppButton();
    AppButton git = new AppButton();
    AppButton dbeaver = new AppButton();
    AppButton dotnet = new AppButton();
    AppButton jdk = new AppButton();
    AppButton python = new AppButton();

    /**
     * Construct an object of Programming that contains objects of AppButton with stored apps.
     */
    public Programming(){

        notepad.addAppCode(3,0);
        notepad.addActionListener(e -> buttons[0].selectButton());

        vscode.addAppCode(3,1);
        vscode.addActionListener(e -> buttons[1].selectButton());

        visualStudio.addAppCode(3,2);
        visualStudio.addActionListener(e -> buttons[2].selectButton());

        intelij.addAppCode(3,3);
        intelij.addActionListener(e -> buttons[3].selectButton());

        pycharm.addAppCode(3,4);
        pycharm.addActionListener(e -> buttons[4].selectButton());

        eclipse.addAppCode(3,5);
        eclipse.addActionListener(e -> buttons[5].selectButton());

        netbeans.addAppCode(3,6);
        netbeans.addActionListener(e -> buttons[6].selectButton());

        git.addAppCode(3,7);
        git.addActionListener(e -> buttons[7].selectButton());

        cmder.addAppCode(3,8);
        cmder.addActionListener(e -> buttons[8].selectButton());

        dbeaver.addAppCode(3,9);
        dbeaver.addActionListener(e -> buttons[9].selectButton());

        dotnet.addAppCode(3,10);
        dotnet.addActionListener(e -> buttons[10].selectButton());

        jdk.addAppCode(3,11);
        jdk.addActionListener(e -> buttons[11].selectButton());

        python.addAppCode(3,12);
        python.addActionListener(e -> buttons[12].selectButton());

        buttons[0] = notepad;
        buttons[1] = vscode;
        buttons[2] = visualStudio;
        buttons[3] = intelij;
        buttons[4] = pycharm;
        buttons[5] = eclipse;
        buttons[6] = netbeans;
        buttons[7] = git;
        buttons[8] = cmder;
        buttons[9] = dbeaver;
        buttons[10] = dotnet;
        buttons[11] = jdk;
        buttons[12] = python;


        for(AppButton button : buttons){
            this.add(button);
        }
    }
}

