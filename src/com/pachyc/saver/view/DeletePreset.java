package com.pachyc.saver.view;

import javax.swing.*;

public class DeletePreset extends JDialog{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel chosePanel;
    private JPanel buttonsPanel;
    private JList PresetChose;
    private JPanel listPanel;
    private JButton deleteButton;
    private JButton cancleButton;

    public DeletePreset(JFrame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Delete Preset");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();
    }
}
