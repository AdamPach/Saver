package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JButton createPreset;
    private JButton chosePreset;
    private JButton deletePreset;
    private JButton copy;
    private JLabel showCofig;
    private CopySave chosenCopySave;

    public Screen(){
        super("Saver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();
        this.copy.setEnabled(false);


        // Listneners
        createPreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPre(e);
            }
        });
        deletePreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delPre(e);
            }
        });
        chosePreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosePre(e);
            }
        });
    }

    private void createPre(ActionEvent e){
        CreatePreset createPreset = new CreatePreset(this, true);
        createPreset.setVisible(true);
        createPreset = null;
    }

    private void delPre(ActionEvent e){
        DeletePreset deletePreset = new DeletePreset(this, true);
        deletePreset.setVisible(true);
        deletePreset = null;
    }

    private void chosePre(ActionEvent e){
        try {
            ChosePreset chosePreset = new ChosePreset(this, true);
            chosePreset.setVisible(true);
            this.chosenCopySave = chosePreset.getSetPreset();
            this.showCofig.setText("Your preset: " + this.chosenCopySave);
            this.copy.setEnabled(true);
            chosePreset = null;
        }
        catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(this, "Error: " + exception.getMessage());
        }
    }
}
