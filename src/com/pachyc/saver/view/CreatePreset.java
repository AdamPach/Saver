package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CreatePreset extends  JDialog{
    private JButton createBut;
    private JButton cancleButton;
    private JTextField fromTextField;
    private JButton findFromBut;
    private JTextField toTextField;
    private JButton findToBut;
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel contentPanel;
    private JPanel fromPanel;
    private JPanel buttonPanel;
    private JPanel toPanel;
    private JTextField textField1;

    public CreatePreset(JFrame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Create Preset");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();

        createBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPres(e);
            }
        });
        findFromBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findFromFolder(e);
            }
        });
        findToBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findToFolder(e);
            }
        });
    }

    private void createPres(ActionEvent e){
        try{
            CopySave copySave = new CopySave(
                    this.textField1.getText(),
                    this.fromTextField.getText(),
                    this.toTextField.getText()
            );

        }
        catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(this,"Error: " + exception.getMessage());
        }
    }

    protected void findFromFolder(ActionEvent e){
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            this.fromTextField.setText(file.getPath());
        }
        catch (Exception exception){

        }
    }

    protected void findToFolder(ActionEvent e){
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            this.toTextField.setText(file.getPath());
        }
        catch (Exception exception){

        }
    }
}
