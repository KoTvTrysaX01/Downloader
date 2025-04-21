package org.example.Interface.Apps;

import org.example.Interface.MyButton;
import org.example.Interface.MyTabs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Media extends MyTabs implements ActionListener {
    MyButton vlc;
    MyButton spotify;
    MyButton winrar;
    MyButton sevenzip;
    MyButton reader;
    MyButton readerPro;
    MyButton photoshop;
    MyButton premierePro;
    MyButton vegasPro;
    MyButton figma;
    MyButton obs;
    MyButton utorrent;
    MyButton qBittorrent;
    MyButton xmind;
    MyButton freeMind;
    MyButton originLabPro;
    MyButton chemWindow;
    MyButton blender;


    public Media(){

        vlc = new MyButton();
        vlc.addAppCode(2, 0);
        vlc.addActionListener(this);

        spotify = new MyButton();
        spotify.addAppCode(2, 1);
        spotify.addActionListener(this);

        winrar = new MyButton();
        winrar.addAppCode(2, 2);
        winrar.addActionListener(this);

        sevenzip = new MyButton();
        sevenzip.addAppCode(2, 3);
        sevenzip.addActionListener(this);

        reader = new MyButton();
        reader.addAppCode(2, 4);
        reader.addActionListener(this);

        readerPro = new MyButton();
        readerPro.addAppCode(2, 5);
        readerPro.addActionListener(this);

        photoshop = new MyButton();
        photoshop.addAppCode(2, 6);
        photoshop.addActionListener(this);

        premierePro = new MyButton();
        premierePro.addAppCode(2, 7);
        premierePro.addActionListener(this);

        vegasPro = new MyButton();
        vegasPro.addAppCode(2, 8);
        vegasPro.addActionListener(this);

        figma = new MyButton();
        figma.addAppCode(2, 9);
        figma.addActionListener(this);

        obs = new MyButton();
        obs.addAppCode(2, 10);
        obs.addActionListener(this);

        utorrent = new MyButton();
        utorrent.addAppCode(2, 11);
        utorrent.addActionListener(this);

        qBittorrent = new MyButton();
        qBittorrent.addAppCode(2, 12);
        qBittorrent.addActionListener(this);

        xmind = new MyButton();
        xmind.addAppCode(2, 13);
        xmind.addActionListener(this);

        freeMind = new MyButton();
        freeMind.addAppCode(2, 14);
        freeMind.addActionListener(this);

        originLabPro = new MyButton();
        originLabPro.addAppCode(2, 15);
        originLabPro.addActionListener(this);

        chemWindow = new MyButton();
        chemWindow.addAppCode(2, 16);
        chemWindow.addActionListener(this);

        blender = new MyButton();
        blender.addAppCode(2, 17);
        blender.addActionListener(this);


        buttons[0] = vlc;
        buttons[1] = spotify;
        buttons[2] = winrar;
        buttons[3] = sevenzip;
        buttons[4] = reader;
        buttons[5] = readerPro;
        buttons[6] = photoshop;
        buttons[7] = premierePro;
        buttons[8] = vegasPro;
        buttons[9] = figma;
        buttons[10] = obs;
        buttons[11] = utorrent;
        buttons[12] = qBittorrent;
        buttons[13] = xmind;
        buttons[14] = freeMind;
        buttons[15] = originLabPro;
        buttons[16] = chemWindow;
        buttons[17] = blender;

        for(JButton button : buttons){
            this.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vlc){buttons[0].selectButton();}

        else if(e.getSource() == spotify){buttons[1].selectButton();}

        else if(e.getSource() == winrar){buttons[2].selectButton();}

        else if(e.getSource() == sevenzip){buttons[3].selectButton();}

        else if(e.getSource() == reader){buttons[4].selectButton();}

        else if(e.getSource() == readerPro){buttons[5].selectButton();}

        else if(e.getSource() == photoshop){buttons[6].selectButton();}

        else if(e.getSource() == premierePro){buttons[7].selectButton();}

        else if(e.getSource() == vegasPro){buttons[8].selectButton();}

        else if(e.getSource() == figma){buttons[9].selectButton();}

        else if(e.getSource() == obs){buttons[10].selectButton();}

        else if(e.getSource() == utorrent){buttons[11].selectButton();}

        else if(e.getSource() == qBittorrent){buttons[12].selectButton();}

        else if(e.getSource() == xmind){buttons[13].selectButton();}

        else if(e.getSource() == freeMind){buttons[14].selectButton();}

        else if(e.getSource() == originLabPro){buttons[15].selectButton();}

        else if(e.getSource() == chemWindow){buttons[16].selectButton();}

        else if(e.getSource() == blender){buttons[17].selectButton();}
    }
}
