package org.example.Interface;

import com.jcraft.jsch.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.example.Interface.Connection.progressMonitor.cont;
import static org.example.Interface.Download.autoInstall;
import static org.example.Interface.MyFrame.consoleMessage;


public class Connection{
    static String sftpHost = "79.117.45.184";
    static String sftpPort = "22";
    static String sftpUser = "vadim";
    static String sftpPassword = "123";

    public void tryConnect(ArrayList<AppToDownload> selectedApps, String localPath){
        try{
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            consoleMessage("--------------------------------------------------");
            consoleMessage("Connecting...");
            session.connect();
            consoleMessage("Connected.");

            ChannelSftp channelSftp  = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

//            Vector<ChannelSftp.LsEntry> entries = channelSftp.ls("/");
//            for (ChannelSftp.LsEntry entry : entries){
//                System.out.println(entry.getFilename());
//            }

            for(AppToDownload app : selectedApps){
                channelSftp.get("Files/" + app.path, localPath, new progressMonitor(app.name));
                if(autoInstall.isSelected()){
                    tryInstall(localPath, app);
                }
            }
            channelSftp.disconnect();
            session.disconnect();
            consoleMessage("Disconnected");
            consoleMessage("--------------------------------------------------");
            cont = 1;
        }catch (Exception e){
            consoleMessage("Error! Something went wrong");
            e.getMessage();
        }
    }

    public void tryInstall(String path, AppToDownload app) throws IOException, InterruptedException {
        consoleMessage("Now installing: " + app.name);
        Runtime rt = Runtime.getRuntime();
        if(app.command == null){
            consoleMessage(app.name + " cannot be installed.");
        }
        Process process = null;
        try {
            process = rt.exec(path + "\\" + app.command);
            try{
                process.waitFor(60, TimeUnit.SECONDS);
                if(process.exitValue() == 0){
                    consoleMessage("Installed: " + app.name);
                }else{consoleMessage("Error! " + app.name + " was not installed.");}
            }catch (NullPointerException e){
                consoleMessage("Error! " + app.name + " was not installed.");
                System.out.println(e.getMessage());
            }
        }catch (IOException e){
            consoleMessage("Error! " + app.name + " was not installed.");
            System.out.println(e.getMessage());
        }



    }

    public void checkConnection(){
        try (Socket soc = new Socket()) {
            soc.connect(new InetSocketAddress("79.117.45.184", 22), 5000);
            consoleMessage("Connection established.");
            MyFrame.image_connection.setIcon(Main.resizeIcon("src/Icons/happy.png", 55));
        } catch (IOException ex) {
            consoleMessage("Couldn't connect to the server.");
            MyFrame.image_connection.setIcon(Main.resizeIcon("src/Icons/sad.png", 55));;
        }
    }

    public class progressMonitor implements SftpProgressMonitor{
        private long max = 0;
        private long count = 0;
        private long percent = 0;
        public static int cont = 1;

        private String file;

        public progressMonitor(String file) {
            this.file = file;
        }


        public void init(int op, java.lang.String src, java.lang.String dest, long max) {
            MyFrame.downloadPanel.text_progress.setText("Now downloading: " + cont + "/" + Main.countSelectedApps() + " " + file);
            this.max = max;
            consoleMessage("Now downloading: " + file);
        }



        public boolean count(long bytes) {
            this.count += bytes;
            long percentNow = this.count * 100 / max;
            if (percentNow > this.percent) {
                this.percent = percentNow;
                MyFrame.downloadPanel.progressBar.setValue((int)this.percent);
            }

            return (true);
        }

        public void end() {
            consoleMessage("Finished downloading: " + file);
            MyFrame.downloadPanel.text_progress.setText("Finished: " + cont++ + "/" + Main.countSelectedApps() + " " + file);
            MyFrame.downloadPanel.download_b.setEnabled(true);
        }
    }
}
