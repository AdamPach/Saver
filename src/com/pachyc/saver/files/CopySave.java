package com.pachyc.saver.files;

import java.io.File;

public class CopySave {

    private String title;
    private File from;
    private File to;

    public CopySave(String title,String from, String to) throws IllegalArgumentException{
        File testFrom = new File(from);
        File testTo = new File(to);
        if(title.length() < 3){
            throw new IllegalArgumentException("Kratky nazev");
        }
        if(title.indexOf(' ') >= 0 || title.indexOf(';') >= 0){
            throw new IllegalArgumentException("Spatne zadani");
        }
        if(!testFrom.isDirectory()){
            throw new IllegalArgumentException("Nezadal jsi slozku");
        }
        if(!testTo.isDirectory()){
            throw new IllegalArgumentException("Nezadal jsi slozku");
        }
        this.title = title;
        this.from = testFrom;
        this.to = testTo;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public String getFormatedSave(){
        String save;
        String[] saveThings = getSave();
        save = String.join(";", saveThings);
        return save;
    }

    public String[] getSave(){
        String[] save = new String[3];
        save[0] = this.title;
        save[1] = this.from.getPath().toString();
        save[2] = this.to.getPath().toString();
        return save;
    }

    public File getTo() {
        return to;
    }

    public void setTo(File to) {
        this.to = to;
    }

    public File getFrom() {
        return from;
    }
}
