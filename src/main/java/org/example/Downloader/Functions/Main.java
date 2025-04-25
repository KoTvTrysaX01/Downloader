package org.example.Downloader.Functions;

import org.example.Downloader.Interface.AppButton;
import org.example.Downloader.Interface.MyFrame;
import org.example.Downloader.Interface.MyTabs;
import org.example.Downloader.Interface.Profile;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.example.Downloader.Interface.MyFrame.consoleMessage;
import static org.example.Downloader.Interface.ProfilesPanel.profiles;

/**
 * Main class that starts the application.
 * Stores mini-database with the applications' data, the list of the selected apps and a thread that starts before the app is finished.
 * @author Vadim Elshin
 * @version 1.0.1
 */
public class Main {
    public static ArrayList<AppToDownload> selectedApps = new ArrayList<>();

    public static String[][] apps_names = {
    /*#0 Browsers*/     {"Chrome", "FireFox", "Yandex", "Opera", "OperaGX", "Brave"},
    /*#1 Launchers*/    {"Steam", "Epic Games Store", "Ubisoft Launcher", "GOG Galaxy", "Rockstar Launcher", "EA Launcher", "Battle.net", "TLauncher", "League of Legends", "Nvidia App", "AMD Adrenalin"},
    /*#2 Media*/        {"VLC", "Spotify", "WinRar", "7-zip", "Acrobat Reader", "Acrobat Pro", "Photoshop 2025", "Premiere Pro 2025", "Vegas Pro 22", "Figma", "OBS Studio", "uTorrent", "qBittorrent", "XMind Zen", "FreeMind", "OriginLabPro", "ChemWindow", "Blender"},
    /*#3 Programming*/  {"NotePad++", "VS Code", "Visual Studio", "InteliJ Com.", "PyCharm Com.", "Eclipse Com.", "Apache NetBeans", "CMDer", "Git", "DBeaver", ".NET 9", "JDK 24", "Python 3.13"},
    /*#4 Communication*/{"Discord", "Telegram", "TeamSpeak", "WhatsApp", "Skype", "Teams"},
    /*-----------------------------------------------------------------------------------------*/
    /*#5 Overview*/     {"CPU-Z", "CCleaner", "Speccy", "BatteryMon", "WuMgr", "Revo Uninstaller", "HWiNFO"},
    /*#6 Tests*/        {"FurMark", "OCCT", "MemTest86", "AIDA64", "FanControl", "Prime95", "PowerMax", "3DMark", "PCMark-10"},
    /*#7 Network*/      {"AnyDesk", "RustDesk", "Supremo", "HWMonitor-Pro", "OpenVPN Connect", "WireGuard", "Hamachi", "Shadowsocks", "XAMPP"},
    /*#8 OS & ISOs*/    {"Windows 10", "Windows 11", "Ubuntu 24", "MediCat", "Strelec", "VirtualBox"},
    /*#9 Disk*/         {"CrystalDiskInfo", "CrystalDiskMark", "AOMEI Backupper", "DiskGenius", "Dashboard Sandisk", "WD Data Lifeguard", "HDClone"},
    /*#10 Protection*/  {"DefenderUI", "ESET Online", "MalwareBytes"},
    /*-----------------------------------------------------------------------------------------*/
    /*#11 OtherApps*/   {"AutoFirma", "Configurador FNMT", "Inst. Tar. DNIe", "Rufus", "KMS", "Launch4j", "r2modman", "IconViewer", "Vencord", "Wordpress"},
    /*#12 Files*/       {"Bonus Content", "Soundtracks"},
    };

