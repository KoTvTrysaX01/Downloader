/**
 * Contains classes that provide main functions of the program.
 */
package org.example.Downloader.Functions;

/**
 * Class of AppToDownload that stores an app.
 */
public class AppToDownload {
    public String name;
    public String path;
    public String icon;
    public String command;

    /**
     * Construct an object of AppToDownload that contains data about name, path, icon and command of the application.
     * The data comes from the database in the Main class.
     * @param name Name of the app.
     * @param file File name of the app.
     * @param icon Icon location of the app.
     * @param command Command that installs the app.
     */
    public AppToDownload(String name, String file, String icon, String command){
        this.name = name;
        this.path = file;
        this.icon = icon;
        this.command = command;
    }
}
