package com.pachyc.saver.files;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager {

    private Path path;
    private BufferedReader reader;
    private CopySave copySave;

    public FileManager(){
        this.path = Paths.get("src\\com\\pachyc\\saver\\files\\save\\save.txt");
    }

    public void createPreset(CopySave copySave, JDialog dialog){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.path.toString(), true))){
            String[] newSave= copySave.getSave();
            writer.write(String.join(";", newSave));
            writer.newLine();
            writer.flush();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(dialog,"Error: " + e.getMessage());
        }
    }
}