    public static String[][] files_names = {
    /*#0 Browsers*/     {"Chrome.exe", "Firefox.exe", "Yandex.exe", "Opera.exe", "OperaGX.exe", "Brave.exe"},
    /*#1 Launchers*/    {"Steam.exe", "EGS.msi", "Ubisoft.exe", "GOG_Galaxy.exe", "Rockstar.exe", "EA.exe", "Battle.net.exe", "TLauncher.exe", "League_of_Legends.exe", "Nvidia_App.exe", "AMD_Adrenalin.exe"},
    /*#2 Media*/        {"vlc-3.0.21-win64.exe", "Spotify.exe", "WinRar.exe", "7-zip.exe", "Adobe_Reader.exe", "Acrobat_Pro.rar", "Photoshop_2025.rar", "Premiere_Pro_2025.7z", "VEGAS_Pro_22.rar", "Figma.exe", "OBS_Studio.exe", "uTorrent.exe", "qBittorrent.exe", "XMind_Zen.rar", "FreeMind.exe", "OriginLabPro.rar", "ChemWindow.zip", "Blender.msi"},
    /*#3 Programming*/  {"NotePad++.exe", "VS_Code.exe", "Visual_Studio.exe", "InteliJ_Community.exe", "PyCharm_Community.exe", "Eclipse.exe", "NetBeans.exe", "CMDER.zip", "Git.exe", "DBeaver.exe", "dotnet9.exe", "JDK_24.exe", "Python_3.13.exe"},
    /*#4 Communication*/{"Discord.exe", "Telegram.exe", "TeamSpeak.msi", "WhatsApp.exe", "Skype.exe", "MSTeams.exe"},
    /*-----------------------------------------------------------------------------------------*/
    /*#5 Overview*/     {"CPU-Z.exe", "ccsetup635.exe", "Speccy.exe", "BatteryMon.exe", "WuMgr.zip", "Revo_Uninstaller_Pro.zip", "hwi64.exe"},
    /*#6 Tests*/        {"FurMark.exe", "OCCT.exe", "MemTest86-USB.zip", "AIDA64.exe", "FanControl.exe", "Prime95.zip", "PowerMax.exe", "3DMark.", "PCMark-10."},
    /*#7 Network*/      {"AnyDesk.exe", "RustDesk.exe", "Supremo.exe", "HWMonitor-Pro.exe", "OpenVPNConnect.msi", "WireGuard.exe", "Hamachi.msi", "Shadowsocks.zip", "XAMPP.exe"},
    /*#8 OS & ISOs*/    {"Windows_10.iso", "Windows_11.iso", "Ubuntu_24.iso", "MediCat.bat", "Strelec.rar", "VirtualBox.exe"},
    /*#9 Disk*/         {"CrystalDiskInfo.exe", "CrystalDiskMark.exe", "AOMEI_Backupper.rar", "DiskGenius.exe", "Dashboard_Sandisk.exe", "WD_Data_Lifeguard.rar", "HDClone.exe"},
    /*#10 Protection*/  {"DefenderUI.exe", "ESETOnlineScanner.exe", "MalwareBytes.exe"},
    /*-----------------------------------------------------------------------------------------*/
    /*#11 OtherApps*/   {"AutoFirma.exe", "Configurador_FNMT.exe", "Instalador_Tarjetas_DNIe.exe", "Rufus.exe", "KMS.rar", "Launch4j.exe", "r2modman.zip", "IconViewer.exe", "Vencord.exe", "wordpress.zip"},
    /*#12 Files*/       {"Cyberpunk_2077_Bonus_Content", "SILENT_HILL_2_Soundtrack"},
    };

