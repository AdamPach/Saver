package com.pachyc.saver.files.copy;

import com.pachyc.saver.files.CopySave;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CopyManager {
    private CopySave copySave;

    public CopyManager(CopySave copySave) {
        this.copySave = copySave;
    }

    public void startCopy(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String oldPath = this.copySave.getTo().toString();
        this.copySave.setTo(new File(oldPath + File.separator + dtf.format(localDateTime)));
        if(!this.copySave.getTo().mkdirs()){
            System.out.println("Nepovedlo se vytvorit slozku");
        }
        try{
            Files.copy(this.copySave.getFrom().toPath(), this.copySave.getTo().toPath());
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void copyTree(Path source, Path target) throws IOException{
        try (
                InputStream in = new FileInputStream(source.toString());
                OutputStream out = new FileOutputStream(target.toString())
        ){
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0){
                out.write(buf, 0, length);
            }
        }
    }
}
