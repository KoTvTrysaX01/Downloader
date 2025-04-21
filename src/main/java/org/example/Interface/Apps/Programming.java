package org.example.Interface.Apps;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Programming extends MyTabs implements ActionListener {

    MyButton notepad;
    MyButton vscode;
    MyButton visualStudio;
    MyButton intelij;
    MyButton pycharm;
    MyButton eclipse;
    MyButton netbeans;
    MyButton cmder;
    MyButton git;
    MyButton dbeaver;
    MyButton dotnet;
    MyButton jdk;
    MyButton python;

    public Programming(){

        notepad = new MyButton();
        notepad.addAppCode(3,0);
        notepad.addActionListener(this);

        vscode = new MyButton();
        vscode.addAppCode(3,1);
        vscode.addActionListener(this);

        visualStudio = new MyButton();
        visualStudio.addAppCode(3,2);
        visualStudio.addActionListener(this);

        intelij = new MyButton();
        intelij.addAppCode(3,3);
        intelij.addActionListener(this);

        pycharm = new MyButton();
        pycharm.addAppCode(3,4);
        pycharm.addActionListener(this);

        eclipse = new MyButton();
        eclipse.addAppCode(3,5);
        eclipse.addActionListener(this);

        netbeans = new MyButton();
        netbeans.addAppCode(3,6);
        netbeans.addActionListener(this);

        git = new MyButton();
        git.addAppCode(3,7);
        git.addActionListener(this);

        cmder = new MyButton();
        cmder.addAppCode(3,8);
        cmder.addActionListener(this);

        dbeaver = new MyButton();
        dbeaver.addAppCode(3,9);
        dbeaver.addActionListener(this);

        dotnet = new MyButton();
        dotnet.addAppCode(3,10);
        dotnet.addActionListener(this);

        jdk = new MyButton();
        jdk.addAppCode(3,11);
        jdk.addActionListener(this);

        python = new MyButton();
        python.addAppCode(3,12);
        python.addActionListener(this);

        buttons[0] = notepad;
        buttons[1] = vscode;
        buttons[2] = visualStudio;
        buttons[3] = intelij;
        buttons[4] = pycharm;
        buttons[5] = eclipse;
        buttons[6] = netbeans;
        buttons[7] = cmder;
        buttons[8] = git;
        buttons[9] = dbeaver;
        buttons[10] = dotnet;
        buttons[11] = jdk;
        buttons[12] = python;


        for(MyButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== notepad){buttons[0].selectButton();}

        else if(e.getSource()== vscode){buttons[1].selectButton();}

        else if(e.getSource()== visualStudio){buttons[2].selectButton();}

        else if(e.getSource()== intelij){buttons[3].selectButton();}

        else if(e.getSource()== pycharm){buttons[4].selectButton();}

        else if(e.getSource()== eclipse){buttons[5].selectButton();}

        else if(e.getSource()== netbeans){buttons[6].selectButton();}

        else if(e.getSource()== cmder){buttons[7].selectButton();}

        else if(e.getSource()== git){buttons[8].selectButton();}

        else if(e.getSource()== dbeaver){buttons[9].selectButton();}

        else if(e.getSource()== dotnet){buttons[10].selectButton();}

        else if(e.getSource()== jdk){buttons[11].selectButton();}

        else if(e.getSource()== python){buttons[12].selectButton();}
    }
}

