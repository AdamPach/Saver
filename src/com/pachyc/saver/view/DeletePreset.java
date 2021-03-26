package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;
import com.pachyc.saver.files.ListManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePreset extends JDialog{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel chosePanel;
    private JPanel buttonsPanel;
    private JList PresetChose;
    private JPanel listPanel;
    private JButton deleteButton;
    private JButton cancleButton;
    private ListManager listManager;

    public DeletePreset(JFrame parent, boolean modal){
        //Init a Dialog
        super(parent, modal);
        this.setTitle("Delete Preset");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();

        //Set some else
        this.listManager = new ListManager();
        this.PresetChose.setModel(this.listManager.getModel());

        //Listeners
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delPreset(e);
            }
        });
        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelDialog(e);
            }
        });
    }

    private void delPreset(ActionEvent e){
        int selectedIndex = this.PresetChose.getSelectedIndex();
        CopySave copySave = this.listManager.getCopySave(selectedIndex);
        this.listManager.removeCopySave(copySave);
        dispose();
    }

    private void cancelDialog(ActionEvent e){
        dispose();
    }
}
