package com.pachyc.saver.files;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager {

    private Path path;
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

    public DefaultListModel<CopySave> readFile(){
        DefaultListModel<CopySave> newModel= new DefaultListModel<>();
        try(BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(this.path.toString())))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] cs = line.split(";");
                CopySave newCopySave = new CopySave(cs[0],cs[1],cs[2]);
                newModel.addElement(newCopySave);
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Nepovadlo se nacist soubor");
        }
        return newModel;
    }
}
