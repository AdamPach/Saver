package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;
import com.pachyc.saver.files.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CreatePreset extends JDialog{
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
    private FileManager fileManager;

    public CreatePreset(JFrame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Create Preset");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();
        this.fileManager = new FileManager();

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
        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog(e);
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
            fileManager.createPreset(copySave, this);
        }
        catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(this,"Error: " + exception.getMessage());
        }
        this.dispose();
    }

    protected void findFromFolder(ActionEvent e){
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            this.fromTextField.setText(file.getPath());
            fileChooser = null;
        }
        catch (Exception exception){
            this.fromTextField.setText(this.fromTextField.getText());
        }
    }

    protected void findToFolder(ActionEvent e){
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            this.toTextField.setText(file.getPath());
            fileChooser = null;
        }
        catch (Exception exception){
            this.toTextField.setText("");
        }
    }

    private void closeDialog(ActionEvent e){
        dispose();
    }
}
