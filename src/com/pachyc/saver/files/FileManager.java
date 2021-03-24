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
        this.path = Paths.get("scr\\com\\pachyc\\saver\\files\\save");
    }

    public void createPreset(CopySave copySave){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.path.toString(), true))){
            String[] newSave= this.copySave.getSave();
            writer.write(String.join(";", newSave));
            writer.flush();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"Nový preset se nepovedlo vytvorit");
        }
    }
}
