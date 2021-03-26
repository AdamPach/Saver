package com.pachyc.saver.files;


import javax.swing.*;

public class ListManager {

    private DefaultListModel<CopySave> model;
    private FileManager fileManager;

    public ListManager(){
        this.fileManager = new FileManager();
        this.model = this.fileManager.readFile();
    }

    public DefaultListModel<CopySave> getModel() {
        return model;
    }
}
