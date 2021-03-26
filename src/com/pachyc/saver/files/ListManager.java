package com.pachyc.saver.files;


import javax.swing.*;
import java.util.Collections;

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

    public CopySave getCopySave(int index){
        return this.model.get(index);
    }

    public void removeCopySave(CopySave cs){
        this.model.removeElement(cs);
        this.fileManager.deletePreset(Collections.list(this.model.elements()));
    }
}
