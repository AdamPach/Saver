package com.pachyc.saver.files;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileManager {

    private Path path;
    private CopySave copySave;

    public FileManager(){
        this.path = Paths.get("src"+ File.separator+ "com" + File.separator + "pachyc" + File.separator
                +"saver" + File.separator +"files" + File.separator +"save" + File.separator +"save.txt");
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

    public void deletePreset(ArrayList<CopySave> saves){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.path.toString()))){
            for (CopySave save : saves){
                writer.write(save.getFormatedSave());
                writer.newLine();
                writer.flush();
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Nepovedlo se smazat preset!");
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
