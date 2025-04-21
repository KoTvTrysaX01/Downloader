package org.example.Interface;

public class AppToDownload {
    String name;
    String path;
    String icon;
    String command;

    public AppToDownload(String name, String file, String icon, String command){
        this.name = name;
        this.path = file;
        this.icon = icon;
        this.command = command;
    }
}
