package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
