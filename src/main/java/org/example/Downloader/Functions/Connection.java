package org.example.Downloader.Functions;

import com.jcraft.jsch.*;
import org.example.Downloader.Interface.MyFrame;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.example.Downloader.Functions.Connection.progressMonitor.cont;
import static org.example.Downloader.Interface.DownloadPanel.autoInstall;
import static org.example.Downloader.Interface.MyFrame.consoleMessage;

/**
 * Class of Connection that is responsible for connection, downloading and installing apps from the server.
 */
public class Connection{
    static String sftpHost = "79.117.45.184";
    static String sftpPort = "22";
    static String sftpUser = "vadim";
    static String sftpPassword = "123";

    /**
     * Tries to connect and download selected apps from the server.
     * @param selectedApps list of apps that were selected by the user.
     * @param localPath local folder that was chosen by the user and will store the downloaded apps.
     */
    public void tryDownload(ArrayList<AppToDownload> selectedApps, String localPath){
        try{
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            consoleMessage("------------------------------------------------");
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
            consoleMessage("------------------------------------------------");
            cont = 1;
        }catch (Exception e){
            consoleMessage("Error! Something went wrong");
            e.getMessage();
        }
    }

    /**
     * Tries to install selected apps if possible.
     * @param path local folder from where method will take files and tries to install them.
     * @param app object of AppToDownload with all the information about app.
     * @throws InterruptedException happens when the process tales to long to finish.
     */
    public void tryInstall(String path, AppToDownload app) throws InterruptedException {
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

    /**
     * Checks connection with the server
     * @throws IOException if connection could not be established.
     */
    public void checkConnection(){
        try (Socket soc = new Socket()) {
            soc.connect(new InetSocketAddress("79.117.45.184", 22), 5000);
            consoleMessage("Connection established.");
            MyFrame.topPanel.status_connection.setIcon(Main.resizeIcon("src/Icons/happy.png", 55));
        } catch (IOException ex) {
            consoleMessage("Couldn't connect to the server.");
            MyFrame.topPanel.status_connection.setIcon(Main.resizeIcon("src/Icons/sad.png", 55));
        }
    }

    /**
     * Class of progressMonitor that comes with JSch. Helps DownloadPanel class to monitor the process of downloading.
     */
    public class progressMonitor implements SftpProgressMonitor{
        private long max = 0;
        private long count = 0;
        private long percent = 0;
        public static int cont = 1;

        private String file;

        /**
         * Modified construct an object of progressMonitor. Contains string of the file path.
         * @param file name of the file that will be downloaded
         */
        public progressMonitor(String file) {
            this.file = file;
        }


        /**
         * Will be called when a new operation starts.
         * @param op a code indicating the direction of transfer, one of PUT and GET
         * @param src source file name
         * @param dest the destination file name
         * @param max the final count (i.e. length of file to transfer)
         */
        public void init(int op, java.lang.String src, java.lang.String dest, long max) {
            MyFrame.downloadPanel.text_progress.setText("Now downloading: " + cont + "/" + Main.countSelectedApps() + " " + file);
            this.max = max;
            consoleMessage("Now downloading: " + file);
        }


        /**
         * Will be called periodically as more data is transfered.
         * Updates the progress bar of the DownloadPanel object
         * @param bytes the number of bytes transferred so far
         * @return true if the transfer should go on, false if the transfer should be cancelled.
         */
        public boolean count(long bytes) {
            this.count += bytes;
            long percentNow = this.count * 100 / max;
            if (percentNow > this.percent) {
                this.percent = percentNow;
                MyFrame.downloadPanel.progressBar.setValue((int)this.percent);
            }

            return (true);
        }

        /**
         * Will be called when the transfer ended, either because all the data was transferred, or because the transfer was cancelled.
         * Write message into the console once the process is finished.
         */
        public void end() {
            consoleMessage("Finished downloading: " + file);
            MyFrame.downloadPanel.text_progress.setText("Finished: " + cont++ + "/" + Main.countSelectedApps() + " " + file);
            MyFrame.downloadPanel.download_b.setEnabled(true);
        }
    }
}
