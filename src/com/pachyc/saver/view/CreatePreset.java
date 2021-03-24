package com.pachyc.saver.view;

import javax.swing.*;

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

    public CreatePreset(JFrame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Create Preset");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();

    }
}
