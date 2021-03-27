package com.pachyc.saver.files.copy;

import com.pachyc.saver.files.CopySave;
import com.sun.nio.sctp.SctpStandardSocketOptions;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class CopyManager {
    private CopySave copySave;

    public CopyManager(CopySave copySave) {
        this.copySave = copySave;
    }

    public void startCopy(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String oldPath = this.copySave.getTo().toString();
        this.copySave.setTo(new File(oldPath + File.separator + dtf.format(localDateTime) + File.separator + this.copySave.getFrom().getName()));
        if(!this.copySave.getTo().mkdirs()){
            System.out.println("Nepovedlo se vytvorit slozku");
        }
        try{
            copyFolder(this.copySave.getFrom().toPath(), this.copySave.getTo().toPath());
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void copyFolder(Path source, Path target) throws IOException{
        try(Stream<Path> stream = Files.walk(source)){
            stream.forEach(src -> copy(src, target.resolve(source.relativize(src))));
        }
    }

    private void copy(Path source, Path target){
        try{
            Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}
