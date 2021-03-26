package com.pachyc.saver.view;

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
    }

    private void createPre(ActionEvent e){
        CreatePreset createPreset = new CreatePreset(this, true);
        createPreset.setVisible(true);
    }

    private void delPre(ActionEvent e){
        DeletePreset deletePreset = new DeletePreset(this, true);
        deletePreset.setVisible(true);
    }
}