    public static String[][] files_icons = {
/*#0 Browsers*/     {
                        ("src/Icons/Apps/Browsers/chrome.png"),
                        ("src/Icons/Apps/Browsers/firefox.png"),
                        ("src/Icons/Apps/Browsers/yandexBR.png"),
                        ("src/Icons/Apps/Browsers/opera.png"),
                        ("src/Icons/Apps/Browsers/operaGX.png"),
                        ("src/Icons/Apps/Browsers/brave.png")
                    },
/*#1 Launchers*/    {
                        ("src/Icons/Apps/Launchers/steam.png"),
                        ("src/Icons/Apps/Launchers/egs.png"),
                        ("src/Icons/Apps/Launchers/ubisoft.png"),
                        ("src/Icons/Apps/Launchers/gog galaxy.png"),
                        ("src/Icons/Apps/Launchers/rockstar.png"),
                        ("src/Icons/Apps/Launchers/ea.png"),
                        ("src/Icons/Apps/Launchers/battlenet.png"),
                        ("src/Icons/Apps/Launchers/TLauncher.png"),
                        ("src/Icons/Apps/Launchers/LoL.png"),
                        ("src/Icons/Apps/Launchers/Nvidia App.png"),
                        ("src/Icons/Apps/Launchers/AMD Adrenalin.png")
                    },
/*#2 Media*/        {
                        ("src/Icons/Apps/Media/vlc.png"),
                        ("src/Icons/Apps/Media/Spotify.png"),
                        ("src/Icons/Apps/Media/Winrar.png"),
                        ("src/Icons/Apps/Media/7z.png"),
                        ("src/Icons/Apps/Media/Adobe Acrobat Reader.png"),
                        ("src/Icons/Apps/Media/Adobe Acrobat Pro.png"),
                        ("src/Icons/Apps/Media/Adobe Photoshop.png"),
                        ("src/Icons/Apps/Media/Adobe Premiere Pro.png"),
                        ("src/Icons/Apps/Media/Vegas Pro.png"),
                        ("src/Icons/Apps/Media/Figma.png"),
                        ("src/Icons/Apps/Media/OBS.png"),
                        ("src/Icons/Apps/Media/UTorrent.png"),
                        ("src/Icons/Apps/Media/qBittorrent.png"),
                        ("src/Icons/Apps/Media/XMind.png"),
                        ("src/Icons/Apps/Media/FreeMind.png"),
                        ("src/Icons/Apps/Media/OriginLabPro.png"),
                        ("src/Icons/Apps/Media/ChemWindow.png"),
                        ("src/Icons/Apps/Media/Blender.png")
                    },
/*#3 Programming*/  {
                        ("src/Icons/Apps/Programming/notepad.png"),
                        ("src/Icons/Apps/Programming/vscode.png"),
                        ("src/Icons/Apps/Programming/visualstudio.png"),
                        ("src/Icons/Apps/Programming/intelij.png"),
                        ("src/Icons/Apps/Programming/pycharm.png"),
                        ("src/Icons/Apps/Programming/eclipse.png"),
                        ("src/Icons/Apps/Programming/netbeans.png"),
                        ("src/Icons/Apps/Programming/CMDer.png"),
                        ("src/Icons/Apps/Programming/Git.png"),
                        ("src/Icons/Apps/Programming/DBeaver.png"),
                        ("src/Icons/Apps/Programming/dotnet.png"),
                        ("src/Icons/Apps/Programming/JDK.png"),
                        ("src/Icons/Apps/Programming/Python.png")
                    },
/*#4 Communication*/{
                        ("src/Icons/Apps/Communication/Discord.png"),
                        ("src/Icons/Apps/Communication/Telegram.png"),
                        ("src/Icons/Apps/Communication/TeamSpeak.png"),
                        ("src/Icons/Apps/Communication/WhatsApp.png"),
                        ("src/Icons/Apps/Communication/Skype.png"),
                        ("src/Icons/Apps/Communication/Teams.png")
                    },
/*-----------------------------------------------------------------------------------------*/
/*#5 Overview*/     {
                        ("src/Icons/Tools/Overview/CPU-Z.png"),
                        ("src/Icons/Tools/Overview/CCleaner.png"),
                        ("src/Icons/Tools/Overview/Speccy.png"),
                        ("src/Icons/Tools/Overview/BatteryMon.png"),
                        ("src/Icons/Tools/Overview/WuMgr.png"),
                        ("src/Icons/Tools/Overview/Revo Uninstaller.png"),
                        ("src/Icons/Tools/Overview/HWiNFO.png")
                    },
/*#6 Tests*/       {
                        ("src/Icons/Tools/Tests/FurMark.png"),
                        ("src/Icons/Tools/Tests/OCCT.png"),
                        ("src/Icons/Tools/Tests/MemTest86.png"),
                        ("src/Icons/Tools/Tests/AIDA64.png"),
                        ("src/Icons/Tools/Tests/FanControl.png"),
                        ("src/Icons/Tools/Tests/Prime95.png"),
                        ("src/Icons/Tools/Tests/PowerMax.png"),
                        ("src/Icons/Tools/Tests/3DMark.png"),
                        ("src/Icons/Tools/Tests/PCMark-10.png")
                    },
/*#7 Network*/      {
                        ("src/Icons/Tools/Network/AnyDesk.png"),
                        ("src/Icons/Tools/Network/RustDesk.png"),
                        ("src/Icons/Tools/Network/Supremo.png"),
                        ("src/Icons/Tools/Network/HWMonitor-Pro.png"),
                        ("src/Icons/Tools/Network/OpenVPN Connect.png"),
                        ("src/Icons/Tools/Network/WireGuard.png"),
                        ("src/Icons/Tools/Network/Hamachi.png"),
                        ("src/Icons/Tools/Network/Shadowsocks.png"),
                        ("src/Icons/Tools/Network/XAMPP.png")
                    },
/*#8 OS & ISOs*/    {
                        ("src/Icons/Tools/OS & ISOs/Windows 10.png"),
                        ("src/Icons/Tools/OS & ISOs/Windows 11.png"),
                        ("src/Icons/Tools/OS & ISOs/Ubuntu 24.png"),
                        ("src/Icons/Tools/OS & ISOs/MediCat.png"),
                        ("src/Icons/Tools/OS & ISOs/Strelec.png"),
                        ("src/Icons/Tools/OS & ISOs/VirtualBox.png")
                    },
/*#9 Disk*/         {
                        ("src/Icons/Tools/Disk/CrystalDiskInfo.png"),
                        ("src/Icons/Tools/Disk/CrystalDiskMark.png"),
                        ("src/Icons/Tools/Disk/BackUpper.png"),
                        ("src/Icons/Tools/Disk/DiskGenius.png"),
                        ("src/Icons/Tools/Disk/Dashboard Sandisk.png"),
                        ("src/Icons/Tools/Disk/WD DAta Lifeguard.png"),
                        ("src/Icons/Tools/Disk/HDClone.png")
                    },
/*#10 Protection*/  {
                        ("src/Icons/Tools/Protection/DefenderUI.png"),
                        ("src/Icons/Tools/Protection/ESETOnlineScanner.png"),
                        ("src/Icons/Tools/Protection/Malware Bytes.png")
                    },
/*-----------------------------------------------------------------------------------------*/
/*#11 OtherApps*/   {
                        ("src/Icons/Other/AutoFirma.png"),
                        ("src/Icons/Other/Configurador FNMT.png"),
                        ("src/Icons/Other/Instalador Tarjetas DNIe.png"),
                        ("src/Icons/Other/Rufus.png"),
                        ("src/Icons/Other/KMS.png"),
                        ("src/Icons/Other/Launch4j.png"),
                        ("src/Icons/Other/r2modman.png"),
                        ("src/Icons/Other/IconViewer.png"),
                        ("src/Icons/Other/Vencord.png"),
                        ("src/Icons/Other/wordpress.png"),
                    },
/*#12 Files*/       {
                        ("src/Icons/Files/Cyberpunk 2077.png"),
                        ("src/Icons/Files/Silent Hill 2.png"),
                    }
    };


    public static String[][] files_command = {
/*#0 Browsers*/     {
        /*Chrome*/      (".\\Chrome.exe  --silent"),
        /*Fireofx*/     (".\\Firefox.exe --silent"),
        /*Yandex*/      (".\\Yandex.exe --silent"),
        /*Opera*/       (".\\Opera.exe --silent"),
        /*OperaGX*/     (".\\OperaGX.exe --silent"),
        /*Chrome*/      (".\\Brave.exe --silent")
    },
/*#1 Launchers*/    {
        /*Steame*/      (".\\Steam.exe /S"),
        /*EGS*/         (".\\EGS.msi /quiet"),
        /*Ubisoft*/     (".\\Ubisoft.exe /S"),
        /*GOG*/         (".\\GOG_Galaxy.exe /VERYSILENT /NORESTART"),
        /*Rockstar*/    (".\\Rockstar.exe --silent"),
        /*EA*/          (".\\EA.exe --silent"),
        /*Battle.net*/  (".\\Battle.net.exe --lang=enUS --installpath=\"C:\\Program Files (x86)\\Battle.net\""),
        /*TLauncher*/   (".\\TLauncher.exe /S"),
        /*LOL*/         (".\\League_of_Legends.exe --skip-to-install"),
        /*Nvidia app*/  (".\\Nvidia_App.exe --silent"),
        /*Adrenalin*/   (".\\AMD_Adrenalin.exe --silent")
    },
/*#2 Media*/        {
        /*VLC*/         (".\\vlc-3.0.21-win64.exe /S"),
        /*Spotify*/     (null),
        /*WinRar*/      (".\\WinRar.exe /S"),
        /*7-zip*/       (".\\7-zip.exe /S"),
        /*Reader*/      (".\\Adobe_Reader.exe /sAll /rs /msi EULA_ACCEPT=YES"),
        /*Reader Pro*/  (null),
        /*Photoshop*/   (null),
        /*PremierePro*/ (null),
        /*Vegas Pro*/   (null),
        /*Figma*/       (".\\Figma.exe --silent"),
        /*OBS*/         (".\\OBS_Studio.exe /S"),
        /*uTorrent*/    (".\\uTorrent.exe /UNATTENDED"),
        /*qBittorrent*/ (".\\qBittorrent.exe /S"),
        /*XMind*/       (null),
        /*FreeMind*/    (".\\FreeMind.exe /SP- /VERYSILENT"),
        /*OrnLabPro*/   (null),
        /*ChemWindow*/  (null),
        /*Blender*/     (".\\Blender.msi /quiet")
    },
/*#3 Programming*/  {
        /*NotePad++*/   (".\\NotePad++.exe /S"),
        /*VS Code*/     (".\\VS_Code.exe /VERYSILENT /MERGETASKS=!runcode"),
        /*Visual Std*/  (".\\Visual_Studio.exe --quiet"),
        /*InteliJ*/     (".\\InteliJ_Community.exe /S"),
        /*PyCharm*/     (".\\PyCharm_Community.exe /S"),
        /*Eclipse*/     (".\\Eclipse.exe /S"),
        /*NetBeans*/    (".\\JDK_24.exe /s; .\\NetBeans.exe --silent"),
        /*CMDer*/       (null),
        /*Git*/         (".\\Git.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*DBeaver*/     (".\\DBeaver.exe /S /allusers"),
        /*.NET 9*/      (".\\dotnet9.exe /install /quiet /norestart"),
        /*JDK 24*/      (".\\JDK_24.exe /s"),
        /*Python 3.13*/ (".\\Python_3.13.exe /s")
    },
/*#4 Communication*/{
        /*Discord*/     (".\\Discord.exe --silent"),
        /*Telegram*/    (".\\Telegram.exe /SP- /VERYSILENT"),
        /*TeamSpeak*/   (".\\TeamSpeak.msi /quiet"),
        /*WhatsApp*/    (".\\WhatsApp.exe --silent"),
        /*Skype*/       (".\\Skype.exe /SP- /VERYSILENT /SUPERPRESSMSGBOXES /NORESTART"),
        /*MSTeams*/     (".\\MSTeams.exe --silent")
    },
/*-----------------------------------------------------------------------------------------*/
/*#5 Overview*/     {
        /*CPU-Z*/       (".\\CPU-Z.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*CCleaner*/    (".\\ccsetup635.exe /S"),
        /*Speccy*/      (".\\Speccy.exe /S"),
        /*BatteryMon*/  (".\\BatteryMon.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*WuMgr*/       (null),
        /*Revo Uninst*/ (null),
        /*HWInfo*/      (".\\hwi64.exe .\\CPU-Z.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART")
    },
/*#6 Tests*/       {
        /*FurMark*/     (".\\FurMark.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*OCCT*/        (".\\OCCT.exe /S"),
        /*MemTest86*/   (null),
        /*AIDA64*/      (".\\AIDA64.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*FanControl*/   (".\\FanControl.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*Prime95*/     (null),
        /*PowerMax*/    (".\\PowerMax.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*3DMark*/      (null),
        /*PCMark-10*/   (null)
    },
/*#7 Network*/      {
        /*AnyDesk*/     (".\\AnyDesk.exe /S"),
        /*RustDesk*/    (".\\RustDesk.exe /S"),
        /*Supremo*/     (".\\Supremo.exe /S"),
        /*HDMonitor*/   (".\\HWMonitor-Pro.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*OpenVPN*/     (".\\OpenVPNConnect.msi /quiet"),
        /*WireGuard*/   (".\\WireGuard.msi /qn /norestart"),
        /*Hamachi*/     (".\\Hamachi.msi /quiet"),
        /*Shadowsocks*/ (null),
        /*Xampp*/       (".\\XAMPP.exe --mode unattended")
    },
/*#8 OS & ISOs*/    {
        /*Windows 10*/  (null),
        /*Windows 11*/  (null),
        /*Ubuntu 24*/   (null),
        /*MediCat*/     (null),
        /*Strelec*/     (null),
        /*VirtualBox*/  (".\\VirtualBox.exe --silent")
    },
/*#9 Disk*/         {
        /*CrDiskInfo*/  (".\\CrystalDiskInfo.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*CrDiskMark*/  (".\\CrystalDiskMark.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*BackUpper*/   (null),
        /*DiskGenius*/  (".\\DiskGenius.exe /SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*SDashboard*/  (".\\Dashboard_Sandisk.exe /S"),
        /*WDDataLifeG*/ (null),
        /*HDDClone*/    (".\\HDClone.exe /S")
    },
/*#10 Protection*/  {
        /*DefenderUI*/  (".\\DefenderUI.exe SP- /VERYSILENT /SUPRESSMSGBOXES /NORESTART"),
        /*ESET*/        (".\\ESETOnlineScanner.exe /S"),
        /*MalwrBytes*/  (".\\MalwareBytes.exe /VERYSILENT /NORESTART")
    },
/*-----------------------------------------------------------------------------------------*/
/*#11 OtherApps*/   {
        /*AutoFirma*/   (".\\AutoFirma.exe /S"),
        /*Conf FNMT*/   (".\\Configurador_FNMT.exe /S"),
        /*Instld DNIe*/ (".\\Instalador_Tarjetas_DNIe.exe"),
        /*Rufus*/       (null),
        /*KMS*/         (null),
        /*Launch4j*/    (".\\Launch4j.exe /S"),
        /*r2modman*/    (null),
        /*IconViewer*/  (".\\IconViewer.exe /S"),
        /*Vencord*/     (null),
        /*WordPress*/   (null),
    },
/*#12 Files*/       {
        /*Cyberpunk*/   (null),
        /*Silent Hill*/ (null),
    }
    };

    /**
     * Resized an icon to specific size and then returns it
     * @param path stores path of the icon location
     * @param size tells which size should be the indicated icon
     * @return new resized icon
     */
    public static ImageIcon resizeIcon(String path, int size){
        try{
            BufferedImage img = ImageIO.read(new File(path));
            Image img1 = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new ImageIcon(img1);
        }catch (Exception e){
            consoleMessage("Couldn't find the icon path - " + path);
            return new ImageIcon("src/Icons/Unknown.png");
        }
    }


    /**
     * Adds new app to the list of selected apps.
     * @param new_app object of AppToDownload class that stores information about the app.
     */
    public static void addApp(AppToDownload new_app){
        for(AppToDownload app : selectedApps){
            if(app == new_app){
                System.out.println("App is already added");
                return;
            }
        }
        selectedApps.add(new_app);
    }

    static public int countSelectedApps(){
        int cont = 0;
        for(AppToDownload app : selectedApps){
            if(app != null){
                cont++;
            }
        }
        return cont;
    }

    /**
     * Remove the app from the list of selected apps.
     * @param delete_app object of AppToDownload class that stores information about the app.
     */
    public static void removeApp(AppToDownload delete_app){
        selectedApps.remove(delete_app);
    }

    /**
     * Desactivates all the buttons and then activates those who contains apps from the list of selected apps.
     * Is called when user copies created profile.
     */
    public static void desactivateButtons(){
        for(MyTabs p : MyFrame.categories){
            for(AppButton b : p.buttons){
                if(b != null && b.appToDownload != null){
                    b.setBackground(Color.WHITE);
                }
            }
        }
        for(MyTabs p : MyFrame.categories){
            for(AppButton b : p.buttons){
                if(b != null && b.appToDownload != null){
                    for(AppToDownload app : selectedApps){
                        if(Objects.equals(b.app_name, app.name)){
                            b.setBackground(Color.GREEN);
                        }
                    }
                }
            }
        }
    }

    /**
     * Method that starts the program.
     * Creates a thread that starts when application is closing. Writes the data from created profiles into the new json file.
     * @param args Arguments that program might read.
     * @throws IOException happens when json file couldn't be found or an error occurs.
     */
    public static void main(String[] args) throws IOException {
        try{
            MyFrame myFrame = new MyFrame();
        }catch (NullPointerException e){
            e.getMessage();
        }



        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                JSONArray pers = new JSONArray();
                boolean prfFound = false;
                for(Profile prf : profiles){
                    if(prf != null){
                        JSONObject per = new JSONObject();
                        per.put("name", prf.nameProfile);

                        JSONArray per_apps = new JSONArray();
                        if(prf.profiel_apps != null){
                            for(AppToDownload app : prf.profiel_apps){
                                if(app != null){
                                    JSONObject apps_app = new JSONObject();
                                    apps_app.put("app_name", app.name);
                                    apps_app.put("app_path", app.path);
                                    apps_app.put("app_icon", app.icon);
                                    apps_app.put("app_command", app.command);

                                    per_apps.put(apps_app);
                                }
                            }
                            per.put("apps", per_apps);
                            pers.put(per);
                            prfFound = true;
                        }
                    }
                }
                try {
                    FileWriter file = new FileWriter("src/profiles.json");
                    if(prfFound){
                        file.write(pers.toString());
                    }
                    file.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }, "Shutdown-thread"));
   }
}